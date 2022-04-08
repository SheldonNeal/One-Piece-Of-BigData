package com.zeal.tongle.udf;

import org.apache.hadoop.hive.ql.exec.UDFArgumentException;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDF;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;

/**
 * @Author zhangjiale <zjlsmiles@126.com>
 * @Description TODO
 * Created on 2022-04-06
 */
public class ComplexUDFExample extends GenericUDF {
    /**
     *
     * @param objectInspectors
     * @return
     * @throws UDFArgumentException
     *
     * 1. 进行参数检查（个数、类型）
     * 2. 确定返回值参数类型
     */
    @Override
    public ObjectInspector initialize(ObjectInspector[] objectInspectors) throws UDFArgumentException {
        return null;
    }

    @Override
    public Object evaluate(DeferredObject[] deferredObjects) throws HiveException {
        return null;
    }

    @Override
    public String getDisplayString(String[] strings) {
        return null;
    }
}
