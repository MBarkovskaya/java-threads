package com.threads.examples.practice1;

public class ThreadLaunch {
    public static void main(String[] args) throws InterruptedException {

        PrintYourNameThread printYourNameThread = new PrintYourNameThread("PrintYourNameThread");
        printYourNameThread.start();
        printYourNameThread.join();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 4; i++) {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        System.out.println("Thread has been interrupted");
                    }
                }
            }
        });
        t1.setName("PrintYourNameThreadAgain");
        t1.start();
        t1.join();
    }
}
