package com.threads.examples;

public class Multithread1 {
    public static void main(String[] args) throws InterruptedException {
        Thread me = Thread.currentThread();
        me.join();
        System.out.println("main: " + me.getName());
        Thread thread = new Thread(new Runnable() {
            public void run() {
                System.out.println("run(): " + Thread.currentThread().getName());
            }
        });
        thread.start();
    }
}
