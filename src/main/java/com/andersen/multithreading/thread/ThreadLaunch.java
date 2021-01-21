package com.andersen.multithreading;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class ThreadLaunch {
    public static volatile Map<String, Resource> map = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            ThreadChild threadChild = new ThreadChild();
            threadChild.start();
        }
        latch.countDown();
    }
}
