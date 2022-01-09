package com.lugowoy.tasks.solutions.arrays.onedimensional.findLongestSequenceOfElementsEqualToZero;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.models.arrays.AbstractArray;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.Capacity;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Konstantin Lugowoy on 18.06.2017.
 */
@FunctionalInterface
public interface Finding <T extends AbstractArray> {

    int find(@NotNull final T tArray);

    static int findLongestSequenceOfElementsEqualToZero(@NotNull final ArrayInts array) {
        int resultCount = 0, count = 0;
        CheckerArray.check(array, Capacity.UPPER.get());
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) == 0) {
                count++;
            } else {
                count = 0;
            }
            resultCount = resultCount < count ? count : resultCount;
        }
        return resultCount;
    }

}
