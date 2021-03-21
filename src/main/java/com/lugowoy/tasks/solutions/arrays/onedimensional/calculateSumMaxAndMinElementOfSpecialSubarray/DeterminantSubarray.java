package com.lugowoy.tasks.solutions.arrays.onedimensional.calculateSumMaxAndMinElementOfSpecialSubarray;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.models.arrays.AbstractArray;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.Capacity;
import org.jetbrains.annotations.NotNull;

/**
 * <p>Created by Konstantin Lugowoy on 09.01.2021.
 */
@FunctionalInterface
public interface DeterminantSubarray<T extends AbstractArray> {

    T determine(@NotNull final T array);

    static ArrayInts determineEvenSubarray(@NotNull final ArrayInts array) {
        CheckerArray.check(array, Capacity.UPPER.get());
        ArrayInts evenElementsSubarray = new ArrayInts();
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) % 2 == 0) {
                evenElementsSubarray.add(array.get(i));
            }
        }
        return evenElementsSubarray;
    }

    static ArrayInts determineOddSubarray(@NotNull final ArrayInts array) {
        CheckerArray.check(array, Capacity.UPPER.get());
        ArrayInts oddElementsSubarray = new ArrayInts();
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) % 2 != 0) {
                oddElementsSubarray.add(array.get(i));
            }
        }
        return oddElementsSubarray;
    }

}
