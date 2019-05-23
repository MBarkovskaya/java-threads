package com.threads.examples.practice4;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MatrixCreator {
    public static void main(String[] args) {
        MatrixCreator matrixCreator = new MatrixCreator();
        matrixCreator.writeMatrixToFile(4, 100);
    }

    public void writeMatrixToFile(int noOfLines, int noOfColumns) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("src/resources/part4.txt")))) {
            for (int i = noOfLines; i > 0; i--) {
                String data = RandomStringUtils.randomNumeric(2, 3) + " ";
                int j = 1;
                do {
                    data += RandomStringUtils.randomNumeric(2, 3) + " ";
                    j++;
                }
                while (j < noOfColumns - 1);
                data += RandomStringUtils.randomNumeric(3) + System.lineSeparator();
                bw.write(data);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

