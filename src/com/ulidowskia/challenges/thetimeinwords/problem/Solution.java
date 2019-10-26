package com.ulidowskia.challenges.thetimeinwords.problem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.String.format;

public class Solution {


    public static String[] MINUTES_0_TO_20 = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "quarter", "sixteen", "seventeen", "eighteen", "nineteen", "twenty"};
    public static String[] HOURS_0_TO_13 = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "one"};
    public static String TO = "to";
    public static String PAST = "past";
    public static String HALF = "half";
    public static String O_CLOCK = "o' clock";
    public static String MINUTES = "minutes";
    public static String MINUTE = "minute";
    public static String EMPTY = "";

    // Complete the timeInWords function below.
    static String timeInWords(int h, int m) {
        if (m == 30) {
            return format("%s %s %s", HALF, PAST, HOURS_0_TO_13[h]);
        } else if (m == 00) {
            return format("%s %s", HOURS_0_TO_13[h], O_CLOCK);
        }
        int newMinute = m > 30 ? 60 - m : m;
        String minuteStr = newMinute > 20 ? format("%s %s", MINUTES_0_TO_20[20], MINUTES_0_TO_20[newMinute - 20]) : MINUTES_0_TO_20[newMinute];
        return format("%s %s %s",
                minuteStr,
                newMinute == 01 ? MINUTE : newMinute == 15 ? EMPTY : MINUTES,
                m > 30 ? format("%s %s", TO, HOURS_0_TO_13[h + 1]) : format("%s %s", PAST, HOURS_0_TO_13[h])).replaceAll("  ", " ");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
