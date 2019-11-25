package com.lugowoy.tasks.cyclicallyShiftDigitsOfFiveDigitNumber;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

/**
 * Enter a five-digit number and shift it cyclically to the right by N digits.
 * <p>
 * Created by Konstantin Lugowoy on 06.03.2017.
 */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    private static final int NUMBER_OF_DIGITS_FOR_SHIFT = 2;

    public static void main(String[] args) {

        Number number = new Number();
        System.out.println("Enter five-digit number : ");
        do {
            number.setNumber(READER.readInt());
        } while (number.getNumber() == -1);

        System.out.println();

        for (int i = 0; i < NUMBER_OF_DIGITS_FOR_SHIFT; i++) {
            NUMBER_SHIFTING.shift(number);
        }

        System.out.println("Result : " + number.getNumber());

    }

    private static final Shifting<Number> NUMBER_SHIFTING = number -> {
        int tmpNumber = number.getNumber() % 10;
        number.setNumber(number.getNumber() / 10);
        number.setNumber(10000 * tmpNumber + number.getNumber());
    };

}
