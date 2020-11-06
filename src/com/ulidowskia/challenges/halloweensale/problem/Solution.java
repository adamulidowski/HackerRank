package com.ulidowskia.challenges.halloweensale.problem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the howManyGames function below.
    static int howManyGames(int currentPrice, int reduction, int minPrice, int currentMoney) {
        int numOfGames = 0;
        while (haveEnoughMoneyToBuyNextGame(currentMoney, minPrice, currentPrice)) {
            if (currentPrice <= minPrice) {
                currentPrice = minPrice;
            }
            numOfGames++;
            currentMoney = currentMoney - currentPrice;
            currentPrice = currentPrice - reduction;
        }
        return numOfGames;
    }

    private static boolean haveEnoughMoneyToBuyNextGame(int currentMoney, int minPrice, int currentPrice) {
        return currentMoney >= minPrice && currentMoney >= currentPrice;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] pdms = scanner.nextLine().split(" ");

        int p = Integer.parseInt(pdms[0]);

        int d = Integer.parseInt(pdms[1]);

        int m = Integer.parseInt(pdms[2]);

        int s = Integer.parseInt(pdms[3]);

        int answer = howManyGames(p, d, m, s);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
