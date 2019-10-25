package com.ulidowskia.challenges.lisasworkbook.problem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static java.util.stream.IntStream.range;

public class Solution {

    // Complete the workbook function below.
    static int workbook(int n, int k, int[] arr) {
        int numOfPages = range(0, n).map(i -> (int) Math.ceil((double) arr[i] / (double) k)).sum();

        int result = 0;
        int chapterNumber = 0;
        for (int page = 1; page <= numOfPages; page++) {
            for (int problem = 1; problem <= arr[chapterNumber]; problem++) {
                if (problem != 1 && (problem - 1) % k == 0) {
                    page++;
                }
                if (problem == page) {
                    result++;
                }
            }
            chapterNumber++;
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = workbook(n, k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
