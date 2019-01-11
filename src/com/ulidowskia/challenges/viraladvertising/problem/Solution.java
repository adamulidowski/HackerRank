package com.ulidowskia.challenges.viraladvertising.problem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the viralAdvertising function below.
    static int viralAdvertising(int n) {

        int liked;
        int shared = 5;
        int cumulative = 2;

        for (int i = 1; i < n; i++) {
            shared = shared / 2 * 3;
            liked = shared / 2;
            cumulative = cumulative + liked;
        }
        return cumulative;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = viralAdvertising(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
