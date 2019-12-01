package com.lugowoy.tasks.solutions.arrays.onedimensional.divideOriginalArrayInToEvenAndOddArray;

import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.checking.CheckerArray;

/**
 * Created by Konstantin Lugowoy on 16.03.2017.
 */

public interface Selecting<T> {

    int STATUS_EVEN_NUMBERS = 1;
    int STATUS_ODD_NUMBERS = 0;

    T select(T t, int statusNumbers);

    static ArrayInts selectArray(ArrayInts array, int statusNumbers) {
        ArrayInts tmpArray = new ArrayInts(0);
        if (CheckerArray.checkLengthInArray(array)) {
            if (statusNumbers == STATUS_EVEN_NUMBERS) {
                for (int i = 0; i < array.size(); i++) {
                    if (array.get(i) % 2 == 0) {
                        tmpArray.add(array.get(i));
                    }
                }
            }
        } else if (statusNumbers == STATUS_ODD_NUMBERS) {
            for (int i = 0; i < array.size(); i++) {
                if (array.get(i) % 2 != 0) {
                    tmpArray.add(array.get(i));
                }
            }
        }
        return tmpArray;
    }

}
