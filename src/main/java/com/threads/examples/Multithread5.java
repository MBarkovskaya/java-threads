package com.threads.examples;

import java.util.concurrent.atomic.AtomicInteger;

public class Multithread5 {
    public static final int N = 10_000_000;
    public static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread t0 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < N; i++) {
                    counter.incrementAndGet();

                }
            }
        });
        t0.start();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < N; i++) {
                    counter.incrementAndGet();
                }
            }
        });
        t1.start();

        t0.join();
        t1.join();
        System.out.println(counter);
    }
}
