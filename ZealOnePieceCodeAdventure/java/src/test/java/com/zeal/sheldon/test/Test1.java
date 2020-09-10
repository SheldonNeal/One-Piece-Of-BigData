package com.zeal.sheldon.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Tongle
 * @Description TODO
 * Created on 2020-07-20
 */
public class Test1 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1211","33rw");
        for (Map.Entry<String,String> enty: map.entrySet()) {
            System.out.println(enty.getValue());
        }
    }
}
