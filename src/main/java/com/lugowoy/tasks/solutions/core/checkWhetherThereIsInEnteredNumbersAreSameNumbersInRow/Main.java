package com.lugowoy.tasks.solutions.core.checkWhetherThereIsInEnteredNumbersAreSameNumbersInRow;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

/**
 * Check whether there is in the entered numbers are the same numbers in a row.
 * <p>
 * Created by Konstantin Lugowoy on 06.10.2017.
 */

public class Main {

    private static final Reader READER = new Reader(new ReadingConsole());

    public static void main(String[] args) {

        System.out.println("Enter number : ");
        int number = READER.readInt();

        checkWhetherThereIsInEnteredNumbersAreSameNumbersInRow(number);

    }

    private static void checkWhetherThereIsInEnteredNumbersAreSameNumbersInRow(int number) {
        while (number != 0) {
            int firstTemp = number % 10;
            int secondTemp = number % 100 / 10;
            if (firstTemp == secondTemp) {
                System.out.println("Same numbers in a row are consecutive : " + firstTemp + " " + secondTemp);
                number /= 10;
            } else {
                number /= 10;
            }
        }
    }

}
