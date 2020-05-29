package com.zeal.sheldon.task;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;

/**
 * @Author zhangjiale <zhangjiale@kuaishou.com>
 * @Description TODO
 * Created on 2020-05-21
 */
public class StopWatchTest {
    public static void main(String[] args) throws InterruptedException {
        //自动启动
        Stopwatch stopwatch = Stopwatch.createStarted();
        Thread.sleep(1000);
        stopwatch.stop();
        System.out.println("代码执行时长："+stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }
}
