package com.lugowoy.tasks.solutions.arrays.onedimensional.divideOriginalArrayInToEvenAndOddArray;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.models.arrays.AbstractArray;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.Capacity;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Konstantin Lugowoy on 16.03.2017.
 */
@FunctionalInterface
public interface SelectingArray<T extends AbstractArray> {

    int STATUS_EVEN_NUMBERS = 1;
    int STATUS_ODD_NUMBERS = 0;

    T select(@NotNull final T tArray, final int statusNumbers);

    static ArrayInts selectArray(@NotNull final ArrayInts array,
                                 final int statusNumbers) {
        CheckerArray.check(array, Capacity.UPPER.get());
        ArrayInts tmpArray = new ArrayInts(0);
        if (statusNumbers == STATUS_EVEN_NUMBERS) {
            for (int i = 0; i < array.size(); i++) {
                if (array.get(i) % 2 == 0) {
                    tmpArray.add(array.get(i));
                }
            }
        } else if (statusNumbers == STATUS_ODD_NUMBERS) {
            for (int i = 0; i < array.size(); i++) {
                if (array.get(i) % 2 != 0) {
                    tmpArray.add(array.get(i));
                }
            }
        }
        return tmpArray;
    }

}
