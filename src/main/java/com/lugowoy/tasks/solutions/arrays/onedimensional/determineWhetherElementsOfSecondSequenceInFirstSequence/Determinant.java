package com.lugowoy.tasks.solutions.arrays.onedimensional.determineWhetherElementsOfSecondSequenceInFirstSequence;

import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.checking.CheckerArray;

/**
 * Created by Konstantin Lugowoy on 12.04.2017.
 */

@FunctionalInterface
public interface Determinant {

    boolean determine(ArrayInts firstArray, ArrayInts secondArray);

    static boolean determineWhetherTheElementsOfTheSecondSequenceInTheFirstSequence(ArrayInts firstArray, ArrayInts secondArray) {
        boolean result = true;
        if (CheckerArray.checkLengthInArray(firstArray) && CheckerArray.checkLengthInArray(secondArray)) {
            label:
            for (int i = 0; i < firstArray.size(); i++) {
                for (int j = 0; j < secondArray.size(); j++) {
                    if (i == j) continue label;
                    result = false;
                }
            }
        }
        return result;
    }

}
