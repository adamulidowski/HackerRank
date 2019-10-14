package com.ulidowskia.challenges.cutthesticks.problem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    // Complete the cutTheSticks function below.
    static int[] cutTheSticks(int[] arr) {
        List<Integer> sticksCut = new ArrayList<>();
        int cuts = 0;
        for (int k = 0; k < 1000; k++) {
            int shortest = 1000;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < shortest && arr[i] != 0) {
                    shortest = arr[i];
                }
            }

            cuts = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= shortest) {
                    arr[i] = arr[i] - shortest;
                    cuts++;
                }
            }

            if (cuts != 0) {
                sticksCut.add(cuts);
            }
        }
        return sticksCut.stream().mapToInt(i -> i).toArray();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] result = cutTheSticks(arr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
