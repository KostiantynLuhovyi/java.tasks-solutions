package com.lugowoy.tasks.solutions.core.implementElementaryConsoleCalculator;

/**
 * Created by Konstantin Lugowoy on 11.09.2017.
 */

public interface CalculatorOperations {

    static RealNumber addition(RealNumber firstNumber, RealNumber secondNumber) {
        return new RealNumber(firstNumber.getNumber() + secondNumber.getNumber());
    }

    static RealNumber subtraction(RealNumber firstNumber, RealNumber secondNumber) {
        return new RealNumber(firstNumber.getNumber() - secondNumber.getNumber());
    }

    static RealNumber multiple(RealNumber firstNumber, RealNumber secondNumber) {
        return new RealNumber(firstNumber.getNumber() * secondNumber.getNumber());
    }

    static RealNumber divide(RealNumber firstNumber, RealNumber secondNumber) {
        return new RealNumber(firstNumber.getNumber() / secondNumber.getNumber());
    }

    static RealNumber remainderOfDivision(RealNumber firstNumber, RealNumber secondNumber) {
        return new RealNumber(firstNumber.getNumber() % secondNumber.getNumber());
    }

}
