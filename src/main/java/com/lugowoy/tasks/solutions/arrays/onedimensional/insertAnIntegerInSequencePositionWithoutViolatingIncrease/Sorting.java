package com.lugowoy.tasks.solutions.arrays.onedimensional.insertAnIntegerInSequencePositionWithoutViolatingIncrease;

import com.lugowoy.helper.models.storages.arrays.ArrayInts;

import java.util.Arrays;

/**
 * Created by Konstantin Lugowoy on 11.03.2017.
 */

public interface Sorting<T> {

    void sort(ArrayInts array);

    static void sortingIntegerSequence(ArrayInts array) {
        Arrays.sort(array.toArray());
    }

}
