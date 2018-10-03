package com.ulidowskia.challenges.betweentwosets.problem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    /*
     * Complete the getTotalX function below.
     */
    static int getTotalX(int[] a, int[] b) {
        int firstToCheck = a[a.length - 1];
        int lastToCheck = b[0];
        int score = 0;
        for (int i = firstToCheck; i <= lastToCheck; i++) {
            if (checkFirstTab(a, i) && (checkSecondTab(b, i))) {
                score++;
            }
        }
        return score;
    }

    private static boolean checkFirstTab(int[] a, int checkedNumber) {
        for (int j = 0; j < a.length; j++) {
            if (checkedNumber % a[j] != 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkSecondTab(int[] b, int checkedNumber) {
        for (int j = 0; j < b.length; j++) {
            if (b[j] % checkedNumber != 0) {
                return false;
            }
        }
        return true;
    }


    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scan.nextLine().split(" ");

        int n = Integer.parseInt(nm[0].trim());

        int m = Integer.parseInt(nm[1].trim());

        int[] a = new int[n];

        String[] aItems = scan.nextLine().split(" ");

        for (int aItr = 0; aItr < n; aItr++) {
            int aItem = Integer.parseInt(aItems[aItr].trim());
            a[aItr] = aItem;
        }

        int[] b = new int[m];

        String[] bItems = scan.nextLine().split(" ");

        for (int bItr = 0; bItr < m; bItr++) {
            int bItem = Integer.parseInt(bItems[bItr].trim());
            b[bItr] = bItem;
        }

        int total = getTotalX(a, b);

        bw.write(String.valueOf(total));
        bw.newLine();

        bw.close();
    }
}
