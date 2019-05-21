package com.threads.examples;

import java.util.concurrent.atomic.AtomicInteger;

public class Multithread4 {
    public static final int N = 10_000_000;
    public volatile static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
     Thread t0 = new Thread(new Runnable() {
         public void run() {
             for (int i = 0; i < N; i++) {
                 counter++;

             }
         }
     });
     t0.start();

     Thread t1 = new Thread(new Runnable() {
         public void run() {
             for (int i = 0; i < N; i++) {
                 counter++;

             }
         }
     });
     t1.start();

     t0.join();
     t1.join();
        System.out.println(counter);
    }
}
