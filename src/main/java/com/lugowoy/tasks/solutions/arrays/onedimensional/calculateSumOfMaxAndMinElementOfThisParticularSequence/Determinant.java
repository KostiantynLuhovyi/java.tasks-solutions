package com.lugowoy.tasks.solutions.arrays.onedimensional.calculateSumOfMaxAndMinElementOfThisParticularSequence;

import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.checking.CheckerArray;

/**
 * Created by Konstantin Lugowoy on 01.03.2017.
 */
@FunctionalInterface
public interface Determinant<T, V> {

    V determine(T t);

    static int determineMaxElement(ArrayInts array) {
        int result = 0;
        if (CheckerArray.checkLengthInArray(array)) {
            for (int i = 0; i < array.size(); i++) {
                if (array.get(i) > result) {
                    result = array.get(i);
                }
            }
        }
        return result;
    }

    static int determineMinElement(ArrayInts array) {
        int result = 200;
        if (CheckerArray.checkLengthInArray(array)) {
            for (int i = 0; i < array.size(); i++) {
                if (array.get(i) < result) {
                    result = array.get(i);
                }
            }
        }
        return result;
    }

}
