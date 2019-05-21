package com.threads.examples.practice5;

import java.util.concurrent.atomic.AtomicInteger;

public class Exercise2 {
    public static final int N = 1000;
    public static AtomicInteger counter1 = new AtomicInteger(0);
    public static AtomicInteger counter2 = new AtomicInteger(0);
    private static int c1;
    private static int c2;

    public static void main(String[] args) throws InterruptedException {
        final Object sync = new Object();
        Thread t0 = new Thread(new Runnable() {
            public void run() {
                process();
            }
        });
        t0.start();
        t0.join();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                process();
            }
        });
        t1.start();

        t1.join();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (sync) {
                    if (c1 - c2 > 0) {
                        System.out.println("c1 is more than c2");
                    } else if (c1 - c2 < 0) {
                        System.out.println("c2 is more than c1");
                    }
                    System.out.println("c1 is equal to c2");
                    for (int i = 0; i < N; i++) {
                        c1 = counter1.incrementAndGet();
                    }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (int i = 0; i < N; i++) {
                        c2 = counter2.incrementAndGet();
                    }
                    System.out.println("counter 1: " + c1);
                    System.out.println("counter 2: " + c2);
                }
            }
        });
        t2.start();
        t2.join();

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (sync) {
                    if (c1 - c2 > 0) {
                        System.out.println("c1 is more than c2");
                    } else if (c1 - c2 < 0) {
                        System.out.println("c2 is more than c1");
                    }
                    System.out.println("c1 is equal to c2");
                    for (int i = 0; i < N; i++) {
                        c1 = counter1.incrementAndGet();
                    }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (int i = 0; i < N; i++) {
                        c2 = counter2.incrementAndGet();
                    }
                    System.out.println("counter 1: " + c1);
                    System.out.println("counter 2: " + c2);
                }
            }
        });
        t3.start();

        t3.join();
    }

    public static void process() {
        if (c1 - c2 > 0) {
            System.out.println("c1 is more than c2");
        } else if (c1 - c2 < 0) {
            System.out.println("c2 is more than c1");
        }
        System.out.println("c1 is equal to c2");
        for (int i = 0; i < N; i++) {
            c1 = counter1.incrementAndGet();
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < N; i++) {
            c2 = counter2.incrementAndGet();
        }
        System.out.println("counter 1: " + c1);
        System.out.println("counter 2: " + c2);
    }

}
//    Создать класс с двумя отдельными счетчиками и объект этого класса.
//        Создать несколько одинаковых потоков, каждый из которых повторяет
//        следующее:
//        * сравнивает значение счетчиков и печатает результат сравнения;
//        * увеличивает первый счетчик;
//        * засыпает на 10 мсек;
//        * увеличивает второй счетчик.
//
//        Сравнить работу программы при условии, что код синхронизирован и не
//        синхронизирован.
//        Реализовать следующую схему:
//        * вначале отрабатывает один вариант;
//        * после его завершения отрабатывает другой вариант.
//        Весь вывод должен быть небольшим - всего около нескольких десятков строк.