package com.threads.examples.practice5;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class SymbolWriter {
    public static void main(String[] args) throws IOException, InterruptedException {
        int k = 10;
        RandomAccessFile raFile = new RandomAccessFile(String.valueOf(File.createTempFile("dataFile", ".tmp").toPath()), "rw");
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new FileDispenser(raFile));
            t.start();
        }
    }

    static class FileDispenser implements Runnable {
        String n = RandomStringUtils.randomNumeric(1);
        RandomAccessFile raFile;

        public FileDispenser(RandomAccessFile randomAccessFile) {
            this.raFile = randomAccessFile;
        }

        @Override
        public void run() {
            synchronized (raFile) {
                try {
                    raFile.seek(raFile.length());
                    for (int i = 0; i < 20; i++) {
                        raFile.write(n.getBytes());
                        Thread.sleep(1);
                    }
                    raFile.write(System.lineSeparator().getBytes());
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }
}
