package com.threads.examples.practice4;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MaxValueEvaluator {

    public List<String> createListStringFromFile() {
        List<String> lines = null;
        try {
            lines = FileUtils.readLines(new File("src/resources/part4.txt"), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public int matrixMaxValue2(List<String> list) {
        int max = 0;
        for (String el : list) {
            String[] array = el.split(" ");
            max = Integer.parseInt(array[0]);
            for (int ktr = 0; ktr < array.length; ktr++) {
                int i = Integer.parseInt(array[ktr]);
                if (i > max) {
                    max = Integer.parseInt(array[ktr]);
                }
            }
        }
        return max;
    }


}
