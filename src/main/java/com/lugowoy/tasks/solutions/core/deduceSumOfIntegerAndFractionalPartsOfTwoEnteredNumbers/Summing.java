package com.lugowoy.tasks.solutions.core.deduceSumOfIntegerAndFractionalPartsOfTwoEnteredNumbers;

/**
 * Created by Konstantin Lugowoy on 25.03.2017.
 */

@FunctionalInterface
public interface Summing<T> {

    T summarize(T tFirst, T tSecond);

    static Double summationIntegerPartOfTwoNumbers(Double firstNumber, Double secondNumber) {
        return (double) (firstNumber.intValue() + secondNumber.intValue());
    }

    static Double summationDigitPartOfTwoNumbers(Double firstNumber, Double secondNumber) {
        return (firstNumber - firstNumber.intValue()) + (secondNumber - secondNumber.intValue());
    }

}
