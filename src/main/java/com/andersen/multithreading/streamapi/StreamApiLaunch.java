package com.andersen.multithreading.streamapi;

import com.andersen.multithreading.callable.CallableImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class StreamApiLaunch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        List<Callable<Void>> tasks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            tasks.add(new CallableImpl());
        }
        stream(tasks);
        countDownLatch.countDown();
    }

    public static void stream(List<Callable<Void>> tasks) {
        tasks.parallelStream().forEach(task -> {
            try {
                task.call();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
