package com.lugowoy.tasks.solutions.arrays.onedimensional.createNewArrayFromUniqueElementsOfOriginalArray;

import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.checking.CheckerArray;

/**
 * Created by Konstantin Lugowoy on 29.05.2017.
 */

@FunctionalInterface
public interface DeterminantUniqueness {

    int CRITICAL_COUNT_UNIQUE = 2;

    ArrayInts determineUniqueness(ArrayInts array);

    static ArrayInts determineTheUniqueElementsOfTheOriginalArray(ArrayInts array) {
        ArrayInts tmpArray = new ArrayInts();
        int countUnique = 0;
        if (CheckerArray.checkLengthInArray(array)) {
            for (int i = 0; i < array.size(); i++) {
                for (int j = 0; j < array.size(); j++) {
                    if ((array.get(i) == (array.get(j)))) {
                        countUnique++;
                    }
                }
                if (countUnique < CRITICAL_COUNT_UNIQUE) {
                    tmpArray.add(array.get(i));
                }
                countUnique = 0;
            }
        }
        return tmpArray;
    }

}
