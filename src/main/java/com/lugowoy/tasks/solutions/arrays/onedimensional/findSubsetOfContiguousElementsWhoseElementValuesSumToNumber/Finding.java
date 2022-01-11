package com.lugowoy.tasks.solutions.arrays.onedimensional.findSubsetOfContiguousElementsWhoseElementValuesSumToNumber;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.models.arrays.AbstractArray;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.Capacity;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * Created by Konstantin Lugowoy on 18.06.2017.
 */
@FunctionalInterface
public interface Finding <T extends AbstractArray> {

    int[] find(@NotNull final T tArray, final int number);

    static int[] findSubsetOfElementsWhoseSumValuesISEqualToNumber(
            @NotNull final ArrayInts array, final int number) {
        int[] resultArray = null;
        CheckerArray.check(array, Capacity.UPPER.get());
        int sum = array.get(0);
        int i = 0, j = 1;
        while (j < array.size()) {
            if (sum < number) {
                sum += array.get(j++);
            } else if (sum > number) {
                sum -= array.get(i++);
            } else {
                resultArray = Arrays.copyOfRange(array.toArray(
                        new int[array.size()]), i, j);
                break;
            }
        }
        return resultArray;
    }

}
