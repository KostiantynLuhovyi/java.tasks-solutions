package com.lugowoy.tasks.solutions.arrays.onedimensional.cyclicallyShiftElementsOfArrayElementsToRightOrLeft;

import com.lugowoy.helper.models.storages.arrays.AbstractArray;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.checking.CheckerArray;

/**
 * Created by Konstantin Lugowoy on 19.06.2017.
 */

@FunctionalInterface
public interface Shifting {

    void shift(AbstractArray abstractArray, int numberK);

    static void shiftElementsOfArrayElementsToRightOrLeft(AbstractArray array, int numberK) {
        if (CheckerArray.checkLengthInArray(array)) {
            if (numberK > 0) {
                moveRight((ArrayInts) array, numberK);
            } else if (numberK < 0) {
                moveLeft((ArrayInts) array, numberK);
            }
        }
    }

    static void moveRight(ArrayInts array, int numberK) {
        for (int i = 0; i < numberK; i++) {
            int tmp = array.get(array.size() - 1);
            System.arraycopy(array.toArray(), 0, array.toArray(), 1, array.size() - 1);
            array.set(0, tmp);
        }
    }

    static void moveLeft(ArrayInts array, int numberK) {
        for (int i = 0; i < Math.abs(numberK); i++) {
            int tmp = array.get(0);
            System.arraycopy(array.toArray(), 1, array.toArray(), 0, array.size() - 1);
            array.set(array.toArray().length - 1, tmp);
        }
    }

}
