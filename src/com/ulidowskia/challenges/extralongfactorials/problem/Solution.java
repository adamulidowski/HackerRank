package com.ulidowskia.challenges.extralongfactorials.problem;

import java.util.Scanner;

import static com.google.common.math.BigIntegerMath.factorial;

public class Solution {

    // Complete the extraLongFactorials function below.
    static void extraLongFactorials(int n) {
        System.out.println(factorial(n));
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        extraLongFactorials(n);

        scanner.close();
    }
}

