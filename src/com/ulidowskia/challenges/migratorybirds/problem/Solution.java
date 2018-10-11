package com.ulidowskia.challenges.migratorybirds.problem;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the migratoryBirds function below.
    static int migratoryBirds(List<Integer> arr) {

        int[] tab = countNumbers(arr);
        return getResult(tab);
    }

    private static int[] countNumbers(List<Integer> arr) {
        int tab[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (Integer a : arr) {
            switch (a) {
                case(1): tab[0]++; break;
                case(2): tab[1]++; break;
                case(3): tab[2]++; break;
                case(4): tab[3]++; break;
                case(5): tab[4]++; break;
                case(6): tab[5]++; break;
                case(7): tab[6]++; break;
                case(8): tab[7]++; break;
                case(9): tab[8]++; break;
            }
        }
        return tab;
    }

    private static int getResult(int[] tab) {
        int min = 0;
        int result = 0;
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] > min) {
                min = tab[i];
                result = i + 1;
            }
        }
        return result;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}