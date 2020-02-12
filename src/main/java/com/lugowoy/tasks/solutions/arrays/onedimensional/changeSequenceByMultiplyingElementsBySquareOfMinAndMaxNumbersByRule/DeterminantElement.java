package com.lugowoy.tasks.solutions.arrays.onedimensional.changeSequenceByMultiplyingElementsBySquareOfMinAndMaxNumbersByRule;

import com.lugowoy.helper.models.storages.arrays.AbstractArray;
import com.lugowoy.helper.models.storages.arrays.ArrayDoubles;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.checking.CheckerArray;

/**
 * Created by Konstantin Lugowoy on 25.03.2017.
 */
public interface DeterminantElement<T extends AbstractArray, K extends Number> {

    K determine(T tArray);

    static double determineMinNumber(ArrayDoubles array) {
        double valueForDetermineMinNumber = Integer.MAX_VALUE;
        int indexMinNumber = 0;
        double resultFindMinNumber = 0;
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

    static double determineMaxNumber(ArrayDoubles array) {
        double valueForDetermineMaxNumber = Integer.MIN_VALUE;
        int indexMaxNumber = 0;
        double resultFindMaxNumber = 0;
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

