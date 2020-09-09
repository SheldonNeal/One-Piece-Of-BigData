package com.zeal.sheldon.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型测试
 */
public class TestGeneric {
    public static void main(String[] args) {
        List<String> stringArrayList = new ArrayList<String>();
        List<Integer> integerArrayList = new ArrayList<Integer>();

        Class classStringArrayList = stringArrayList.getClass();
        Class classIntegerArrayList = integerArrayList.getClass();

        if(classStringArrayList.equals(classIntegerArrayList)){
            System.out.println(classIntegerArrayList+"\t"+classStringArrayList);
            System.out.println("泛型测试,类型相同");
        }
    }
}
