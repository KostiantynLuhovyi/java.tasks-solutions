package com.lugowoy.tasks.solutions.arrays.onedimensional.compareModulesOfProductOfDifferentNumbersInArray;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.models.arrays.AbstractArray;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.Capacity;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Konstantin Lugowoy on 11.03.2017.
 */
@FunctionalInterface
public interface ProductArrayNumbers<T extends AbstractArray> {

    int product(@NotNull final T array);

    static int productPositiveNumbers(@NotNull final ArrayInts array) {
        CheckerArray.check(array, Capacity.UPPER.get());
        int resultMultiplication = 1;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > 0) {
                resultMultiplication *= array.get(i);
            }
        }
        return resultMultiplication;
    }

    static int productNegativeNumbers(@NotNull final ArrayInts array) {
        CheckerArray.check(array, Capacity.UPPER.get());
        int resultMultiplication = 1;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) < 0) {
                resultMultiplication *= array.get(i);
            }
        }
        return resultMultiplication;
    }

}
