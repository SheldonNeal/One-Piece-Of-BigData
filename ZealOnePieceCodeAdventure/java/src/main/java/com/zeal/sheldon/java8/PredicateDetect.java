package com.zeal.sheldon.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @Author Tongle
 * @Description Predicate接口传入一个参数，返回一个布尔值
 * Created on 2020-09-09
 */
public class PredicateDetect {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 4, 67, 8);
        PredicateDetect predicateDetect = new PredicateDetect();
        list.stream().filter(num->num>10).collect(Collectors.toList()).forEach(value-> System.out.println(value));


    }
    public void isPredicate(int a , Predicate<Integer> predicate){
        predicate.test(a);
    }
}
