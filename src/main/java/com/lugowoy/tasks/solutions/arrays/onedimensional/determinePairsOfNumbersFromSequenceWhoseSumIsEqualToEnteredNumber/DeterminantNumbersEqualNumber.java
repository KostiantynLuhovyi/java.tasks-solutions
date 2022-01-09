package com.lugowoy.tasks.solutions.arrays.onedimensional.determinePairsOfNumbersFromSequenceWhoseSumIsEqualToEnteredNumber;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.models.arrays.AbstractArray;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.Capacity;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Konstantin Lugowoy on 19.03.2017.
 */
public interface DeterminantNumbersEqualNumber<T extends AbstractArray, V extends Number> {

    void determine(@NotNull final T tArray, @NotNull final V vNumber);

    static void determineNumbersWhoseSumEqualNumber(
            @NotNull final ArrayInts array, final int number) {
        CheckerArray.check(array, Capacity.UPPER.get());
        int countResult = 0;
        for (int i = 0; i < array.size() - 1; i++) {
            for (int j = i + 1; j < array.size(); j++) {
                if ((array.get(i) + array.get(j)) == number) {
                    printResult(array, number, i, j);
                    countResult++;
                    System.out.println();
                }
            }
        }
        if (countResult == 0) {
            System.out.println("Not found numbers whose sum is equal to the number.");
        }
    }

    static void printResult(@NotNull final ArrayInts array, final int number,
                            final int i, final int j) {
        System.out.printf("Element %d , with index %d a plus, element %d, with index %d is equal %d",
                array.get(i), i, array.get(j), j, number);
    }

}
