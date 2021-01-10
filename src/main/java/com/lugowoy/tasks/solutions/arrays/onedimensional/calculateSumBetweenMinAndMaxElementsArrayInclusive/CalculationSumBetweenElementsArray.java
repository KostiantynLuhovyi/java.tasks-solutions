package com.lugowoy.tasks.solutions.arrays.onedimensional.calculateSumBetweenMinAndMaxElementsArrayInclusive;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.checkers.CheckerIndex;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.Capacity;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Konstantin Lugowoy on 27.03.2017.
 */
public class CalculationSumBetweenElementsArray {

    public CalculationSumBetweenElementsArray() {
        super();
    }

    public int calculateSumBetweenMinAndMaxInclusive(
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
