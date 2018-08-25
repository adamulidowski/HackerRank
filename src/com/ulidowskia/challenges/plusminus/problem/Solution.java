package com.ulidowskia.challenges.plusminus.problem;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Solution {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        double length = arr.length;
        double numOfPositive = 0;
        double numOfNegative = 0;
        double numOfZeros = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                numOfNegative++;
            } else if (arr[i] > 0) {
                numOfPositive++;
            } else {
                numOfZeros++;
            }
        }
        DecimalFormat df = new DecimalFormat("#.#####");
        System.out.println(df.format(numOfPositive / length));
        System.out.println(df.format(numOfNegative / length));
        System.out.println(df.format(numOfZeros / length));
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}