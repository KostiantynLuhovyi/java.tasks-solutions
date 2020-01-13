package com.lugowoy.tasks.solutions.arrays.onedimensional.getIntegersInAscendingOrderThatDoesNotBelongToThisArray;

import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.checking.CheckerArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Konstantin Lugowoy on 11.04.2017.
 */
public interface Finding<T, V> {

    T find(V v);

    static int findMaxNumber(ArrayInts array) {
        int resultValueOfMaxNumber = 0;
        if (CheckerArray.checkLengthInArray(array)) {
            for (int i = 0; i < array.size(); i++) {
                if (array.get(i) > resultValueOfMaxNumber) {
                    resultValueOfMaxNumber = array.get(i);
                }
            }
        }
        return resultValueOfMaxNumber;
    }

    static int findMinNumber(ArrayInts array) {
        int resultValueOfMinNumber = 0;
        if (CheckerArray.checkLengthInArray(array)) {
            for (int i = 0; i < array.size(); i++) {
                if (array.get(i) < resultValueOfMinNumber) {
                    resultValueOfMinNumber = array.get(i);
                }
            }
        }
        return resultValueOfMinNumber;
    }

}
