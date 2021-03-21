package com.lugowoy.tasks.solutions.arrays.onedimensional.countPositiveAndNegativeAndZeroElementsInArray;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.models.arrays.AbstractArray;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.Capacity;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * Created by Konstantin Lugowoy on 13-Feb-17.
 */
@FunctionalInterface
public interface Counter<T extends AbstractArray> {

    long count(@NotNull final T array);

    static int countNegativeInts(@NotNull final ArrayInts array) {
        CheckerArray.check(array, Capacity.UPPER.get());
        return Math.toIntExact(Arrays.stream(array.toArray(new int[array.size()]))
                                     .filter(value -> value < 0)
                                     .count());
    }

    static int countPositiveInts(@NotNull final ArrayInts array) {
        CheckerArray.check(array, Capacity.UPPER.get());
        return Math.toIntExact(Arrays.stream(array.toArray(new int[array.size()]))
                                     .filter(value -> value > 0)
                                     .count());
    }

    static int countZero(@NotNull final ArrayInts array) {
        CheckerArray.check(array, Capacity.UPPER.get());
        return Math.toIntExact(Arrays.stream(array.toArray(new int[array.size()]))
                                     .filter(value -> value == 0)
                                     .count());
    }

}
