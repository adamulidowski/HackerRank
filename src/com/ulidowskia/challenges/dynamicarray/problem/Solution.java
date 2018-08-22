package com.ulidowskia.challenges.dynamicarray.problem;

/**
 * Created by Adam on 22.08.2018.
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the dynamicArray function below.
    static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        List<Integer> results = new ArrayList<>();
        List<List<Integer>> seqList = createLists(n);
        int lastAnswer = 0;
        int seqNumber = 0;
        for (List q :queries) {
            if ((int)q.get(0) == 1) {
                seqNumber = (((int)q.get(1) ^ lastAnswer) % n);
                seqList.get(seqNumber).add((int)q.get(2));
            } else {
                seqNumber = (((int)q.get(1) ^ lastAnswer) % n);
                lastAnswer = seqList.get(seqNumber).get((int)q.get(2) % seqList.get(seqNumber).size());
                results.add(lastAnswer);
            }
        }
        return results;
    }

    private static List<List<Integer>> createLists(int n) {
        List<List<Integer>> seqList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            seqList.add(new ArrayList<>());
        }
        return seqList;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nq = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nq[0]);

        int q = Integer.parseInt(nq[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = dynamicArray(n, queries);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
