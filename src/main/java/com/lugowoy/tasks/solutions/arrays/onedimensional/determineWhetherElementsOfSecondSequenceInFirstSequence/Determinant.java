package com.lugowoy.tasks.solutions.arrays.onedimensional.determineWhetherElementsOfSecondSequenceInFirstSequence;

import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.checking.CheckerArray;

/**
 * Created by Konstantin Lugowoy on 12.04.2017.
 */
@FunctionalInterface
public interface Determinant {

    boolean determine(ArrayInts firstArray, ArrayInts secondArray);

    static boolean determineFirstArrayContainsElementsOfSecondArray(ArrayInts firstArray, ArrayInts secondArray) {
        boolean result = true;
        if (CheckerArray.checkLengthInArray(firstArray) && CheckerArray.checkLengthInArray(secondArray)) {
            for (int i = 0; i < secondArray.size(); i++) {
                if (!containsElement(firstArray, secondArray.get(i))) {
                    result = false;
                }
            }
        }
        return result;
    }

    private static boolean containsElement(ArrayInts arrayInts, int element) {
        return arrayInts.contains(element);
    }

}
