package com.ulidowskia.challenges.taumandbday.problem;

import java.io.*;
import java.util.stream.IntStream;

import static java.lang.Math.min;

class Result {

    /*
     * Complete the 'taumBday' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER b
     *  2. INTEGER w
     *  3. INTEGER bc
     *  4. INTEGER wc
     *  5. INTEGER z
     */
    public static long taumBday(int b, int w, int bc, int wc, int z) {
        long originalCost = ((long)b * (long)bc) + ((long)w * (long)wc);
        long blackToWhiteCost = ((long)b * ((long)wc + (long)z)) + ((long)w * (long)wc);
        long whiteToBlackCost = ((long)w * ((long)bc + (long)z)) + ((long)b * (long)bc);
        return min(min(blackToWhiteCost, whiteToBlackCost), originalCost);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int b = Integer.parseInt(firstMultipleInput[0]);

                int w = Integer.parseInt(firstMultipleInput[1]);

                String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int bc = Integer.parseInt(secondMultipleInput[0]);

                int wc = Integer.parseInt(secondMultipleInput[1]);

                int z = Integer.parseInt(secondMultipleInput[2]);

                long result = Result.taumBday(b, w, bc, wc, z);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
