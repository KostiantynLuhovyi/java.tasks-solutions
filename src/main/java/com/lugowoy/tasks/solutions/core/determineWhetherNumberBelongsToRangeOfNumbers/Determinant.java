package com.lugowoy.tasks.solutions.core.determineWhetherNumberBelongsToRangeOfNumbers;

/**
 * Created by Konstantin Lugowoy on 11.09.2017.
 */

@FunctionalInterface
public interface Determinant {

    boolean determine(int number, int minBound, int maxBound);

    static boolean determineWhetherNumberBelongsToRangeOfNumbers(int number, int minBound, int maxBound) {
        boolean result = false;
        if ((number >= minBound) && (number <= maxBound)) {
            result = true;
        }
        return result;
    }

}
