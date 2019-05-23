package com.threads.examples.practice3;

import java.util.ArrayList;
import java.util.List;

public class CounterProcessor {
    public static void main(String... args) throws InterruptedException {
        Counter counter = new Counter();

        System.out.println("------------ Asynchronous -----------------");
        runThreadPool(false, 200);
//        Thread t1 = new Thread(new OurRunnable(counter, "Thread 1", false));
//        Thread t2 = new Thread(new OurRunnable(counter, "Thread 2", false));
//
//        t1.start();
//        t2.start();
//
//        t1.join();
//        t2.join();

        System.out.println("------------ Synchronous -----------------");
        runThreadPool(true, 200);
//        counter = new Counter();
//        t1 = new Thread(new OurRunnable(counter, "Thread 1", true));
//        t2 = new Thread(new OurRunnable(counter, "Thread 2", true));
//
//        t1.start();
//        t2.start();
//
//        t1.join();
//        t2.join();
    }

    private static void runThreadPool(boolean sync, int noOfThreads) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        Counter counter = new Counter();
        for (int i = 0; i < noOfThreads; i++) {
             Thread t = new Thread(new OurRunnable(counter, "Thread " + i, sync));
            threads.add(t);
            t.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }
}
