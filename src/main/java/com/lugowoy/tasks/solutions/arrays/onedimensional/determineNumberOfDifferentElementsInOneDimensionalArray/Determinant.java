package com.lugowoy.tasks.solutions.arrays.onedimensional.determineNumberOfDifferentElementsInOneDimensionalArray;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.models.arrays.AbstractArray;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.Capacity;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Konstantin Lugowoy on 28.05.2017.
 */
@FunctionalInterface
public interface Determinant<T extends AbstractArray> {

    int determine(@NotNull final T tArray);

    static int determineNumberDifferentElementsInArray(@NotNull final ArrayInts array) {
        CheckerArray.check(array, Capacity.UPPER.get());
        int resultCountOfDifferentElements = 0;
        if (array.size() > 2) {
            for (int i = 0; i < array.size(); i++) {
                if (isUnique(array.get(i), array)) {
                    resultCountOfDifferentElements++;
                }
            }
        }
        return resultCountOfDifferentElements;
    }

    private static boolean isUnique(final int number, @NotNull final ArrayInts array) {
        CheckerArray.check(array, Capacity.UPPER.get());
        boolean isUnique = false;
        int countUnique = 0;
            if (array.size() > 2) {
                if (number >= 0) {
                    for (int i = 0; i < array.size(); i++) {
                        if (number == array.get(i)) {
                            countUnique++;
                        }
                    }
                }
            }
        if (!(countUnique > 1)) {
            isUnique = true;
        }
        return isUnique;
    }

}
