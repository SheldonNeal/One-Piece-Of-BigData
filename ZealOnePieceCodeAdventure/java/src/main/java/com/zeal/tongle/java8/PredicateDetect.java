package com.zeal.tongle.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Author Tongle
 * @Description Predicate接口传入一个参数，返回一个布尔值
 * Created on 2020-09-09
 */
public class PredicateDetect {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 4, 67, 8);
        PredicateDetect predicateDetect = new PredicateDetect();
        predicateDetect.conditionFilter(list,num->num % 2 ==0);


    }
    public void conditionFilter(List<Integer> list , Predicate<Integer> predicate){
       for (Integer num:list){
           if(predicate.test(num)){
               System.out.println(num);
           }
       }
    }
}
