package com.lugowoy.tasks.solutions.arrays.onedimensional.sortArrayInAscendingOrderWithoutChangingTheirRelativePosition;


import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.checking.CheckerArray;

/**
 * Created by Konstantin Lugowoy on 14.05.2017.
 */

@FunctionalInterface
public interface Sorting {

    void sort(ArrayInts array);

    static void sortAnArrayInAscendingOrderWithoutChangingTheirRelativePosition(ArrayInts array) {
        if (CheckerArray.checkLengthInArray(array)) {
            int tmp;
            for (int i = 0; i < array.size(); i++) {
                for (int j = 0; j < array.size() - i - 1; j++) {
                    if (((array.get(j) == 0) && (array.get(j + 1) < 0))
                            || ((array.get(j) > 0) && (array.get(j + 1) <= 0))) {
                        tmp = array.get(j);
                        array.set(j, array.get(j + 1));
                        array.set(j + 1, tmp);
                    }
                }
            }
        }
    }

}
