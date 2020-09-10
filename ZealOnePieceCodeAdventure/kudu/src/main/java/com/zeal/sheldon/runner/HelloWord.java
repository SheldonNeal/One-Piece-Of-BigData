package com.zeal.sheldon.runner;

import java.util.ArrayList;
import java.util.List;

import org.apache.kudu.ColumnSchema;
import org.apache.kudu.Schema;
import org.apache.kudu.Type;
import org.apache.kudu.client.AlterTableOptions;
import org.apache.kudu.client.CreateTableOptions;
import org.apache.kudu.client.Insert;
import org.apache.kudu.client.KuduClient;
import org.apache.kudu.client.KuduException;
import org.apache.kudu.client.KuduPredicate;
import org.apache.kudu.client.KuduPredicate.ComparisonOp;
import org.apache.kudu.client.KuduScanner;
import org.apache.kudu.client.KuduSession;
import org.apache.kudu.client.KuduTable;
import org.apache.kudu.client.PartialRow;
import org.apache.kudu.client.RowError;
import org.apache.kudu.client.RowErrorsAndOverflowStatus;
import org.apache.kudu.client.RowResult;
import org.apache.kudu.client.RowResultIterator;

/**
 * @Author zhangjiale <zjlsmiles@126.com>
 * @Description kudu初尝试
 * Created on 2020-07-01
 */
public class HelloWord {
    private static final Double DEFAULT_DOUBLE = 12.345;
    public static void main(String[] args) {
        //初始化客户端
        String master="";
        KuduClient client = new KuduClient.KuduClientBuilder(master).build();
        //创建表
        //插入表
        //修改表
        //删除表

    }

    /**
     *
     * @param client
     * @param tableName
     */
    private static void createKuduTable(KuduClient client,String tableName) throws KuduException {
        //设置schema
        List<ColumnSchema> columns = new ArrayList<>(2);
        columns.add(new ColumnSchema.ColumnSchemaBuilder("key", Type.INT32).key(true).build());
        columns.add(new ColumnSchema.ColumnSchemaBuilder("value",Type.STRING).nullable(true).build());
        Schema schema = new Schema(columns);
        //设置分区 这里设置hash分区
        CreateTableOptions options = new CreateTableOptions();
        List<String> hashKeys = new ArrayList<>();
        hashKeys.add("key");
        int numBuckets = 8;
        options.addHashPartitions(hashKeys, numBuckets);

        //创建表
        client.createTable(tableName, schema, options);

        //最终关闭客户端连接
        client.shutdown();

    }

    /**
     *
     * @param client
     * @param tableName
     * @param numRows
     */
    private static void insertRows(KuduClient client,String tableName,int numRows) throws KuduException {
        //连接表 创建连接
        KuduTable kuduTable = client.openTable(tableName);
        KuduSession kuduSession = client.newSession();
        for (int i = 0; i < numRows; i++) {
            Insert insert = kuduTable.newInsert();
            PartialRow row = insert.getRow();
            row.addInt("key",i);
            if (i % 2 == 0) {
                row.setNull("value");
            } else {
                row.addString("value", "value " + i);
            }
            kuduSession.apply(insert);
        }
        //关闭连接
        kuduSession.close();

        //因为是后台线程将数据刷新到kudu中，所以需要检查插入数据过程中有没有挂起的错误
        if(kuduSession.countPendingErrors()!=0){
            System.out.println("errors when insert rows");
            RowErrorsAndOverflowStatus pendingErrors = kuduSession.getPendingErrors();
            RowError[] rowErrors = pendingErrors.getRowErrors();
            for (int i = 0; i < rowErrors.length; i++) {
                System.out.println("insert error:"+rowErrors[i]);
            }
            if(pendingErrors.isOverflowed()){
                System.out.println("error buffer overflowed: some errors were discarded");
            }
            throw new RuntimeException("\"error inserting rows to Kudu\"");
        }
        System.out.println("Inserted " + numRows + " rows");

    }

    /**
     *
     * @param client
     * @param tableName
     * @param ato
     */
    private static void alterTable(KuduClient client,String tableName, AlterTableOptions ato) throws KuduException {
        ato.addColumn("added",Type.DOUBLE, DEFAULT_DOUBLE);
        client.alterTable(tableName, ato);
    }


    /**
     *
     * @param client
     * @param tableName
     */
    private static void deleteTable(KuduClient client,String tableName) throws KuduException {
        client.deleteTable(tableName);

    }

    /**
     * 扫描表 检查插入的数据是否正常
     * @param client
     * @param tableName
     * @param numRows
     */
    private static void scanTableAndCheckResults(KuduClient client,String tableName,int numRows) throws KuduException {
        KuduTable kuduTable = client.openTable(tableName);
        Schema schema = kuduTable.getSchema();

        //
        // Scan with a predicate on the 'key' column, returning the 'value' and "added" columns.
        List<String> projectColumns = new ArrayList<>(2);
        projectColumns.add("key");
        projectColumns.add("value");
        projectColumns.add("added");
        int lowerBound = 0;
        KuduPredicate lowerPred = KuduPredicate.newComparisonPredicate(
                schema.getColumn("key"),
                ComparisonOp.GREATER_EQUAL,
                lowerBound);
        int upperBound = numRows / 2;
        KuduPredicate upperPred = KuduPredicate.newComparisonPredicate(
                schema.getColumn("key"),
                ComparisonOp.LESS,
                upperBound);
        KuduScanner scanner = client.newScannerBuilder(kuduTable)
                .setProjectedColumnNames(projectColumns)
                .addPredicate(lowerPred)
                .addPredicate(upperPred)
                .build();

        // Check the correct number of values and null values are returned, and
        // that the default value was set for the new column on each row.
        // Note: scanning a hash-partitioned table will not return results in primary key order.
        int resultCount = 0;
        int nullCount = 0;
        while (scanner.hasMoreRows()) {
            RowResultIterator results = scanner.nextRows();
            while (results.hasNext()) {
                RowResult result = results.next();
                if (result.isNull("value")) {
                    nullCount++;
                }
                double added = result.getDouble("added");
                if (added != DEFAULT_DOUBLE) {
                    throw new RuntimeException("expected added=" + DEFAULT_DOUBLE +
                            " but got added= " + added);
                }
                resultCount++;
            }
        }
        int expectedResultCount = upperBound - lowerBound;
        if (resultCount != expectedResultCount) {
            throw new RuntimeException("scan error: expected " + expectedResultCount +
                    " results but got " + resultCount + " results");
        }
        int expectedNullCount = expectedResultCount / 2 + (numRows % 2 == 0 ? 1 : 0);
        if (nullCount != expectedNullCount) {
            throw new RuntimeException("scan error: expected " + expectedNullCount +
                    " rows with value=null but found " + nullCount);
        }
        System.out.println("Scanned some rows and checked the results");

    }


}
