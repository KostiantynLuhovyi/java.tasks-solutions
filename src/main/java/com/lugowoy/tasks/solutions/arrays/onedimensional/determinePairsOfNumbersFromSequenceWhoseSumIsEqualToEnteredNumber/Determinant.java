package com.lugowoy.tasks.solutions.arrays.onedimensional.determinePairsOfNumbersFromSequenceWhoseSumIsEqualToEnteredNumber;

import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.checking.CheckerArray;

/**
 * Created by Konstantin Lugowoy on 19.03.2017.
 */

public interface Determinant<T> {

    void determine(ArrayInts array, int numberForEqual);

    static void determinePairsOfNumbersFromTheSequenceWhoseSumIsEqualToEnteredNumber(ArrayInts array, int numberForEqual) {
        int countResult = 0;
        if (CheckerArray.checkLengthInArray(array)) {
            for (int i = 0; i < array.size() - 1; i++) {
                for (int j = i + 1; j < array.size(); j++) {
                    if ((array.get(i) + array.get(j)) == numberForEqual) {
                        System.out.printf("Element %d , with index %d a plus, element %d, with index %d is equal %d",
                                array.get(i), i, array.get(j), j, numberForEqual);
                        countResult++;
                        System.out.println();
                    }
                }
            }
        }
        if (countResult == 0)
            System.out.println("Not found numbers in a sequence whose sum is equal to the entered number.");
    }

}
