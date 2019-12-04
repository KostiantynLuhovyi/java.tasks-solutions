package com.lugowoy.tasks.solutions.core.removeCentralDigitNumberOfThreeDigitsNumber;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

/**
 * Entered from the keyboard three-digit number and remove it from the central digit.
 * <p>
 * Created by Konstantin Lugowoy on 07-Feb-17.
 */

public class Main {

    private static final Reader READER = new Reader(new ReadingConsole());

    public static void main(String[] args) {

        System.out.println("Enter the three-digit number : ");
        int enteredNumber = READER.readInt();
        Number number = new Number(enteredNumber);

        ParserToRemove remove = new ParserToRemove();

        remove.removeCentralDigitOfTheNumber(number);

        System.out.println(number.getNumber());

    }

}
