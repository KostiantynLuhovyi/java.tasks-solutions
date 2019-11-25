package com.lugowoy.tasks.carryOutCyclicShiftOfEnteredNumberByCertainNumberOfDigits;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

/**
 * Carry out a circular shift to the left of the entered number by N digits
 * (for example, by shifting the number 12345 to the left by 3 digits, the number is 45123).
 * <p>
 * Created by Konstantin Lugowoy on 31.10.2017.
 */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    public static void main(String[] args) {

        System.out.println("Enter a number for a circular shift : ");
        int number = READER.readInt();

        System.out.println("Enter the number of digits to shift : ");
        int numberOfDigitToShift = READER.readInt();

        StringBuilder reverseDigit = new StringBuilder();
        for (int i = 0; i < numberOfDigitToShift; i++) {
            int tmpNumber = number % 10;
            reverseDigit.insert(0, tmpNumber);
            number /= 10;
        }

        System.out.println(number);

        int result = Integer.parseInt(reverseDigit.toString() + number);

        System.out.println("Result : " + result);


    }

}
