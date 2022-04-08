package com.zeal.tongle.udf;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * @Author zhangjiale <zjlsmiles@126.com>
 * @Description 简单的UDF实现，继承UDF
 * Created on 2022-04-06
 */
public class SimpleUDFExample extends UDF {

    public String evaluate(String a) {
        return  a.equals("") ? "未知" : a;
    }

}
