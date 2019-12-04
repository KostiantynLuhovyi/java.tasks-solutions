package com.lugowoy.tasks.solutions.core.roundNumberToTwoDecimalPlaces;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

/**
 * The user enters a fractional number from the keyboard.
 * Round it up to two decimal places and display it.
 * <p>
 * Created by Konstantin Lugowoy on 16.06.2017.
 */

public class Main {

    public static void main(String[] args) {

        double number = enterNumber();

        double resultNumber = (int) (number * 100 + 0.5) / 100.0;

        System.out.println(resultNumber);

    }

    private static double enterNumber() {
        double number;
        Reader reader = new Reader(new ReadingConsole());
        System.out.println("Enter real number : ");
        while (true) {
            number = reader.readDouble();
            if (number > 0) {
                break;
            } else {
                System.out.println("Number must be a positive number.");
                System.out.println("Re-enter : ");
            }
        }
        return number;
    }

}
