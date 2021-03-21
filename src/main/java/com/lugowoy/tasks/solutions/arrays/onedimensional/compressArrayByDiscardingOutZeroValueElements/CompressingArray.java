package com.lugowoy.tasks.solutions.arrays.onedimensional.compressArrayByDiscardingOutZeroValueElements;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.models.arrays.AbstractArray;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.Capacity;
import org.jetbrains.annotations.NotNull;

/**
 * <p>Created by Konstantin Lugowoy on 18.03.2021.
 */
@FunctionalInterface
public interface CompressingArray<T extends AbstractArray> {

    void compress(@NotNull final T array);

    static void compressByRemovingZeroElements(@NotNull final ArrayInts array) {
        CheckerArray.check(array, Capacity.UPPER.get());
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) == 0) {
                array.removeByIndex(i);
            }
        }
    }

}
