package com.zeal.sheldon.task.batch;

import java.util.Arrays;

import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zeal.sheldon.context.FlinkContext;

/**
 * @Author zhangjiale <zjlsmiles@126.com>
 * @Description TODO
 * Created on 2020-07-27
 */
public class BatchAnalysis {
    private static Logger LOGGER = LoggerFactory.getLogger(BatchAnalysis.class.getName());
    public static void main(String[] args) throws Exception {
        LOGGER.info("-------batch data process--------");
        ExecutionEnvironment env = FlinkContext.getExcutionEnvironment();
        DataSource<String> dataSource = env.fromCollection(Arrays.asList("zhangsan", "lisi", "wangwu"));
        dataSource.print();

    }
}
