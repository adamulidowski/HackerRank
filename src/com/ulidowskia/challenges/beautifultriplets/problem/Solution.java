package com.ulidowskia.challenges.beautifultriplets.problem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the beautifulTriplets function below.
    static int beautifulTriplets(int d, int[] arr) {
        int lines = 0;
        int tempD = d;
        int score = 0;
        for (int i = 0; i <= arr.length; i++) {
            for (int j = i + 1; j <= arr.length - 1; j++) {
                if (arr[j] - arr[i] == tempD) {
                    lines++;
                    tempD = tempD * 2;
                }
                if (lines == 2) {
                    tempD = d;
                    lines = 0;
                    score++;
                }
            }
            lines = 0;
            tempD = d;
        }
        return score;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = beautifulTriplets(d, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
