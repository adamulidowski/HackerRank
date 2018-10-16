package com.ulidowskia.challenges.dayoftheprogrammer.problem;

import java.io.*;

public class Solution {

    private static int[] MONTHS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    // Complete the dayOfProgrammer function below.
    static String dayOfProgrammer(int year) {
        boolean isLeap;
        if (year < 1918) {
            isLeap = checkJulianLeapYear(year);
            return calculateDate(year, isLeap);
        } else if (year > 1918) {
            isLeap = checkGregorianLeapYear(year);
            return calculateDate(year, isLeap);
        } else {
            return "26.09.1918";
        }
    }

    private static String calculateDate(int year, boolean isLeap) {
        int[] dayAndMonth = calculateDayAndMonth();
        int day = calculateDayOfMonthNumber(isLeap, dayAndMonth[0]);
        return (day + ".0" + dayAndMonth[1] + "." + year);
    }

    private static int[] calculateDayAndMonth() {
        int dayNumber = 0;
        int i = 0;
        while (dayNumber < 256) {
            dayNumber += MONTHS[i];
            i++;
        }
        return new int[]{dayNumber - MONTHS[i + 1], i};
    }

    private static int calculateDayOfMonthNumber(boolean isLeap, int finalScore) {
        if (isLeap) {
            finalScore++;
        }
        return 256 - finalScore;
    }

    private static boolean checkJulianLeapYear(int year) {
        if (year % 4 == 0) {
            return true;
        }
        return false;
    }

    private static boolean checkGregorianLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        }
        if ((year % 4 == 0) && (year % 100 != 0)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
