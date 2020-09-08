package com.zeal.sheldon.task.java8;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @Author zhangjiale <zhangjiale@kuaishou.com>
 * @Description Lambda表达式的学习
 * Created on 2020-09-08
 * Lambda表达式传递的是行为
 */
public class FunctionDetect {
    public static void main(String[] args) {
        FunctionDetect functionDetect = new FunctionDetect();
        functionDetect.compute(10,num-> num + 1);
        functionDetect.compute(10,num->num * num);

        functionDetect.composeDetect(10,num->num + 1,num->num * num);
        functionDetect.addThenDetect(10,num->num + 1,num->num * num);

        //BiFunction实现加减乘除 传递行为
        functionDetect.computeBiFunction(5,3,(a,b)-> a + b);
        functionDetect.computeBiFunction(5,3,(a,b)-> a - b);
        functionDetect.computeBiFunction(5,3,(a,b)-> a * b);
        functionDetect.computeBiFunction(5,3,(a,b)-> a / b);

        functionDetect.addThenBiFunction(3,2,(a,b)-> a * b,num->num * num);

    }

    /**
     * Function函数式接口只接收一个参数
     * @param num
     * @param function
     */
    public void compute(int num, Function<Integer,Integer> function){
        System.out.println(function.apply(num));
        System.out.println("------------------");
    }

    /**
     * compose方法：
     * 先调用传入的Function，再调用当前的Function
     */
    public void composeDetect(int num,Function<Integer,Integer> function1,
            Function<Integer,Integer> function2){
        System.out.println(function1.compose(function2).apply(num));
        System.out.println("****************");
    }

    /**
     * addThen：
     * 先调用当前的Function,再调用传入的Function
     */
    public void addThenDetect(int num,Function<Integer,Integer> function1,
            Function<Integer,Integer> function2){
        System.out.println(function1.andThen(function2).apply(num));
        System.out.println("****************");
    }

    /**
     * BiFunction传入两个参数，返回一个值
     * @param a
     * @param b
     * @param biFunction
     */
    public void computeBiFunction(int a,int b, BiFunction<Integer, Integer,Integer> biFunction){
        System.out.println(biFunction.apply(a, b));
        System.out.println("------------------");
    }

    /**
     * BiFunction只有addThen方法
     * @param a
     * @param b
     * @param function
     */
    public void addThenBiFunction(int a,int b,BiFunction<Integer,Integer,Integer> biFunction,
            Function<Integer,Integer> function){
        System.out.println(biFunction.andThen(function).apply(a,b));
    }


}
