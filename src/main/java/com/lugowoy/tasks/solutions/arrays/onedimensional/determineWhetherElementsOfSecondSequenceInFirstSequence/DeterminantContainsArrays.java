package com.lugowoy.tasks.solutions.arrays.onedimensional.determineWhetherElementsOfSecondSequenceInFirstSequence;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.models.arrays.AbstractArray;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.Capacity;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Konstantin Lugowoy on 12.04.2017.
 */
@FunctionalInterface
public interface DeterminantContainsArrays<T extends AbstractArray> {

    boolean determine(@NotNull final ArrayInts firstArray,
                      @NotNull final ArrayInts secondArray);

    static boolean determineFirstArrayContainsSecondArray(@NotNull final ArrayInts firstArray,
                                                          @NotNull final ArrayInts secondArray) {
        boolean result = true;
        CheckerArray.check(firstArray, Capacity.UPPER.get());
        CheckerArray.check(secondArray, Capacity.UPPER.get());
        for (int i = 0; i < secondArray.size(); i++) {
            if (!containsElement(firstArray, secondArray.get(i))) {
                result = false;
            }
        }
        return result;
    }

    private static boolean containsElement(final ArrayInts arrayInts, final int element) {
        return arrayInts.contains(element);
    }

}
