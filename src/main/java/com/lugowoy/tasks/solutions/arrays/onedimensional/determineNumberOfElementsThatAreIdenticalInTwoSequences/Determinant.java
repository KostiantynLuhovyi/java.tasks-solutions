package com.lugowoy.tasks.solutions.arrays.onedimensional.determineNumberOfElementsThatAreIdenticalInTwoSequences;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.models.arrays.AbstractArray;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.Capacity;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Konstantin Lugowoy on 30.05.2017.
 */
@FunctionalInterface
public interface Determinant<T extends AbstractArray> {

    int determine(@NotNull final ArrayInts tFirstArray,
                  @NotNull final ArrayInts tSecondArray);

    static int determineElementsThatAreIdenticalInTwoArray(@NotNull final ArrayInts firstArray,
                                                           @NotNull final ArrayInts secondArray) {
        CheckerArray.check(firstArray, Capacity.UPPER.get());
        CheckerArray.check(secondArray, Capacity.UPPER.get());
        int resultNumberOfIdenticalElements = 0;
        for (int i = 0; i < firstArray.size(); i++) {
            for (int j = 0; j < secondArray.size(); j++) {
                if (firstArray.get(i) == secondArray.get(j)) {
                    resultNumberOfIdenticalElements++;
                }
            }
        }
        return resultNumberOfIdenticalElements;
    }

}
