package com.lugowoy.tasks.solutions.arrays.onedimensional.createOrderedArrayFromElementsOfOtherArrays;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.models.arrays.AbstractArray;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.Capacity;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Konstantin Lugowoy on 30.05.2017.
 */
@FunctionalInterface
public interface MergingArrays<T extends AbstractArray> {

    T merge(@NotNull final T firstArray, @NotNull final T secondArray);

    static ArrayInts mergeArrays(@NotNull final ArrayInts firstArray,
                                 @NotNull final ArrayInts secondArray) {
        CheckerArray.check(firstArray, Capacity.UPPER.get());
        CheckerArray.check(secondArray, Capacity.UPPER.get());
        ArrayInts resultArray = new ArrayInts(firstArray.size() + secondArray.size());
        int indexFirstArray = 0, indexSecondArray = 0;
        for (int i = 0; i < resultArray.size(); i++) {
            if ((indexFirstArray < firstArray.size())
                    && (indexSecondArray < secondArray.size())) {
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
        return resultArray;
    }

}
