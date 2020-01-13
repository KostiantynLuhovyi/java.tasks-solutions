package com.lugowoy.tasks.solutions.arrays.onedimensional.determineNumberOfDifferentElementsInOneDimensionalArray;

import com.lugowoy.helper.models.storages.arrays.AbstractArray;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.checking.CheckerArray;

/**
 * Created by Konstantin Lugowoy on 28.05.2017.
 */
@FunctionalInterface
public interface Determinant {

    int determine(ArrayInts array);

    static int determineTheNumberOfDifferentElementsInOneDimensionalArray(ArrayInts array) {
        int resultCountOfDifferentElements = 0;
        if (CheckerArray.checkLengthInArray(array)) {
            if (array.size() > 2) {
                for (int i = 0; i < array.size(); i++) {
                    if (isUnique(array.get(i), array)) {
                        resultCountOfDifferentElements++;
                    }
                }
            }
        }
        return resultCountOfDifferentElements;
    }

    private static boolean isUnique(int number, ArrayInts array) {
        boolean isUnique = false;
        int countUnique = 0;
        if (CheckerArray.checkLengthInArray(array)) {
            if (array.size() > 2) {
                if (number >= 0) {
                    for (int i = 0; i < array.size(); i++) {
                        if (number == array.get(i)) {
                            countUnique++;
                        }
                    }
                }
            }
        }
        if (!(countUnique > 1)) {
            isUnique = true;
        }
        return isUnique;
    }

}
