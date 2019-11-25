package com.lugowoy.tasks.determineDigitOfNumberAndTheirSum;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

/**
 * An integer of any length is entered from the keyboard. Determine the number of digits in it and their sum.
 * <p>
 * Created by Konstantin Lugowoy on 06.10.2017.
 */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    public static void main(String[] args) {

        System.out.println("Enter number : ");
        int number = enterNumber();

        Determinant<Integer> determinant = DeterminantDigitOfNumber::determineDigitInNumber;
        determinant.determine(number);

    }

    private static int enterNumber() {
        int number;
        while (true) {
            number = READER.readInt();
            if ((number > Integer.MIN_VALUE) && (number < Integer.MAX_VALUE)) {
                break;
            } else {
                System.out.println("Incorrect value. Re-enter : ");
            }
        }
        return number;
    }

}
