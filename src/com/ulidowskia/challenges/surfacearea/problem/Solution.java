package com.ulidowskia.challenges.surfacearea.problem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the surfaceArea function below.
    static int surfaceArea(int[][] A) {
        //Top and bottom surface
        int counter = A[0].length * A.length * 2;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                //Outer surfaces:
                if (j == 0 || j == A[0].length - 1) {
                    counter = counter + A[i][j];
                }
                if (i == 0 || i == A.length - 1) {
                    counter = counter + A[i][j];
                }
                //Inner surfaces:
                if (i > 0 && A[i][j] > A[i - 1][j]) {
                    counter = counter + A[i][j] - A[i - 1][j];
                }
                if (j > 0 && A[i][j] > A[i][j - 1]) {
                    counter = counter + A[i][j] - A[i][j - 1];
                }
                if (i < A.length - 1 && A[i][j] > A[i + 1][j]) {
                    counter = counter + A[i][j] - A[i + 1][j];
                }
                if (j < A[0].length - 1 && A[i][j] > A[i][j + 1]) {
                    counter = counter + A[i][j] - A[i][j + 1];
                }
                //Additional surface in case "1" length/width
                if (A[0].length == 1) {
                    counter = counter + A[i][j];
                }
                if (A.length == 1) {
                    counter = counter + A[i][j];
                }
            }
        }
        return counter;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] HW = scanner.nextLine().split(" ");

        int H = Integer.parseInt(HW[0]);

        int W = Integer.parseInt(HW[1]);

        int[][] A = new int[H][W];

        for (int i = 0; i < H; i++) {
            String[] ARowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < W; j++) {
                int AItem = Integer.parseInt(ARowItems[j]);
                A[i][j] = AItem;
            }
        }

        int result = surfaceArea(A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}