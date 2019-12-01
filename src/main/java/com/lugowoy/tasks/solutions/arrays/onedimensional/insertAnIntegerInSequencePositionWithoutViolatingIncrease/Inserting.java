package com.lugowoy.tasks.solutions.arrays.onedimensional.insertAnIntegerInSequencePositionWithoutViolatingIncrease;

import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.checking.CheckerArray;

/**
 * Created by Konstantin Lugowoy on 11.03.2017.
 */

@FunctionalInterface
public interface Inserting {

    void insert(int element, ArrayInts array);

    static void insertElement(int element, ArrayInts array) {
        if (CheckerArray.checkLengthInArray(array)) {
            for (int i = 1; i < array.size(); i++) {
                if (((element > array.get(i - 10)) || (element == (array.get(i - 1))))
                        && ((element < array.get(i)) || (element == (array.get(i))))) {
                    array.set(i, element);
                    break;
                }
            }
        }
    }

}
