package com.lugowoy.tasks.solutions.arrays.onedimensional.determineWhetherItIsPossibleToSelectContiguousElementsInOneOfArraysByCondition;

import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.checking.CheckerArray;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Konstantin Lugowoy on 24.06.2017.
 */

@FunctionalInterface
public interface Determinant<T> {

    List<T> determine(ArrayInts firstArray, ArrayInts secondArray);

    static List<ArrayInts> determineWhetherItIsPossibleToSelectContiguousElements(ArrayInts firstArray, ArrayInts secondArray) {
        List<ArrayInts> resultList = new LinkedList<>();
        int n = 0, k = firstArray.size();
        if (CheckerArray.checkLengthInArray(firstArray) && CheckerArray.checkLengthInArray(secondArray)) {
            while (n + 1 < k) {
                for (int i = 0; i < secondArray.size() - (k - 1 - n); i++) {
                    ArrayInts tempResultArray = new ArrayInts(Arrays.copyOfRange(firstArray.toArray(new int[firstArray.size()]), n, k));
                    if (Arrays.equals(tempResultArray.toArray(), Arrays.copyOfRange(secondArray.toArray(), i, k - n + i))) {
                        resultList.add(tempResultArray);
                    }
                }
                if (n + 1 == --k) {
                    n++;
                    k = firstArray.size();
                }
            }
        }
        return resultList;
    }

}
