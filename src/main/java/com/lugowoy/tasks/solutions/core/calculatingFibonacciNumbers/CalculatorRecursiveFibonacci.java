package com.lugowoy.tasks.calculatingFibonacciNumbers;

/**
 * Created by Konstantin Lugowoy on 02.09.2017.
 */

public class CalculatorRecursiveFibonacci extends CalculatorFibonacciNumbers {

    @Override
    public int calculatingPositiveFibonacci(int number) {
        int result;
        if (number >= 0) {
            if (number == 0) {
                result = 0;
            } else if (number == 1) {
                result = 1;
            } else {
                result = calculatingPositiveFibonacci(number - 1) + calculatingPositiveFibonacci(number - 2);
            }
        } else {
            throw new IllegalArgumentException("Incorrect value of argument. Value must be a positive number.");
        }
        return result;
    }

    @Override
    public int calculatingNegativeFibonacci(int number) {
        int result;
        if (number <= 0) {
            if (number == 0) {
                result = 0;
            } else if (number == -1) {
                result = 1;
            } else {
                result = calculatingNegativeFibonacci(number + 2) - calculatingNegativeFibonacci(number + 1);
            }
        } else {
            throw new IllegalArgumentException("Incorrect value of argument. Value must be a negative number.");
        }
        return result;
    }

}
