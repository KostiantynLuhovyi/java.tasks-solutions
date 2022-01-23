package com.lugowoy.tasks.solutions.arrays.onedimensional.findIntegersInAscendingOrderThatDoesNotBelongToThisArray;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.models.arrays.AbstractArray;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.Capacity;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Konstantin Lugowoy on 11.04.2017.
 */
@FunctionalInterface
public interface Finding<T extends Number, V extends AbstractArray> {

    T find(@NotNull final V vArray);

    static Integer findMaxNumber(@NotNull final ArrayInts array) {
        int resultMaxNumber = 0;
        CheckerArray.check(array, Capacity.UPPER.get());
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > resultMaxNumber) {
                resultMaxNumber = array.get(i);
            }
        }
        return resultMaxNumber;
    }

    static Integer findMinNumber(@NotNull final ArrayInts array) {
        int resultMinNumber = 0;
        CheckerArray.check(array, Capacity.UPPER.get());
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) < resultMinNumber) {
                resultMinNumber = array.get(i);
            }
        }
        return resultMinNumber;
    }

}
