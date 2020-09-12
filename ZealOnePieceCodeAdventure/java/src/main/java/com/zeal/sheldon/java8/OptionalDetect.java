package com.zeal.sheldon.java8;

import java.util.Optional;

/**
 * @Author Tongle
 * @Description Optional接口
 * 空值的处理判断
 * Created on 2020-09-12
 */
public class OptionalDetect {
    public static void main(String[] args) {
        OptionalDetect optionalDetect = new OptionalDetect();
        String str = "hello";
        Optional optional = Optional.of(str);
        optional.ifPresent(value-> System.out.println(value));
        System.out.println("--------------------");
        String str2 = null;
        Optional optional2 = Optional.ofNullable(str2);
        optional2.ifPresent(value-> System.out.println(value));
        System.out.println("-----------------");
        System.out.println(optional2.orElse("world"));
        System.out.println(optional2.orElseGet(()->"else"));



    }
}
