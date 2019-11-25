package com.lugowoy.tasks.flipNumberDownSoThatDigitsAreArrangedInReverseOrder;

/**
 * Created by Konstantin Lugowoy on 06.10.2017.
 */

@FunctionalInterface
public interface Flipper {

    int flip(int number);

    static int flipNumber(int number) {
        int resultReverse = 0;
        while (number != 0) {
            resultReverse *= 10;
            resultReverse += number % 10;
            number /= 10;
        }
        return resultReverse;
    }


}
