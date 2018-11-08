package com.ulidowskia.challenges.fairrations.problem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the fairRations function below.
    static String fairRations(int[] B) {
        int score = 0;
        int even = 0;
        int notEven;
        for (int i = 0; i < B.length; i++) {
            even = getEven(B, even);
            notEven = B.length - even;
            if (notEven == 1) {
                return "NO";
            }
            score = incrementValues(B, score, i);
            even = 0;
        }
        return Integer.toString(score);
    }

    private static int getEven(int[] B, int even) {
        for (int j = 0; j < B.length; j++) {
            if (B[j] % 2 == 0) {
                even++;
            }
        }
        return even;
    }

    private static int incrementValues(int[] B, int score, int i) {
        if (B[i] % 2 != 0) {
            B[i]++;
            if (i != B.length - 1) {
                B[i + 1]++;
                score = score + 2;
            } else {
                score = score + 2;
                B[i - 1]++;
            }
        }
        return score;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] B = new int[N];

        String[] BItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < N; i++) {
            int BItem = Integer.parseInt(BItems[i]);
            B[i] = BItem;
        }

        String result = fairRations(B);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}