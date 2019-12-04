package com.lugowoy.tasks.solutions.core.determineNumberOfDigitsInNumber;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

/**
 * Enter an integer (no more than 4 digits!). Determine the number of digits in it.
 * <p>
 * Created by Konstantin Lugowoy on 13.09.2017.
 */

public class Main {

    private static final Reader READER = new Reader(new ReadingConsole());

    public static void main(String[] args) {

        int countDigitOfNumber = 0;

        System.out.println("Enter a number from 0 to 9999 : ");
        while (true) {
            int number = READER.readInt();
            if ((number >= 0) && (number <= 9999)) {
                while (number > 0) {
                    number /= 10;
                    countDigitOfNumber++;
                }
                System.out.printf("The number of digits in the number is : %d", countDigitOfNumber);
                break;
            } else {
                System.out.println("Incorrect number value. Re-enter : ");
            }
        }


    }

}
