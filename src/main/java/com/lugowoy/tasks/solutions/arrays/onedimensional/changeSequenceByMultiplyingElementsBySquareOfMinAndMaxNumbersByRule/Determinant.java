package com.lugowoy.tasks.solutions.arrays.onedimensional.changeSequenceByMultiplyingElementsBySquareOfMinAndMaxNumbersByRule;

import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.checking.CheckerArray;

/**
 * Created by Konstantin Lugowoy on 25.03.2017.
 */
public interface Determinant<T> {

    int determine(ArrayInts array);

    static int determineMinNumber(ArrayInts array) {
        int valueForDetermineMinNumber = Integer.MAX_VALUE;
        int indexMinNumber = 0, resultFindMinNumber;
        if (CheckerArray.checkLengthInArray(array)) {
            for (int i = 0; i < array.size(); i++) {
                if (array.get(i) <= valueForDetermineMinNumber) {
                    valueForDetermineMinNumber = array.get(i);
                    indexMinNumber = i;
                }
            }
        }
        resultFindMinNumber = array.get(indexMinNumber);
        return resultFindMinNumber;
    }

    static int determineMaxNumber(ArrayInts array) {
        int valueForDetermineMaxNumber = Integer.MIN_VALUE;
        int indexMaxNumber = 0, resultFindMaxNumber;
        if (CheckerArray.checkLengthInArray(array)) {
            for (int i = 0; i < array.size(); i++) {
                if (array.get(i) >= valueForDetermineMaxNumber) {
                    valueForDetermineMaxNumber = array.get(i);
                    indexMaxNumber = i;
                }
            }
        }
        resultFindMaxNumber = array.get(indexMaxNumber);
        return resultFindMaxNumber;
    }

}

