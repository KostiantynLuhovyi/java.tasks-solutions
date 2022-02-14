package com.lugowoy.tasks.solutions.arrays.onedimensional.sortArrayInAscendingOrderWithoutChangingTheirRelativePosition;


import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.Capacity;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Konstantin Lugowoy on 14.05.2017.
 */
@FunctionalInterface
public interface Sorting {

    void sort(@NotNull final ArrayInts array);

    static void sortArrayInAscendingOrderWithoutChangingTheirRelativePosition(
            @NotNull final ArrayInts array) {
        CheckerArray.check(array, Capacity.UPPER.get());
        int tmp;
        for (int i = 0; i < array.size(); i++) {
            for (int j = 0; j < array.size() - i - 1; j++) {
                if (((array.get(j) == 0) && (array.get(j + 1) < 0))
                       || ((array.get(j) > 0) && (array.get(j + 1) <= 0))) {
                    tmp = array.get(j);
                    array.set(j, array.get(j + 1));
                    array.set(j + 1, tmp);
                }
            }
        }
    }

}
