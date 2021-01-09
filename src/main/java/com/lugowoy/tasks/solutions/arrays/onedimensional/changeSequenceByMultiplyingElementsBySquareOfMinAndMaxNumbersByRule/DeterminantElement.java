package com.lugowoy.tasks.solutions.arrays.onedimensional.changeSequenceByMultiplyingElementsBySquareOfMinAndMaxNumbersByRule;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.Capacity;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Konstantin Lugowoy on 25.03.2017.
 */
@FunctionalInterface
public interface DeterminantElement {

    int determine(@NotNull final ArrayInts array);

    static int determineMinNumber(@NotNull final ArrayInts array) {
        CheckerArray.check(array, Capacity.UPPER.get());
        int minNumber = Integer.MAX_VALUE;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) <= minNumber) {
                minNumber = array.get(i);
            }
        }
        return minNumber;
    }

    static int determineMaxNumber(@NotNull final ArrayInts array) {
        CheckerArray.check(array, Capacity.UPPER.get());
        int maxNumber = Integer.MIN_VALUE;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) >= maxNumber) {
                maxNumber = array.get(i);
            }
        }
        return maxNumber;
    }

}

