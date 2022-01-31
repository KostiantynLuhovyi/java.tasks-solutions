package com.lugowoy.tasks.solutions.arrays.onedimensional.outputNumbersForWhichSumOfFirstTwoDigitsIsEqualToSumOfLastTwo;

/**
 * Created by Konstantin Lugowoy on 30.05.2017.
 */
@FunctionalInterface
public interface Determinant {

    boolean determine(final int number);

    static boolean determineFirstTwoDigitsIsEqualLastTwo(final int number) {
        boolean result = false;
        int tmpNumber = number;
        String stringNumber = Integer.toString(number);
        if (stringNumber.length() == 4) {

            int rightPartNumber = number % 10;
            tmpNumber /= 10;
            rightPartNumber = rightPartNumber + number % 10;
            tmpNumber /= 10;

            int leftPartOfNumber = number % 10;
            tmpNumber /= 10;
            leftPartOfNumber += number;

            if (rightPartNumber == leftPartOfNumber) {
                result = true;
            }
        }
        return result;
    }

}
