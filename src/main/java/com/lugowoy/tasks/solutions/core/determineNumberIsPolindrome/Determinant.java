package com.lugowoy.tasks.solutions.core.determineNumberIsPolindrome;

/**
 * Created by Konstantin Lugowoy on 03.09.2017.
 */

@FunctionalInterface
public interface Determinant<T> {

    boolean determine(T t);

    static boolean determineNumberIsPolindrome(int number) {
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
