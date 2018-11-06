package com.ulidowskia.challenges.formingamagicsquare.problem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {

        int scores[] = {0, 0, 0, 0, 0, 0, 0, 0};

        firstPossibility(s, scores);
        secondPossibility(s, scores);
        thirdPossibility(s, scores);
        fourthPossibility(s, scores);
        fifthPossibility(s, scores);
        sixthPossibility(s, scores);
        seventhPossibility(s, scores);
        eighthPossibility(s, scores);

        return Arrays.stream(scores).min().getAsInt();
    }

    private static void firstPossibility(int[][] s, int[] scores) {
        scores[0] += Math.abs(4 - s[0][0]);
        scores[0] += Math.abs(9 - s[0][1]);
        scores[0] += Math.abs(2 - s[0][2]);
        scores[0] += Math.abs(3 - s[1][0]);
        scores[0] += Math.abs(5 - s[1][1]);
        scores[0] += Math.abs(7 - s[1][2]);
        scores[0] += Math.abs(8 - s[2][0]);
        scores[0] += Math.abs(1 - s[2][1]);
        scores[0] += Math.abs(6 - s[2][2]);
    }

    private static void secondPossibility(int[][] s, int[] scores) {
        scores[1] += Math.abs(8 - s[0][0]);
        scores[1] += Math.abs(3 - s[0][1]);
        scores[1] += Math.abs(4 - s[0][2]);
        scores[1] += Math.abs(1 - s[1][0]);
        scores[1] += Math.abs(5 - s[1][1]);
        scores[1] += Math.abs(9 - s[1][2]);
        scores[1] += Math.abs(6 - s[2][0]);
        scores[1] += Math.abs(7 - s[2][1]);
        scores[1] += Math.abs(2 - s[2][2]);
    }

    private static void thirdPossibility(int[][] s, int[] scores) {
        scores[2] += Math.abs(6 - s[0][0]);
        scores[2] += Math.abs(1 - s[0][1]);
        scores[2] += Math.abs(8 - s[0][2]);
        scores[2] += Math.abs(7 - s[1][0]);
        scores[2] += Math.abs(5 - s[1][1]);
        scores[2] += Math.abs(3 - s[1][2]);
        scores[2] += Math.abs(2 - s[2][0]);
        scores[2] += Math.abs(9 - s[2][1]);
        scores[2] += Math.abs(4 - s[2][2]);
    }

    private static void fourthPossibility(int[][] s, int[] scores) {
        scores[3] += Math.abs(2 - s[0][0]);
        scores[3] += Math.abs(7 - s[0][1]);
        scores[3] += Math.abs(6 - s[0][2]);
        scores[3] += Math.abs(9 - s[1][0]);
        scores[3] += Math.abs(5 - s[1][1]);
        scores[3] += Math.abs(1 - s[1][2]);
        scores[3] += Math.abs(4 - s[2][0]);
        scores[3] += Math.abs(3 - s[2][1]);
        scores[3] += Math.abs(8 - s[2][2]);
    }

    private static void fifthPossibility(int[][] s, int[] scores) {
        scores[4] += Math.abs(8 - s[0][0]);
        scores[4] += Math.abs(1 - s[0][1]);
        scores[4] += Math.abs(6 - s[0][2]);
        scores[4] += Math.abs(3 - s[1][0]);
        scores[4] += Math.abs(5 - s[1][1]);
        scores[4] += Math.abs(7 - s[1][2]);
        scores[4] += Math.abs(4 - s[2][0]);
        scores[4] += Math.abs(9 - s[2][1]);
        scores[4] += Math.abs(2 - s[2][2]);
    }

    private static void sixthPossibility(int[][] s, int[] scores) {
        scores[5] += Math.abs(4 - s[0][0]);
        scores[5] += Math.abs(3 - s[0][1]);
        scores[5] += Math.abs(8 - s[0][2]);
        scores[5] += Math.abs(9 - s[1][0]);
        scores[5] += Math.abs(5 - s[1][1]);
        scores[5] += Math.abs(1 - s[1][2]);
        scores[5] += Math.abs(2 - s[2][0]);
        scores[5] += Math.abs(7 - s[2][1]);
        scores[5] += Math.abs(6 - s[2][2]);
    }

    private static void seventhPossibility(int[][] s, int[] scores) {
        scores[6] += Math.abs(2 - s[0][0]);
        scores[6] += Math.abs(9 - s[0][1]);
        scores[6] += Math.abs(4 - s[0][2]);
        scores[6] += Math.abs(7 - s[1][0]);
        scores[6] += Math.abs(5 - s[1][1]);
        scores[6] += Math.abs(3 - s[1][2]);
        scores[6] += Math.abs(6 - s[2][0]);
        scores[6] += Math.abs(1 - s[2][1]);
        scores[6] += Math.abs(8 - s[2][2]);
    }

    private static void eighthPossibility(int[][] s, int[] scores) {
        scores[7] += Math.abs(6 - s[0][0]);
        scores[7] += Math.abs(7 - s[0][1]);
        scores[7] += Math.abs(2 - s[0][2]);
        scores[7] += Math.abs(1 - s[1][0]);
        scores[7] += Math.abs(5 - s[1][1]);
        scores[7] += Math.abs(9 - s[1][2]);
        scores[7] += Math.abs(8 - s[2][0]);
        scores[7] += Math.abs(3 - s[2][1]);
        scores[7] += Math.abs(4 - s[2][2]);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }

        int result = formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
