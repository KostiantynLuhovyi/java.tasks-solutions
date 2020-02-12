package com.lugowoy.tasks.solutions.arrays.onedimensional.compressArrayByDiscardingEverySecondElement;

import com.lugowoy.helper.models.storages.arrays.AbstractArray;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.checking.CheckerArray;

/**
 * Created by Konstantin Lugowoy on 13.03.2017.
 */
@FunctionalInterface
public interface CompressingArray<T extends AbstractArray> {

    void compress(T t);

    static void compressArrayDiscardingEverySecondElement(ArrayInts array) {
        if (CheckerArray.checkLengthInArray(array)) {
            if (array.size() >= 2) {
                for (int i = 0; i < array.size(); i++) {
                    if ((i % 2 == 0) || (i == 0)) {
                        array.removeByIndex(i);
                    }
                }
            }
        }
        System.out.printf("Array after compression : \n%s", array);
    }

    static void compressArrayDiscardingZeroValueElements(ArrayInts array) {
        int numberZeroElements = 0;
        if (CheckerArray.checkLengthInArray(array)) {
            for (int i = 0; i < array.size(); i++) {
                if (array.get(i) == 0) {
                    array.removeByIndex(i);
                    numberZeroElements++;
                }
            }
        }
        System.out.printf("Number of zero elements in the array : %d .", numberZeroElements);
        System.out.printf("Array after compression : \n%s", array);
    }

}
