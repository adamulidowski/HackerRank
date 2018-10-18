package com.ulidowskia.challenges.drawingbook.problem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    static int pageCount(int n, int p) {
        int beginning = countPagesFromBeginning(p);
        int end = countPagesFromEnd(n, p);
        return beginning < end ? beginning : end;

        //Or just:
        //return p / 2 < (n / 2 - p / 2) ? p / 2 : n / 2 - p / 2;
    }

    private static int countPagesFromBeginning(int pageNumber) {
        return pageNumber / 2;
    }

    private static int countPagesFromEnd(int numOfPages, int pageNumber) {
        return (numOfPages / 2 - pageNumber / 2);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int result = pageCount(n, p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}