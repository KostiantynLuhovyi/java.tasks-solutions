package com.lugowoy.tasks.solutions.arrays.onedimensional.determineElementsThatAreEqualToHalfSumOfNeighboringElements;

import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.checking.CheckerArray;

/** Created by Konstantin Lugowoy on 03.09.2017. */

@FunctionalInterface
public interface Determinant {

    void determine(ArrayInts array);

    static void determineElementsThatAreEqualToHalfSumOfNeighboringElements(ArrayInts array) {
        if (CheckerArray.checkLengthInArray(array)) {
            if (array.size() > 2) {
                int counterCoincidence = 0;
                for (int i = 1; i < array.size() - 1; i++) {
                    if (((array.get(i - 1) + array.get((i + 1)) / 2) == array.get(i))) {
                        System.out.printf("Element %d at index %d is equal to half sum element %d at index %d and element %d at index %d.",
                                                     array.get(i), i, array.get(i - 1), i - 1, array.get(i + 1), i + 1);
                        System.out.println();
                        counterCoincidence++;
                    }
                }
                if (counterCoincidence == 0) {
                    System.err.println("No items found that satisfied the condition.");
                }
            }
        }
    }

}
