package com.zeal.tongle.test;

import org.apache.flink.api.java.utils.MultipleParameterTool;
import org.apache.flink.api.java.utils.ParameterTool;

/**
 * @Author Tongle
 * @Description TODO
 * Created on 2020-07-27
 */
public class ParameterToolTest {
    public static void main(String[] args) {
        ParameterTool parameterTool = ParameterTool.fromArgs(args);
        System.out.println(parameterTool.get("age"));
        MultipleParameterTool multipleParameterTool = MultipleParameterTool.fromArgs(args);
        System.out.println(multipleParameterTool.getMultiParameter("user"));

    }
}
