package com.ulidowskia.challenges.encryption.problem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.StrictMath.sqrt;

public class Solution {

    // Complete the encryption function below.
    static String encryption(String s) {
        return getFormattedString(s);
    }

    static String getFormattedString(String s) {
        int rowNumbers = (int) Math.floor(sqrt(s.length()));
        int columnNumbers = (int) Math.ceil(sqrt(s.length()));
        if ((rowNumbers * columnNumbers) < s.length()) {
            rowNumbers++;
        }
        StringBuilder sb = new StringBuilder();
        char[][] array = createArray(rowNumbers, columnNumbers, s.toCharArray());
        for (int j = 0; j < columnNumbers; j++) {
            for (int k = 0; k < rowNumbers; k++) {
                if (array[k][j] != 0) {
                    sb.append(array[k][j]);
                }
            }
            sb.append(" ");
        }
        return sb.toString();
    }

    static char[][] createArray(int rowNumbers, int columnNumbers, char[] chars) {
        int i = 0;
        char[][] array = new char[rowNumbers][columnNumbers];
        for (int j = 0; j < rowNumbers; j++) {
            for (int k = 0; k < columnNumbers; k++) {
                if (i < chars.length) {
                    array[j][k] = chars[i];
                    i++;
                }
            }
        }
        return array;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
