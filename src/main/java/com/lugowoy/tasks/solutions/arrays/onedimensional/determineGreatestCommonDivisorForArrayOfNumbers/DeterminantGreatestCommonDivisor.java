package com.lugowoy.tasks.solutions.arrays.onedimensional.determineGreatestCommonDivisorForArrayOfNumbers;

import com.lugowoy.helper.models.storages.arrays.ArrayInts;

/** Created by Konstantin Lugowoy on 09.05.2018. */

@FunctionalInterface
public interface DeterminantGreatestCommonDivisor {

    int determine(ArrayInts array);

    static int determineGreatestCommonDivisor(ArrayInts array) {
        int resultValueOfGCD = array.get(0);
        for (int i = 1; i < array.size(); i++) {
            resultValueOfGCD = determineGCDOfTwoNumbers(resultValueOfGCD, array.get(i));
        }
        return resultValueOfGCD;
    }

    private static int determineGCDOfTwoNumbers(int firstNumber, int secondNumber) {
        int resultValueOfGCD = 0;
        int moduleOfFirstNumber = Math.abs(firstNumber), moduleOfSecondNumber = Math.abs(secondNumber);
        while ((moduleOfFirstNumber != 0) && (moduleOfSecondNumber != 0)) {
            int tmp = moduleOfFirstNumber % moduleOfSecondNumber;
            moduleOfFirstNumber = moduleOfSecondNumber;
            moduleOfSecondNumber = tmp;
            resultValueOfGCD = moduleOfFirstNumber;
        }
        return resultValueOfGCD;
    }

}
