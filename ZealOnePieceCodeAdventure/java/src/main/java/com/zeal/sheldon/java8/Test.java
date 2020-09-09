package com.zeal.sheldon.java8;

import java.util.function.Function;

@FunctionalInterface
interface MyFunctionalInterface {
    void test();
}
public class Test{
    public static void main(String[] args) {
        Test test = new Test();
        test.test(()-> System.out.println("函数式接口-lambada表达式测试"));
        //这里先留一个疑问，不是很明白 这里的类型为什么就是这样的 类型推断？
        MyFunctionalInterface inteface = () -> {
            System.out.println("");
        };

    }
    public void test(MyFunctionalInterface myFunctionalInterface){
        System.out.println("-----");
        myFunctionalInterface.test();
        System.out.println("-----");

    }

    public int compute(int a , Function<Integer,Integer> function){
        return function.apply(a);
    }
    public int compute2(int a,Function<Integer,String> function1,
                        Function<String,Integer> function2 ){
        return function1.andThen(function2).apply(a);
    }


}
