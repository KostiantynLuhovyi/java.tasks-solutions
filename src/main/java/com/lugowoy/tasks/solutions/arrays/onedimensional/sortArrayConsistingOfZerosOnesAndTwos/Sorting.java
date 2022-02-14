package com.lugowoy.tasks.solutions.arrays.onedimensional.sortArrayConsistingOfZerosOnesAndTwos;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.models.arrays.AbstractArray;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.Capacity;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Konstantin Lugowoy on 17.06.2017.
 */
@FunctionalInterface
public interface Sorting<T extends AbstractArray> {

    void sort(@NotNull final T tArray);

    static void sortArray(@NotNull final ArrayInts array) {
        CheckerArray.check(array, Capacity.UPPER.get());
        int index = 0;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) == 0) {
                swapElements(array, index, i);
                ++index;
            }
        }
        for (int i = index; i < array.size(); i++) {
            if (array.get(i) == 1) {
                swapElements(array, index, i);
                ++index;
            }
        }
    }

    static void swapElements(@NotNull final ArrayInts array, final int concreteIndex, final int iteratorIndex) {
        int temp = array.get(iteratorIndex);
        array.set(iteratorIndex, array.get(concreteIndex));
        array.set(concreteIndex, temp);
    }

}
