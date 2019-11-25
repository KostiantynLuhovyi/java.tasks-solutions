package com.lugowoy.tasks.determineWhetherEnteredNumberIsPrime;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

/**
 * An integer is entered from the keyboard. Determine whether it is simple.
 * A prime number is divisible without a remainder by only 1 and itself.
 * <p>
 * Created by Konstantin Lugowoy on 06.10.2017.
 */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    public static void main(String[] args) {

        System.out.println("Enter number : ");
        int number = READER.readInt();

        int count = 0;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        if (count == 0) {
            System.out.printf("Number %d is prime.", number);
        } else {
            System.out.printf("Number %d is not prime.", number);
        }

    }

}
