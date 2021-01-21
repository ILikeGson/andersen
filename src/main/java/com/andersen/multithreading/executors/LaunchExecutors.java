package com.andersen.multithreading.threadpoolexecutor;

import com.andersen.multithreading.callable.CallableImpl;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class LaunchExecutors {
    private static volatile Map<String, String> map = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        List<Callable<Void>> callables = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            callables.add(new CallableImpl());
        }
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        List<Future<Void>> futures = executorService.invokeAll(callables);

    }
}
