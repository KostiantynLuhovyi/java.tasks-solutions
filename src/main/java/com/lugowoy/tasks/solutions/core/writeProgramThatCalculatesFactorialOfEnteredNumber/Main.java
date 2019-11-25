package com.lugowoy.tasks.writeProgramThatCalculatesFactorialOfEnteredNumber;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

/**
 * Write a program that calculates the factorial of the entered number.
 * <p>
 * Created by Konstantin Lugowoy on 05.10.2017.
 */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    private static final int MIN_BOUND = -30;
    private static final int MAX_BOUND = 30;

    public static void main(String[] args) {

        System.out.println("Enter number : ");
        System.out.println("Factorial number is : " + calculateFactorialOfEnteredNumber(READER.readLong()));

    }

    private static long calculateFactorialOfEnteredNumber(long number) {
        long result = 1;
        if ((number >= MIN_BOUND) && (number <= MAX_BOUND)) {
            if ((number == 0) || (number == 1)) {
                result = 1;
            } else if (number < 0) {
                System.out.println("Entered number is negative.");
                System.exit(0);
            } else {
                for (int i = 2; i <= number; i++) {
                    result *= i;
                }
            }
        }
        return result;
    }

}
