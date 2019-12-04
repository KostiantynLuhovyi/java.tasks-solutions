package com.lugowoy.tasks.solutions.core.determineWhetherFiveDigitNumberIsPalindrome;

/**
 * Created by Konstantin Lugowoy on 14.09.2017.
 */

@FunctionalInterface
public interface Determinant {

    boolean determine(int number);

    static boolean determineWhetherFiveDigitNumberIsPalindrome(int number) {
        String numberValue = Integer.toString(number);

        int duplicateNumber = number;
        int reverseNumber = 0;

        for (int i = 0; i < numberValue.length(); i++) {
            reverseNumber = reverseNumber * 10 + (duplicateNumber % 10);
            duplicateNumber /= 10;
        }
        return number == reverseNumber;
    }

}
