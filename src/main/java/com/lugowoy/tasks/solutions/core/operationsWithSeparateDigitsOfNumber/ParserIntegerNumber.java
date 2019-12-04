package com.lugowoy.tasks.solutions.core.operationsWithSeparateDigitsOfNumber;

import java.util.InputMismatchException;

/**
 * Created by Konstantin Lugowoy on 05-Feb-17.
 */

public class ParserIntegerNumber {

    public static int getSingleDigitOfTheNumber(int number, int posDigit) {
        String digitNumber = Integer.toString(number);
        int resultSingleDigitNumber = 0;
        digitNumber = " ".concat(digitNumber);

        if (((posDigit > 0) && (posDigit <= 4))) {
            for (int i = 1; i < digitNumber.length(); i++) {
                if (i == posDigit) {
                    resultSingleDigitNumber = Character.digit(digitNumber.charAt(i), Character.MAX_RADIX);
                }
            }
        } else {
            throw new InputMismatchException(" \t \t Entered invalid index. Correct the index from 1 to 4.");
        }
        return resultSingleDigitNumber;
    }

}
