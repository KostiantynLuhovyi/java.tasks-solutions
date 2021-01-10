package com.lugowoy.tasks.solutions.arrays.onedimensional.compressArrayRemoveEverySecondElement;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.Capacity;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Konstantin Lugowoy on 13.03.2017.
 */
@FunctionalInterface
public interface CompressingArray {

    void compress(@NotNull final ArrayInts array);

    static void compressArrayRemoveEverySecondElement(@NotNull final ArrayInts array) {
        CheckerArray.check(array, Capacity.UPPER.get());
        for (int i = 0; i < array.size(); i++) {
            if ((i % 2 == 0) || (i == 0)) {
                array.removeByIndex(i);
            }
        }
    }

}
