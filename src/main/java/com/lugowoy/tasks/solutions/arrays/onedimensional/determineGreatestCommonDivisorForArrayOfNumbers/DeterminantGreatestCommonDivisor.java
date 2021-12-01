package com.lugowoy.tasks.solutions.arrays.onedimensional.determineGreatestCommonDivisorForArrayOfNumbers;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.models.arrays.AbstractArray;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.Capacity;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Konstantin Lugowoy on 09.05.2018.
 */
@FunctionalInterface
public interface DeterminantGreatestCommonDivisor<T extends AbstractArray> {

    int determine(@NotNull final T t);

    static int determineGreatestCommonDivisor(@NotNull final ArrayInts array) {
        CheckerArray.check(array, Capacity.UPPER.get());
        int resultValueOfGCD = array.get(0);
        for (int i = 1; i < array.size(); i++) {
            resultValueOfGCD = determineGCDOfTwoNumbers(resultValueOfGCD, array.get(i));
        }
        return resultValueOfGCD;
    }

    private static int determineGCDOfTwoNumbers(int firstNumber, int secondNumber) {
        int resultValueOfGCD = 0;
        int moduleOfFirstNumber = Math.abs(firstNumber);
        int moduleOfSecondNumber = Math.abs(secondNumber);
        while ((moduleOfFirstNumber != 0) && (moduleOfSecondNumber != 0)) {
            int tmp = moduleOfFirstNumber % moduleOfSecondNumber;
            moduleOfFirstNumber = moduleOfSecondNumber;
            moduleOfSecondNumber = tmp;
            resultValueOfGCD = moduleOfFirstNumber;
        }
        return resultValueOfGCD;
    }

}
