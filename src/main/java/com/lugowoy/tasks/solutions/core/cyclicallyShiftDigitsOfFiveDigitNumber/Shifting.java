package com.lugowoy.tasks.solutions.core.cyclicallyShiftDigitsOfFiveDigitNumber;

/**
 * Created by Konstantin Lugowoy on 06.03.2017.
 */

@FunctionalInterface
public interface Shifting<T> {

    void shift(T t);

}
