package com.threads.examples.practice3;

public class Counter {
    private int counter1, counter2;

    public int getCounter1() {
        return counter1;
    }

    public int getCounter2() {
        return counter2;
    }

    public void incCounter1() {
        this.counter1 +=1;
    }

    public void incCounter2() {
        this.counter2 +=1;
    }

    public synchronized void incCounter1Sync() {
        this.counter1 +=1;
    }

    public synchronized void incCounter2Sync() {
        this.counter2 +=1;
    }

}
