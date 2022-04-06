package com.zeal.tongle.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author Tongle
 * @Description TODO
 * Created on 2020-10-08
 */
public class StreamDetect {
    public static void main(String[] args) {
//        Stream stream = getStream();
//        processStream();
        collectDetect();
    }

    /**
     * collect方法源码阅读
     *  <R> R collect(Supplier<R> supplier,
                        BiConsumer<R, ? super T> accumulator,
                        BiConsumer<R, R> combiner);
     */
    private static void collectDetect() {
        Stream<String> stream = Arrays.stream(new String[]{"hello","my","world"});
        List<String> lists1 = stream.collect(Collectors.toList());
        //使用原始的collect方法实现转换为List
        //lambda表达式实现
        ArrayList<String> lists2 = stream.collect(() -> new ArrayList<String>(), (list, str) -> list.add(str),
                (list1, list2) -> list1.addAll(list2));
        //方法引用实现
        ArrayList<Object> list3 = stream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    private static void processStream() {
        IntStream intStream = IntStream.range(3, 8);
        int sum = intStream.map(num -> num * 2).filter(num -> num > 2).sum();
        System.out.println("求和："+ sum);
        OptionalInt reduce = IntStream.range(3, 8).reduce((a, b) -> a + b);
        reduce.ifPresent(value -> System.out.println(value));
    }

    /**
     *
     * 获取流的几种方式
     * @return
     */
    private static Stream getStream() {
//        Stream.of(new Array[3]);
//        Arrays.asList(1,2).stream();
//        Arrays.stream(new int[]{2,4,5});
        Stream stream = Stream.of("hello", " my ", "world");
        /**
         * <A> A[] toArray(IntFunction<A[]> generator);
         * IntFunction<R> 的 R apply(int value) 接收一个参数，返回一个R值
         * 这里的R的泛型是A[]
         */
        stream.toArray(length -> new String[length]);
        stream.toArray(String[]::new);
        stream.collect(Collectors.toList());

        return stream;
    }
}
