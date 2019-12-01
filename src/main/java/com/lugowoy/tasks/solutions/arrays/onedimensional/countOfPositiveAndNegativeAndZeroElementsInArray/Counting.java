package com.lugowoy.tasks.solutions.arrays.onedimensional.countOfPositiveAndNegativeAndZeroElementsInArray;

import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.checking.CheckerArray;

import java.util.Arrays;

/**
 * Created by Konstantin Lugowoy on 13-Feb-17.
 */

@FunctionalInterface
public interface Counting<T extends Number> {

    long count(ArrayInts array);

    static long countNegativeNumber(ArrayInts array) {
        long resultValue = 0;
        if (CheckerArray.checkLengthInArray(array)) {
            resultValue = Math.toIntExact(Arrays.stream(array.toArray(new int[array.size()]))
                                                .filter(value -> value < 0)
                                                .count());
        }
        return resultValue;
    }

    static long countPositiveNumber(ArrayInts array) {
        long resultValue = 0;
        if (CheckerArray.checkLengthInArray(array)) {
            resultValue = Math.toIntExact(Arrays.stream(array.toArray(new int[array.size()]))
                                                .filter(value -> value > 0)
                                                .count());

        }
        return resultValue;
    }

    static long countZero(ArrayInts array) {
        long resultValue = 0;
        if (CheckerArray.checkLengthInArray(array)) {
            resultValue = Math.toIntExact(Arrays.stream(array.toArray(new int[array.size()]))
                                                .filter(value -> value == 0)
                                                .count());
        }
        return resultValue;
    }

}
