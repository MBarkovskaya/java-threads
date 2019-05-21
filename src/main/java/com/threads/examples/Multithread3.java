package com.threads.examples;

public class Multithread3 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                System.out.println("thread 1 is started");
                for (int i = 0; i < 10; i++) {
                    System.out.println(i+1);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                System.out.println("thread 2 is started");
                for (int i = 0; i < 10; i++) {
                    System.out.println(i + 100);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

        thread1.start();
        thread2.start();
    }
}

