package com.lugowoy.tasks.solutions.arrays.onedimensional.findSubsetOfContiguousElementsOfArraySumOfValuesOfElementsWhichIsEqualToNumber;

import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.checking.CheckerArray;

import java.util.Arrays;

/**
 * Created by Konstantin Lugowoy on 18.06.2017.
 */
@FunctionalInterface
public interface Finding {

    int[] find(ArrayInts arrayInts, int number);

    static int[] findSubsetOfContiguousElementsOfArraySumOfValuesOfElementsWhichIsEqualToNumber(ArrayInts array, int number) {
        int[] resultArray = null;
        if (CheckerArray.checkLengthInArray(array)) {
            int sum = array.get(0);
            int i = 0, j = 1;
            while (j < array.size()) {
                if (sum < number) {
                    sum += array.get(j++);
                } else if (sum > number) {
                    sum -= array.get(i++);
                } else {
                    resultArray = Arrays.copyOfRange(array.toArray(new int[array.size()]), i, j);
                    break;
                }
            }
        }
        return resultArray;
    }

}
