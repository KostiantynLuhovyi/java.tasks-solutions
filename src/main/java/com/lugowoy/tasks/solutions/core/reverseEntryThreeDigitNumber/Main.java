package com.lugowoy.tasks.reverseEntryThreeDigitNumber;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

/**
 * Key in three-digit number and "reverse" it.
 * <p>
 * Created by Konstantin Lugowoy on 03-Feb-17.
 */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    public static void main(String[] args) {

        System.out.println("Enter the three-digit number : ");
        int number = READER.readInt();

        while (true) {
            if (number > 999 || number < 102) {
                System.out.println("Not correct the three-digit number.");
                System.out.println("Re-enter : ");
                number = READER.readInt();
            } else {
                Reverse reverse = ReverseService::reverse;
                System.out.printf("Result : %d", reverse.reverse(number));
                break;
            }
        }

    }

}
