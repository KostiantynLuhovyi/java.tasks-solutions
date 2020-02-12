package com.lugowoy.tasks.solutions.arrays.onedimensional.calculateSumOfArrayElementsLocatedBetweenMinAndMaxElementsInclusive;

import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.IndiсesCompareException;
import com.lugowoy.helper.utils.checking.CheckerArray;

/**
 * Created by Konstantin Lugowoy on 27.03.2017.
 */
public interface CalculationSumBetweenElements {

    static int calculateSumBetweenMinAndMaxElementsIndices(ArrayInts array, int indexMinElement, int indexMaxElement) {
        int resultSum = 0;
        if (CheckerArray.checkLengthInArray(array)) {
            if (indexMinElement <= indexMaxElement) {
                for (int i = indexMinElement; i <= indexMaxElement; i++) {
                    resultSum += array.get(i);
                }
            } else {
                throw new IndiсesCompareException("The index of the min value is greater or equal than the index of the max value.");
            }
        }
        return resultSum;
    }

}
