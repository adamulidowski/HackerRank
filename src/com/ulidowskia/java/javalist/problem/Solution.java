package com.ulidowskia.java.javalist.problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int numberOfElements = scanner.nextInt();
        List<Integer> integerList = new ArrayList<Integer>();
        fillTheList(numberOfElements, integerList);

        int numberOfQueries = scanner.nextInt();

        manageTheList(integerList, numberOfQueries);

        printList(integerList);

    }

    private static void manageTheList(List<Integer> integerList, int numberOfQueries) {
        for (int i = 0; i < numberOfQueries; i++) {
            String command = scanner.next();
            if (command.equals("Insert")) {
                insertValue(integerList);
            } else if (command.equals("Delete")) {
                removeValue(integerList);
            }
        }
    }

    private static void fillTheList(int numberOfElements, List<Integer> integerList) {
        for (int i = 0; i < numberOfElements; i++) {
            integerList.add(scanner.nextInt());
        }
    }

    private static void removeValue(List<Integer> integerList) {
        int index = scanner.nextInt();
        integerList.remove(index);
    }

    private static void insertValue(List<Integer> integerList) {
        int index = scanner.nextInt();
        int number = scanner.nextInt();
        integerList.add(index, number);
    }


    private static void printList(List<Integer> integerList) {
        for (Integer a : integerList) {
            System.out.print(a + " ");
        }
    }
}
