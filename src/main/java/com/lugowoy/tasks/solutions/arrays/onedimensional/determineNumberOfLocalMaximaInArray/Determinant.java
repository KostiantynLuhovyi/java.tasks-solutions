package com.lugowoy.tasks.solutions.arrays.onedimensional.determineNumberOfLocalMaximaInArray;

import com.lugowoy.helper.models.arrays.AbstractArray;
import com.lugowoy.helper.models.arrays.ArrayInts;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Konstantin Lugowoy on 07.05.2018.
 */
@FunctionalInterface
public interface Determinant<T extends AbstractArray> {

    void determine(@NotNull final T tArray);

    static void determineNumbersOfLocalMaximum(@NotNull final ArrayInts array) {
        int counterOfLocalMaximum = 0;
        for (int i = 1; i < array.size() - 1; i++) {
            if ((array.get(i - 1) > array.get(i)) && (array.get(i + 1) > array.get(i))) {
                print(array.get(i), i);
                counterOfLocalMaximum++;
            }
        }
        if (counterOfLocalMaximum == 0) {
            System.out.println("The array did not determine numbers that would be considered local maximum.");
        }
    }

    private static void print(int number, int indexOfNumber) {
        System.out.printf("The number %d under the index %d is the local maximum.\n",
                          number, indexOfNumber);
    }

}
