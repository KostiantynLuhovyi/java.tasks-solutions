package com.lugowoy.tasks.solutions.arrays.onedimensional.calculateSumBetweenMinAndMaxElementsArrayInclusive;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.models.arrays.AbstractArray;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.Capacity;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Konstantin Lugowoy on 27.03.2017.
 */
@FunctionalInterface
public interface DeterminantArrayElementIndex<T extends AbstractArray> {

    int determine(@NotNull final T t);

    static int determineMinElementIndex(@NotNull final ArrayInts array) {
        CheckerArray.check(array, Capacity.UPPER.get());
        int indexMinElement = 0;
        int tmpMinValue = Integer.MAX_VALUE;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) < tmpMinValue) {
                tmpMinValue = array.get(i);
                indexMinElement = i;
            }
        }
        return indexMinElement;
    }

    static int determineMaxElementIndex(@NotNull final ArrayInts array) {
        CheckerArray.check(array, Capacity.UPPER.get());
        int indexMaxElement = 0;
        int tmpMaxValue = Integer.MIN_VALUE;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > tmpMaxValue) {
                tmpMaxValue = array.get(i);
                indexMaxElement = i;
            }
        }
        return indexMaxElement;
    }

}
