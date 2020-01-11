package com.lugowoy.tasks.solutions.arrays.onedimensional.calculateSumOfArrayElementsLocatedBetweenMinAndMaxElementsInclusive;

import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.checking.CheckerArray;
import com.lugowoy.helper.utils.checking.CheckerIndex;

/**
 * Created by Konstantin Lugowoy on 27.03.2017.
 */
@FunctionalInterface
public interface Determinant {

    int determine(ArrayInts array);

    static int determineMinElementIndex(ArrayInts array) {
        int indexMinElement = 0, valueForDetermineMinElementIndex = Integer.MAX_VALUE;
        if (CheckerArray.checkLengthInArray(array)) {
            for (int i = 0; i < array.size(); i++) {
                if (array.get(i) < valueForDetermineMinElementIndex) {
                    valueForDetermineMinElementIndex = array.get(i);
                    indexMinElement = i;
                }
            }
        }
        return indexMinElement;
    }

    static int determineMaxElementIndex(ArrayInts array) {
        int indexMaxElement = 0, valueForDetermineMaxElementIndex = Integer.MIN_VALUE;
        if (CheckerArray.checkLengthInArray(array)) {
            for (int i = 0; i < array.size(); i++) {
                if (array.get(i) > valueForDetermineMaxElementIndex) {
                    valueForDetermineMaxElementIndex = array.get(i);
                    indexMaxElement = i;
                }
            }
        }
        return indexMaxElement;
    }

}
