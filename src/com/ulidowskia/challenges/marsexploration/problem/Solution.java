package com.ulidowskia.challenges.marsexploration.problem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    private static int COUNTER = 0;

    // Complete the marsExploration function below.
    static int marsExploration(String s) {
        for (int i = 0; i <= s.length() - 3; i = i + 3) {
            checkLetter(s.charAt(i), 'S');
            checkLetter(s.charAt(i + 1), 'O');
            checkLetter(s.charAt(i + 2), 'S');
        }
        return COUNTER;
    }

    private static void checkLetter(char checked, char correctLetter) {
        if (!(checked == correctLetter)) {
            COUNTER++;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        int result = marsExploration(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

