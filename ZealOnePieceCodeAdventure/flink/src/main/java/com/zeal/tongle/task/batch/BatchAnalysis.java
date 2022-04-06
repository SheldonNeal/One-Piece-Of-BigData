package com.zeal.tongle.task.batch;

import java.util.Arrays;

import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zeal.tongle.context.FlinkContext;

/**
 * @Author Tongle
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
