package com.andersen.multithreading;

public class ThreadChild extends Thread {

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        synchronized (ThreadLaunch.class) {
            ThreadLaunch.map.put(this.getName(), new Resource("password"));
        }
        CryptEncoder.incrementAndWriteIntoConsole(ThreadLaunch.map.get(this.getName()));
        long end = System.currentTimeMillis();
        System.out.println("before: " + start + "\nafter: " + end + "\nthread-name: " + this.getName());
    }
}
