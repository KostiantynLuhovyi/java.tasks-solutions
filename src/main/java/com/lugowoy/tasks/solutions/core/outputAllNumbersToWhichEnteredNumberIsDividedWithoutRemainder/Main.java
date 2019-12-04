package com.lugowoy.tasks.solutions.core.outputAllNumbersToWhichEnteredNumberIsDividedWithoutRemainder;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

/**
 * An integer is entered from the keyboard. Display all numbers on which the entered number is divided without a remainder.
 * For example, for 60 such numbers will be 1, 2, 3, 4, 5, 6, 10, 12, 15, 20, 30, 60.
 * <p>
 * Created by Konstantin Lugowoy on 06.10.2017.
 */

public class Main {

    private static final Reader READER = new Reader(new ReadingConsole());

    public static void main(String[] args) {

        System.out.println("Enter number : ");
        int number = READER.readInt();

        System.out.println("The numbers to divide the entered number without a remainder : ");
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                System.out.print(i + " ");
            }
        }

    }

}
