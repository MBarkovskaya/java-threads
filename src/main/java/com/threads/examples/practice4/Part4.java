package com.threads.examples.practice4;

import java.util.List;

public class Part4 extends MaxValueEvaluator {

    public static void main(String[] args) throws InterruptedException {
        MaxValueEvaluator ev = new MaxValueEvaluator();
        Part4 part4 = new Part4();

        long startTime = System.nanoTime();
        int MAX = part4.findMaxValInLineWithThreads();
        long endTime = System.nanoTime();
        long TIME = (endTime - startTime);
        System.out.println(MAX);
        System.out.println(TIME);


        long startTime2 = System.nanoTime();
        int MAX2 = ev.matrixMaxValue2(ev.createListStringFromFile());
        long endTime2 = System.nanoTime();
        long TIME2 = (endTime2 - startTime2);
        System.out.println(MAX2);
        System.out.println(TIME2);
    }

    public int findMaxValInLineWithThreads() throws InterruptedException {
        int max = 0;
        List<String> lines = createListStringFromFile();
        Thread[] threads = new Thread[lines.size()];
        CalcRunnable[] runnables = new CalcRunnable[lines.size()];
        for (int t = 0; t < lines.size(); t++) {
            String line = lines.get(t);
            runnables[t] = new CalcRunnable(line);
            threads[t] = new Thread(runnables[t]);
            threads[t].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        for (CalcRunnable runnable : runnables) {
            if (runnable.getResult() > max) {
             max = runnable.getResult();
            }
        }
        return max;
    }

    class CalcRunnable implements Runnable {
        private final String line;
        private int result;

        public CalcRunnable(String line) {
            this.line = line;
        }

        @Override
        public void run() {
            String[] array = line.split(" ");
            result = Integer.parseInt(array[0]);
            for (int ktr = 1; ktr < array.length; ktr++) {
                int el = Integer.parseInt(array[ktr]);
                if (el > result) {
                    result = Integer.parseInt(array[ktr]);
                }
            }
        }

        public int getResult() {
            return result;
        }
    }
}
