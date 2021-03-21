package com.lugowoy.tasks.solutions.arrays.onedimensional.changeArrayByMultiplyingElementsByNumbersByRule;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.models.arrays.AbstractArray;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.Capacity;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Konstantin Lugowoy on 25.03.2017.
 */
@FunctionalInterface
public interface DeterminantElementArray<T extends AbstractArray> {

    int determine(@NotNull final T array);

    static int determineMinElement(@NotNull final ArrayInts array) {
        CheckerArray.check(array, Capacity.UPPER.get());
        int minNumber = Integer.MAX_VALUE;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) <= minNumber) {
                minNumber = array.get(i);
            }
        }
        return minNumber;
    }

    static int determineMaxElement(@NotNull final ArrayInts array) {
        CheckerArray.check(array, Capacity.UPPER.get());
        int maxNumber = Integer.MIN_VALUE;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) >= maxNumber) {
                maxNumber = array.get(i);
            }
        }
        return maxNumber;
    }

}

