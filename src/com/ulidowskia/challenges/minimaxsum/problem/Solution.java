package com.ulidowskia.challenges.minimaxsum.problem;

import java.util.Scanner;

public class Solution {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        long max = Long.MAX_VALUE;
        long min = 0;
        long maxValue = 0;
        long minValue = 0;
        int minIndex = 0;
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > min) {
                min = arr[i];
                minIndex=i;
            }
            if (arr[i] < max) {
                max = arr[i];
                maxIndex=i;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (i != minIndex) {
                minValue+=arr[i];
            }
            if (i != maxIndex) {
                maxValue+=arr[i];
            }
        }
        System.out.println(minValue + " " + maxValue);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}