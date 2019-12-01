package com.lugowoy.tasks.solutions.arrays.onedimensional.determineNumberOfElementsThatAreIdenticalInTwoSequences;

import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.checking.CheckerArray;

/**
 * Created by Konstantin Lugowoy on 30.05.2017.
 */
@FunctionalInterface
public interface Determinant {

    int determine(ArrayInts firstArray, ArrayInts secondArray);

    static int determineTheNumberOfElementsThatAreIdenticalInTwoSequences(ArrayInts firstArray, ArrayInts secondArray) {
        int resultNumberOfIdenticalElements = 0;
        if (CheckerArray.checkLengthInArray(firstArray) && CheckerArray.checkLengthInArray(secondArray)) {
            for (int i = 0; i < firstArray.size(); i++) {
                for (int j = 0; j < secondArray.size(); j++) {
                    if (firstArray.get(i) == secondArray.get(j)) {
                        resultNumberOfIdenticalElements++;
                    }
                }
            }
        }
        return resultNumberOfIdenticalElements;
    }

}
