package com.andersen.multithreading;

public class RunnableImpl implements Runnable{
    private static volatile int counter = 0;
    @Override
    public void run() {
        long start = System.currentTimeMillis();
        CryptEncoder.incrementAndWriteIntoConsole(RunnableLaunch.map.get(RunnableLaunch.queue.poll()));
        long end = System.currentTimeMillis();
        System.out.println("before: " + start + "\nafter: " + end + "\nthread-name: " + this.getClass().getCanonicalName());
    }
}
