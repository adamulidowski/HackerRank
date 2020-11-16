package com.ulidowskia.challenges.pangrams.problem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the pangrams function below.
    static String pangrams(String s) {
        boolean[] letters = new boolean[26];
        for (int i = 0; i < letters.length; i++) {
            if (s.toLowerCase().contains(Character.toString((char) (i + 97)))) {
                letters[i] = true;
            }
        }
        for (boolean letter : letters) {
            if (!letter) {
                return "not pangram";
            }
        }
        return "pangram";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
