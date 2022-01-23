package com.lugowoy.tasks.solutions.arrays.onedimensional.insertIntegerInSequencePositionWithoutViolatingIncrease;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.Capacity;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Konstantin Lugowoy on 11.03.2017.
 */
@FunctionalInterface
public interface Inserting {

    void insert(@NotNull final ArrayInts array, final int element);

    static void insertElement(@NotNull final ArrayInts array, final int element) {
        CheckerArray.check(array, Capacity.UPPER.get());
        for (int i = 1; i < array.size(); i++) {
            if ((array.get(i - 1) <= element) && (element <= array.get(i))) {
                array.add(i, element);
                break;
            } else if (element <= array.get(i)) {
                array.add(i - 1, element);
                break;
            } else if ((element >= array.get(i - 1)) && (element <= array.get(i))) {
                array.add(i, element);
                break;
            } else if (element >= array.get(array.size() - 1)) {
                array.add(array.size(), element);
                break;
            }
        }
    }

}
