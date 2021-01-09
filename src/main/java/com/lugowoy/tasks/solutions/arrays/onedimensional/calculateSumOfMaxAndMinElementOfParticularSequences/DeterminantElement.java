package com.lugowoy.tasks.solutions.arrays.onedimensional.calculateSumOfMaxAndMinElementOfParticularSequences;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.models.arrays.AbstractArray;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.Capacity;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Konstantin Lugowoy on 01.03.2017.
 */
@FunctionalInterface
public interface DeterminantElement<T extends AbstractArray> {

    int determine(@NotNull T array);

    static int determineMaxElement(@NotNull final ArrayInts array) {
        CheckerArray.check(array, Capacity.UPPER.get());
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > result) {
                result = array.get(i);
            }
        }
        return result;
    }

    static int determineMinElement(@NotNull final ArrayInts array) {
        CheckerArray.check(array, Capacity.UPPER.get());
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) < result) {
                result = array.get(i);
            }
        }
        return result;
    }

}
