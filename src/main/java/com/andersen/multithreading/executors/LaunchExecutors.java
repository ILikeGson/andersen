package com.andersen.multithreading.executors;

import com.andersen.multithreading.callable.CallableImpl;

import java.util.*;
import java.util.concurrent.*;

public class LaunchExecutors {
    private static volatile Map<String, String> map = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(10);
        List<Callable<Void>> callables = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            callables.add(new CallableImpl());
        }
        //runWithSingleThread(callables);
        //runWithFixedThreadPool(callables);
        //runWithCachedThreadPool(callables);
        runWithScheduledThreadPool(callables);
        latch.countDown();
    }

    public static void runWithSingleThread(List<Callable<Void>> callables) throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        List<Future<Void>> futures = executorService.invokeAll(callables);
    }

    public static void runWithFixedThreadPool(List<Callable<Void>> callables) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        executorService.invokeAll(callables);
    }

    public static void runWithCachedThreadPool(List<Callable<Void>> callables) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.invokeAll(callables);
    }

    public static void runWithScheduledThreadPool(List<Callable<Void>> callables) throws InterruptedException {
        ExecutorService executorService = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());
        executorService.invokeAll(callables);
        executorService.shutdown();
    }
}
