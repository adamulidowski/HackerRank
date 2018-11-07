package com.ulidowskia.challenges.pickingnumbers.problem;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int pickingNumbers(List<Integer> a) {
        int numberOfIntegers = 0;
        int maxScore = 0;
        int startNumber = 0;

        int[] array = a.stream().mapToInt(i -> i).toArray();
        Arrays.sort(array);

        int firstNumber = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] == firstNumber || array[i] == firstNumber + 1) {
                numberOfIntegers++;
            }
            if (array[i] != firstNumber) {
                startNumber = i;
            }
            if (array[i] > firstNumber + 1) {
                firstNumber = array[startNumber];
                i = startNumber;
                numberOfIntegers = 1;
            }
            if (maxScore < numberOfIntegers) {
                maxScore = numberOfIntegers;
            }
        }
        return maxScore;
    }
}


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.pickingNumbers(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}