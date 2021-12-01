package com.lugowoy.tasks.solutions.arrays.onedimensional.cyclicallyShiftElementsOfArrayElementsToRightOrLeft;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.models.arrays.AbstractArray;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.Capacity;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Konstantin Lugowoy on 19.06.2017.
 */
@FunctionalInterface
public interface Shifting {

    void shift(@NotNull final AbstractArray abstractArray, final int numberK);

    static void shiftElementsOfArrayElementsToRightOrLeft(@NotNull final AbstractArray array,
                                                          final int numberK) {
        CheckerArray.check(array, Capacity.UPPER.get());
        if (numberK > 0) {
            moveRight((ArrayInts) array, numberK);
        } else if (numberK < 0) {
            moveLeft((ArrayInts) array, numberK);
        }
    }

    private static void moveRight(ArrayInts array, int numberK) {
        while (numberK > 0) {
            int tmp = array.get(array.size() - 1);
            for (int i = array.size() - 1; i > 0; i--) {
                array.set(i, array.get(i - 1));
            }
            array.set(0, tmp);
            numberK--;
        }
    }

    private static void moveLeft(ArrayInts array, int numberK) {
        while (numberK < 0) {
            int tmp = array.get(0);
            for (int i = 0; i < array.size() - 1; i++) {
                array.set(i, array.get(i + 1));
            }
            array.set(array.size() - 1, tmp);
            numberK++;
        }
    }

}
