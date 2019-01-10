package com.ulidowskia.challenges.beautifuldaysatthemovies.problem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.Math.abs;
import static java.util.stream.IntStream.range;

public class Solution {

    // Complete the beautifulDays function below.
    static int beautifulDays(int i, int j, int k) {
        return (int) range(i, j + 1).filter(value -> {
            int start = value;
            long reversedNum = getReversedNum(value);
            return (abs(start - reversedNum)) % k == 0;
        }).count();
    }

    private static long getReversedNum(int value) {
        long reversedNum = 0;
        while (value != 0) {
            reversedNum = reversedNum * 10 + value % 10;
            value = value / 10;
        }
        return reversedNum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] ijk = scanner.nextLine().split(" ");

        int i = Integer.parseInt(ijk[0]);

        int j = Integer.parseInt(ijk[1]);

        int k = Integer.parseInt(ijk[2]);

        int result = beautifulDays(i, j, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
