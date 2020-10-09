package com.zeal.sheldon.java8;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author Tongle
 * @Description TODO
 * Created on 2020-10-08
 */
public class StreamDetect {
    public static void main(String[] args) {
        Stream  stream = Stream.of("hello"," my ","world");
        /**
         * <A> A[] toArray(IntFunction<A[]> generator);
         * IntFunction<R> 的 R apply(int value) 接收一个参数，返回一个R值
         * 这里的R的泛型是A[]
         */
        stream.toArray(length->new String[length]);
        stream.toArray(String[]::new);

        stream.collect(Collectors.toList());
    }
}
