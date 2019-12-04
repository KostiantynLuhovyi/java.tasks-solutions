package com.lugowoy.tasks.solutions.core.implementElementaryConsoleCalculator;

/**
 * Created by Konstantin Lugowoy on 11.09.2017.
 */

@FunctionalInterface
public interface Calculator {

    RealNumber calculate(RealNumber firstNumber, RealNumber secondNumber);

}
