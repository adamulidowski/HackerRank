package com.ulidowskia.challenges.twodarray.problem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int maxHourglass = -50;
        int hourglass = -50;
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                hourglass = arraySum(arr, i, j);
                if (hourglass > maxHourglass) {
                    maxHourglass = hourglass;
                }
            }
        }
        return maxHourglass;
    }

    private static int arraySum(int[][] arr, int i, int j) {
        return arr[i][j] + arr[i - 1][j - 1] +
                arr[i - 1][j] + arr[i - 1][j + 1] +
                arr[i + 1][j - 1] + arr[i + 1][j] +
                arr[i + 1][j + 1];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

