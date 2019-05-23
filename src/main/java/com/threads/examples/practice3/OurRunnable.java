package com.threads.examples.practice3;

public class OurRunnable implements Runnable {

    private final String name;
    private final Counter counter;
    private final boolean incSynchronously;

    public OurRunnable(Counter counter, String name, boolean incSynchronously) {
        this.name = name;
        this.counter = counter;
        this.incSynchronously = incSynchronously;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i ++) {
            if (counter.getCounter1() > counter.getCounter2()) {
                System.out.println(String.format("%1$s - counter 1(%2$d) GREATGER than counter 2(%3$d)", name, counter.getCounter1(), counter.getCounter2()));
            } else if (counter.getCounter1() < counter.getCounter2()) {
                System.out.println(String.format("%1$s - counter 1(%2$d) LESS than counter 2(%3$d)", name, counter.getCounter1(), counter.getCounter2()));
            } else {
                System.out.println(String.format("%1$s - counter 1(%2$d) EQUAL to counter 2(%3$d)", name, counter.getCounter1(), counter.getCounter2()));
            }

            if (incSynchronously) {
                counter.incCounter1Sync();
            } else {
                counter.incCounter1();
            }
            try {
                Thread.sleep(10);
                if (incSynchronously) {
                    counter.incCounter2Sync();
                } else {
                    counter.incCounter2();
                }
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
