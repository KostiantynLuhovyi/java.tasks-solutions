package com.lugowoy.tasks.solutions.core.countNumberOfOccurrencesOfMaximumNumber;

/**
 * Created by Konstantin Lugowoy on 14.11.2016.
 */

class CountingNumbers {

    public static int countMaximumNumbers(int number) {
        int maxNumberElement = 0, countMaxNumbers = 0;
        if (number == maxNumberElement) {
            countMaxNumbers++;
        } else if (number > maxNumberElement) {
            countMaxNumbers = 1;
        }
        return countMaxNumbers;
    }

}
