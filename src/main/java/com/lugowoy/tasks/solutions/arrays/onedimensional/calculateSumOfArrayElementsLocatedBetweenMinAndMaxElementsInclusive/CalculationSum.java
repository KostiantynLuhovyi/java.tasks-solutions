package com.lugowoy.tasks.solutions.arrays.onedimensional.calculateSumOfArrayElementsLocatedBetweenMinAndMaxElementsInclusive;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.checkers.CheckerIndex;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.Capacity;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Konstantin Lugowoy on 27.03.2017.
 */
public class CalculationSum {

    public CalculationSum() {
    }

    public int calculateSumBetweenMinAndMaxElementsIndices(
            @NotNull final ArrayInts array, final int indexMinElement,
            final int indexMaxElement) {
        CheckerArray.check(array, Capacity.UPPER.get());
        CheckerIndex.checkInRange(indexMinElement, array.size());
        CheckerIndex.checkInRange(indexMaxElement, array.size());
        CheckerIndex.checkLowerLessOrEqualUpper(indexMinElement, indexMaxElement);
        int resultSum = 0;
        for (int i = indexMinElement; i <= indexMaxElement; i++) {
            resultSum += array.get(i);
        }
        return resultSum;
    }

}
