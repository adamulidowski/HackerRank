package com.ulidowskia.challenges.equalizethearray.problem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

public class Solution {

    // Complete the equalizeArray function below.
    static int equalizeArray(int[] arr) {

        List<Integer> intList = Arrays.stream(arr)
                .boxed()
                .collect(toList());

        Map<Integer, Long> numOfInts = intList.stream().collect(groupingBy(Function.identity(), counting()));
        Integer key = Collections.max(numOfInts.entrySet(), Map.Entry.comparingByValue()).getKey();

        return (int) intList.stream().filter(integer -> integer != key).count();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = equalizeArray(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
