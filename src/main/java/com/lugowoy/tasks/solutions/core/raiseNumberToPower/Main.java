package com.lugowoy.tasks.solutions.core.raiseNumberToPower;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

/**
 * Raise the number entered in the power.
 * <p>
 * Created by Konstantin Lugowoy on 14-Dec-16.
 */

public class Main {

    private static final Reader READER = new Reader(new ReadingConsole());

    public static void main(String[] args) {

        System.out.println("Enter real number : ");
        double number = READER.readDouble();

        System.out.println("Enter number of power : ");
        double power = READER.readDouble();

        System.out.format("Result of rise the number to power is equal %.3f", Math.pow(number, power));

    }

}
