package com.lugowoy.tasks.solutions.core.determineWhetherNumberBelongsToRangeOfNumbers;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

/**
 * Enter a number on the keyboard and check if this number belongs to the range from N to M (inclusive).
 * <p>
 * Created by Konstantin Lugowoy on 11.09.2017.
 */

public class Main {

    private static final Reader READER = new Reader(new ReadingConsole());

    public static void main(String[] args) {

        System.out.println("Enter number : ");
        int number = enterNumber();

        System.out.println("Enter min bound value : ");
        int minBound = enterMinBound();

        System.out.println("Enter max bound value : ");
        int maxBound = enterMaxBound();

        Determinant determinant = Determinant::determineWhetherNumberBelongsToRangeOfNumbers;

        if (determinant.determine(number, minBound, maxBound)) {
            System.out.println("The number is in this range of numbers.");
        } else {
            System.out.println("The number is not in this range of numbers.");
        }

    }

    private static int enterNumber() {
        int number;
        while (true) {
            number = READER.readInt();
            if ((number > Integer.MIN_VALUE) && (number < Integer.MAX_VALUE)) {
                break;
            } else {
                System.out.println("Not correct value of enter number.");
                System.out.println("Min value : " + (Integer.MIN_VALUE + 1));
                System.out.println("Max value : " + (Integer.MAX_VALUE - 1));
                System.out.println("Re-enter number : ");
            }
        }
        return number;
    }

    private static int enterMinBound() {
        int minBound;
        while (true) {
            minBound = READER.readInt();
            if (minBound > Integer.MIN_VALUE) {
                break;
            } else {
                System.out.println("Not correct value of enter min bound.");
                System.out.println("Min bound value : " + (Integer.MIN_VALUE + 1));
                System.out.println("Re-enter value of min bound : ");
            }
        }
        return minBound;
    }

    private static int enterMaxBound() {
        int maxBound;
        while (true) {
            maxBound = READER.readInt();
            if (maxBound < Integer.MAX_VALUE) {
                break;
            } else {
                System.out.println("Not correct value of enter max bound.");
                System.out.println("Max bound value : " + (Integer.MAX_VALUE - 1));
                System.out.println("Re-enter value of max bound : ");
            }
        }
        return maxBound;
    }

}
