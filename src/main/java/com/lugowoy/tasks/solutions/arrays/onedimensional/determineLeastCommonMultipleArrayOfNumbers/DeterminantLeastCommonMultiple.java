package com.lugowoy.tasks.solutions.arrays.onedimensional.determineLeastCommonMultipleArrayOfNumbers;

import com.lugowoy.helper.models.arrays.AbstractArray;
import com.lugowoy.helper.models.arrays.ArrayInts;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Konstantin Lugowoy on 09.05.2018.
 */
@FunctionalInterface
public interface DeterminantLeastCommonMultiple<T extends AbstractArray> {

    int determine(@NotNull final T t);

    static int determineLeastCommonMultiple(@NotNull final ArrayInts array) {
        int resultLeastCommonMultiple = array.get(0);
        for (int i = 1; i < array.size(); i++) {
            resultLeastCommonMultiple =
                    calculateLeastCommonMultipleTwoNumbers(array, resultLeastCommonMultiple, i);
        }
        return Math.abs(resultLeastCommonMultiple);
    }

    private static int calculateLeastCommonMultipleTwoNumbers(@NotNull final ArrayInts array,
                                                              final int resultLeastCommonMultiple,
                                                              final int i) {
        return resultLeastCommonMultiple * array.get(i)
               / calculateGreatestCommonDivisorTwoNumbers(resultLeastCommonMultiple,
                                                          array.get(i));
    }

    private static int calculateGreatestCommonDivisorTwoNumbers(
            int firstNumber, int secondNumber) {
        int resultGCD = 0;
        int moduleFirstNumber = Math.abs(firstNumber);
        int moduleSecondNumber = Math.abs(secondNumber);
        while ((moduleFirstNumber != 0) && (moduleSecondNumber != 0)) {
            int tmp = moduleFirstNumber % moduleSecondNumber;
            moduleFirstNumber = moduleSecondNumber;
            moduleSecondNumber = tmp;
            resultGCD = moduleFirstNumber;
        }
        return resultGCD;
    }

}
