package com.lugowoy.tasks.writeProgramThatGeneratesMultiplicationTable;

/**
 * Write a program that generates a multiplication table.
 * <p>
 * Created by Konstantin Lugowoy on 27.06.2017.
 */

public class Main {

    private static final int MAX_MULTIPLICATION_NUMBER = 9;
    private static final int MIN_MULTIPLICATION_NUMBER = 1;

    public static void main(String[] args) {

        for (int i = MIN_MULTIPLICATION_NUMBER; i <= MAX_MULTIPLICATION_NUMBER; i++) {
            for (int j = MIN_MULTIPLICATION_NUMBER; j <= MAX_MULTIPLICATION_NUMBER; j++) {
                System.out.println(i + " * " + j + " = " + i * j + "     ");
            }
            System.out.println();
        }

    }

}
