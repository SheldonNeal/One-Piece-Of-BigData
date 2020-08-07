package com.zeal.sheldon.context;

import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @Author zhangjiale <zhangjiale@kuaishou.com>
 * @Description flink上下文环境的初始化
 * Created on 2020-06-10
 */
public class FlinkContext {
    /**
     * 流上下文环境
     * @return
     */
    public static StreamExecutionEnvironment getStreamExecutionEnvironment(){
        StreamExecutionEnvironment executionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment();
        return executionEnvironment;
    }

    /**
     * 批次上下文环境
     * @return
     */
    public static ExecutionEnvironment getExcutionEnvironment(){
        ExecutionEnvironment executionEnvironment = ExecutionEnvironment.getExecutionEnvironment();
        return executionEnvironment;
    }

}
