package com.ulidowskia.challenges.timeconversion.problem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        if (s.contains("AM")) {
            if (s.startsWith("12")) {
                return s.replaceFirst("12", "00").substring(0, 8);
            }
            return s.substring(0, 8);
        }
        if (s.startsWith("12")) {
            return s.substring(0, 8);
        }
        return String.valueOf(parseInt(s.substring(0, 2)) + 12) + s.substring(2, 8)
                .replaceFirst("24", "12");
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
