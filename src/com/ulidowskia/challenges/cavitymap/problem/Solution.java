package com.ulidowskia.challenges.cavitymap.problem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.Character.getNumericValue;

public class Solution {

    // Complete the cavityMap function below.
    static String[] cavityMap(String[] grid) {
        String[] result = grid;
        for (int i = 1; i < grid.length - 1; i++) {
            char[] current = grid[i].toCharArray();
            for (int j = 1; j < current.length - 1; j++) {
                if (isCavity(current, grid[i - 1].toCharArray(), grid[i + 1].toCharArray(), j)) {
                    current[j] = 'X';
                }
            }
            result[i] = String.valueOf(current);
        }
        return grid;
    }

    private static boolean isCavity(char[] current, char[] before, char[] after, int j) {
        if (getNumericValue(current[j - 1]) < getNumericValue(current[j]) && getNumericValue(current[j + 1]) < getNumericValue(current[j])
                && getNumericValue(before[j]) < getNumericValue(current[j]) && getNumericValue(after[j]) < getNumericValue(current[j])) {
            return true;
        } else {
            return false;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] result = cavityMap(grid);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
