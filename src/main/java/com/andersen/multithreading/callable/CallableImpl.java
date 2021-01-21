package com.andersen.multithreading.callable;

import com.andersen.multithreading.CryptEncoder;
import com.andersen.multithreading.Resource;

import java.util.concurrent.Callable;

public class CallableImpl implements Callable<Void> {
    @Override
    public Void call() {
        long start = System.currentTimeMillis();
        CallableLaunch.map.put(Thread.currentThread().getName(), new Resource("map"));
        CryptEncoder.incrementAndWriteIntoConsole(CallableLaunch.map.get(Thread.currentThread().getName()));
        long end = System.currentTimeMillis();
        System.out.println("before: " + start + "\nafter: " + end + "\nthread-name: " + Thread.currentThread().getName());
        return null;
    }
}
