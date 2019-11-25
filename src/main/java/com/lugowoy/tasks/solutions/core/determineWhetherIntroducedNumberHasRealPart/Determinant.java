package com.lugowoy.tasks.determineWhetherIntroducedNumberHasRealPart;

/**
 * Created by Konstantin Lugowoy on 01.10.2017.
 */

@FunctionalInterface
public interface Determinant {

    boolean determine(double number);

    static boolean determineWhetherIntroducedNumberHasRealPart(double number) {
        boolean result = false;
        double integerPartOfNumber, realPartOfNumber;

        integerPartOfNumber = (int) number;
        realPartOfNumber = number - integerPartOfNumber;

        if (realPartOfNumber != 0) {
            result = true;
        }
        return result;
    }

}
