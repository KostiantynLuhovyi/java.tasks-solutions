package com.lugowoy.tasks.solutions.arrays.onedimensional.changeArrayByMultiplyingElementsByNumbersByRule;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.Capacity;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Konstantin Lugowoy on 25.03.2017.
 */
@FunctionalInterface
public interface MultiplyingArrayElements {

    ArrayInts multiply(@NotNull final ArrayInts array,
                       final int minValue,
                       final int maxValue);

    static ArrayInts multiplyElementsBySquareMinOrMaxValue(
            @NotNull final ArrayInts array, final int minValue, final int maxValue) {
        CheckerArray.check(array, Capacity.UPPER.get());
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) >= 0) {
                array.set(i, multiplyBySquareNumber(array.get(i), minValue * minValue));
            } else if (array.get(i) <= 0) {
                array.set(i, multiplyBySquareNumber(array.get(i), maxValue * maxValue));
            }
        }
        return array;
    }

    private static int multiplyBySquareNumber(final int element,
                                              final int squareNumber) {
        return element * squareNumber;
    }


}
