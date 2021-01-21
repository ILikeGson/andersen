package com.andersen.multithreading.thread;

import com.andersen.multithreading.CryptEncoder;

public class ThreadChild extends Thread {

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        CryptEncoder.incrementAndWriteIntoConsole(ThreadLaunch.map.get(this.getName()));
        long end = System.currentTimeMillis();
        System.out.println("before: " + start + "\nafter: " + end + "\nthread-name: " + this.getName());
    }
}
