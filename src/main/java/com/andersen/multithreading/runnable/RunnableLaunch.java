package com.andersen.multithreading.runnable;

import com.andersen.multithreading.Resource;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class RunnableLaunch {
    public static volatile Map<String, Resource> map = new HashMap<>();
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new RunnableImpl());
            map.put(thread.getName(),new Resource("map"));
            thread.start();
        }
        countDownLatch.countDown();
    }
}
