package com.lugowoy.tasks.solutions.arrays.onedimensional.createOrderedArrayFromElementsOfTwoOtherOrderedArrays;

import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.checking.CheckerArray;

/**
 * Created by Konstantin Lugowoy on 30.05.2017.
 */

@FunctionalInterface
public interface Merging<T> {

    T merge(T firstT, T secondT);

    static ArrayInts mergeArrays(ArrayInts firstArray, ArrayInts secondArray) {
        ArrayInts resultArray = null;
        if (CheckerArray.checkLengthInArray(firstArray) && CheckerArray.checkLengthInArray(secondArray)) {
            resultArray = new ArrayInts(firstArray.size() + secondArray.size());
            int indexFirstArray = 0, indexSecondArray = 0;
            for (int i = 0; i < resultArray.size(); i++) {
                if ((indexFirstArray < firstArray.size()) && (indexSecondArray < secondArray.size())) {
                    if (firstArray.get(indexFirstArray) > secondArray.get(indexSecondArray)) {
                        resultArray.set(i, secondArray.get(indexSecondArray++));
                    } else {
                        resultArray.set(i, firstArray.get(indexFirstArray++));
                    }
                } else if (indexSecondArray < secondArray.size()) {
                    resultArray.set(i, secondArray.get(indexSecondArray++));
                } else {
                    resultArray.set(i, firstArray.get(indexFirstArray++));
                }
            }
        }
        return resultArray;
    }

}
