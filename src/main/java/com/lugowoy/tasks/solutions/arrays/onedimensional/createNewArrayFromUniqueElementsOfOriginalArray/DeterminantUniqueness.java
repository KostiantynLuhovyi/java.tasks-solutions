package com.lugowoy.tasks.solutions.arrays.onedimensional.createNewArrayFromUniqueElementsOfOriginalArray;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.models.arrays.AbstractArray;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.Capacity;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Konstantin Lugowoy on 29.05.2017.
 */
@FunctionalInterface
public interface DeterminantUniqueness<T extends AbstractArray> {

    int CRITICAL_COUNT_UNIQUE = 2;

    T determineUniqueness(@NotNull final T array);

    static ArrayInts determineUniqueElementsOfArray(
            @NotNull final ArrayInts array) {
        CheckerArray.check(array, Capacity.UPPER.get());
        int countUnique = 0;
        ArrayInts resultArray = new ArrayInts(0);
        for (int i = 0; i < array.size(); i++) {
            for (int j = 0; j < array.size(); j++) {
                if ((array.get(i) == (array.get(j)))) {
                    countUnique++;
                }
            }
            if (countUnique < CRITICAL_COUNT_UNIQUE) {
                resultArray.add(array.get(i));
            }
            countUnique = 0;
        }
        return resultArray;
    }

}
