package com.threads.examples;

public class Multithread6 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main is daemon: " + Thread.currentThread().isDaemon());

        final Thread thread = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("new thread");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        thread.setDaemon(true);
        thread.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("new thread");
            Thread.sleep(300);
        }
    }
}