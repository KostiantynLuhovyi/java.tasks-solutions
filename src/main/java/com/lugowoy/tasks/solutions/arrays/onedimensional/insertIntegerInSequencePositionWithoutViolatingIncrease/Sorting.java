package com.lugowoy.tasks.solutions.arrays.onedimensional.insertIntegerInSequencePositionWithoutViolatingIncrease;

import com.lugowoy.helper.models.arrays.ArrayInts;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * Created by Konstantin Lugowoy on 11.03.2017.
 */
public interface Sorting {

    void sort(@NotNull final ArrayInts array);

    static void sortingIntegerArray(@NotNull final ArrayInts array) {
        int[] ints = array.toArray();
        Arrays.sort(ints);
        array.setArray(ints);
    }

}
