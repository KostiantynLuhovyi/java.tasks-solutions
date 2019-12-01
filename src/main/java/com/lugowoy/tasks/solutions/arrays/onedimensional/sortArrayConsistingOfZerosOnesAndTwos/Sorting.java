package com.lugowoy.tasks.solutions.arrays.onedimensional.sortArrayConsistingOfZerosOnesAndTwos;

import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.checking.CheckerArray;

/**
 * Created by Konstantin Lugowoy on 17.06.2017.
 */

@FunctionalInterface
public interface Sorting<T> {

    void sort(T t);

    static void sortArray(ArrayInts array) {
        if (CheckerArray.checkLengthInArray(array)) {
            int index = 0;
            for (int i = 0; i < array.size(); i++) {
                if (array.get(i) == 0) {
                    swapElements(array, index, i);
                    ++index;
                }
            }
            for (int i = index; i < array.size(); i++) {
                if (array.get(i) == 1) {
                    swapElements(array, index, i);
                    ++index;
                }
            }
        }
    }

    static void swapElements(ArrayInts array, int concreteIndex, int iteratorIndex) {
        int temp = array.get(iteratorIndex);
        array.set(iteratorIndex, array.get(concreteIndex));
        array.set(concreteIndex, temp);
    }

}
