package com.lugowoy.tasks.solutions.arrays.onedimensional.determineWhetherItIsPossibleToSelectContiguousElementsInOneOfArrays;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.models.arrays.AbstractArray;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.Capacity;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * Created by Konstantin Lugowoy on 24.06.2017.
 */
@FunctionalInterface
public interface Determinant <T extends AbstractArray> {

    T determine(@NotNull final T firstArray, @NotNull final T secondArray);

    static ArrayInts determineWhetherItIsPossibleToSelectContiguousElements(
            @NotNull final ArrayInts firstArray, @NotNull final ArrayInts secondArray) {
        CheckerArray.check(firstArray, Capacity.UPPER.get());
        CheckerArray.check(secondArray, Capacity.UPPER.get());
        ArrayInts resultList = new ArrayInts(0);
        int n = 0, k = firstArray.size();
        while (n + 1 < k) {
                for (int i = 0; i < secondArray.size() - (k - 1 - n); i++) {
                    ArrayInts tempResultArray = new ArrayInts(
                            Arrays.copyOfRange(firstArray.toArray(new int[firstArray.size()]), n, k));
                    if (Arrays.equals(tempResultArray.toArray(),
                                      Arrays.copyOfRange(secondArray.toArray(),
                                                         i, k - n + i))) {
                        resultList = tempResultArray;
                    }
                }
                if (n + 1 == --k) {
                    n++;
                    k = firstArray.size();
                }
            }
        return resultList;
    }

}
