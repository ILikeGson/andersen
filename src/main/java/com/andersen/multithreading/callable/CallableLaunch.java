package com.andersen.multithreading.callable;

import com.andersen.multithreading.Resource;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;

public class CallableLaunch {
    public static volatile Map<String, Resource> map = new HashMap<>();

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            FutureTask<Void> futureTask = new FutureTask<>(new CallableImpl());
            Thread t = new Thread(futureTask);
            t.start();
        }
        countDownLatch.countDown();
    }
}
