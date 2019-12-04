package com.lugowoy.tasks.solutions.core.checkMultiplicityOfNumber;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

import static java.lang.Math.abs;

/**
 * Write a program to check the multiplicity of the number X by the number Y (both numbers are entered from the keyboard).
 * <p>
 * Created by Konstantin Lugowoy on 12.09.2017.
 */

public class Main {

    private static final Reader READER = new Reader(new ReadingConsole());

    public static void main(String[] args) {

        System.out.println("Enter first integer number : ");
        int xNumber = enterNumber();

        System.out.println("Enter second integer number : ");
        int yNumber = enterNumber();

        if (checkMultiplicityOfNumbers(xNumber, yNumber)) {
            System.out.printf("Number %d is multiplicity of %d number.", xNumber, yNumber);
        } else {
            System.out.printf("Number %d is not multiplicity of %d number.", xNumber, yNumber);
        }

    }

    private static int enterNumber() {
        long number;
        while (true) {
            number = READER.readInt();
            if ((number >= Integer.MIN_VALUE + 1) && (number <= Integer.MAX_VALUE - 1)) {
                break;
            } else {
                System.out.println("The value of the number is less than or greater than the allowable value.");
                System.out.println("Min value : " + Integer.MIN_VALUE);
                System.out.println("Max value : " + Integer.MAX_VALUE);
                System.out.println("Re-enter : ");
            }
        }
        return (int) number;
    }

    private static boolean checkMultiplicityOfNumbers(int xNumber, int yNumber) {
        boolean checkResult = false;
        if (abs(xNumber) % abs(yNumber) == 0) {
            checkResult = true;
        }
        return checkResult;
    }

}
