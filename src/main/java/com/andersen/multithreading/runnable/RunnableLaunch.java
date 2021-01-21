package com.andersen.multithreading;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;

public class RunnableLaunch {
    public static volatile Map<String, Resource> map = new HashMap<>();
    public static ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new RunnableImpl());
            map.put("RunnableImpl" + i,new Resource("map"));
            queue.add("RunnableImpl" + i);
            thread.start();
        }
        countDownLatch.countDown();
    }
}
