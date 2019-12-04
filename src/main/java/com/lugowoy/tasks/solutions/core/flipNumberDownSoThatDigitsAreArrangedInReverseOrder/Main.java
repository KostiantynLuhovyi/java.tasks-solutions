package com.lugowoy.tasks.solutions.core.flipNumberDownSoThatDigitsAreArrangedInReverseOrder;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

/**
 * An integer of any length is entered from the keyboard. It is necessary to turn this number around,
 * i.e. the numbers should be in the reverse order (for example, enter the number 1234 - the result will be 4321).
 * <p>
 * Created by Konstantin Lugowoy on 06.10.2017.
 */

public class Main {

    private static final Reader READER = new Reader(new ReadingConsole());

    public static void main(String[] args) {

        System.out.println("Enter number : ");
        int number = READER.readInt();

        Flipper flipper = Flipper::flipNumber;
        System.out.println("Result reverse number : " + flipper.flip(number));

    }


}
