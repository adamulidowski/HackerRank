package com.ulidowskia.challenges.finddigits.problem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.Character.getNumericValue;
import static java.lang.Math.toIntExact;
import static java.lang.String.valueOf;

public class Solution {

    // Complete the findDigits function below.
    static int findDigits(int n) {
        return toIntExact(new String(valueOf(n)
                .toCharArray()).chars()
                .mapToObj(i -> (char) i)
                .filter(character -> (getNumericValue(character) != 0) && (n % getNumericValue(character) == 0))
                .count());
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = findDigits(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
