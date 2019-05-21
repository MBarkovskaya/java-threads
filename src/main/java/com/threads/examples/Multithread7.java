package com.threads.examples;

public class Multithread7 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("new thread");
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        thread.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("main thread");
            Thread.sleep(300);
        }
        thread.join();
        for (int i = 0; i < 5; i++) {
            System.out.println("main 2 thread");
            Thread.sleep(300);
        }
    }
}
