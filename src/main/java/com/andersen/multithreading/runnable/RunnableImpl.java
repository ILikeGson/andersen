package com.andersen.multithreading.runnable;

import com.andersen.multithreading.CryptEncoder;

public class RunnableImpl implements Runnable{
    private static volatile int counter = 0;
    @Override
    public void run() {
        long start = System.currentTimeMillis();
        CryptEncoder.incrementAndWriteIntoConsole(RunnableLaunch.map.get(Thread.currentThread().getName()));
        long end = System.currentTimeMillis();
        System.out.println("before: " + start + "\nafter: " + end + "\nthread-name: " + Thread.currentThread().getName());
    }
}
