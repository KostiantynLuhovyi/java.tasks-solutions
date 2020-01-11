package com.lugowoy.tasks.solutions.arrays.onedimensional.compareMultiplicationModulesOfPositiveAndNegativeNumbers.multiplicate;

import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.checking.CheckerArray;

/**
 * Created by Konstantin Lugowoy on 11.03.2017.
 */
public class MultiplicationNegativeNumbers {

    public static int multiplication(ArrayInts array) {
        int resultMultiplication = 1;
        if (CheckerArray.checkLengthInArray(array)) {
            for (int i = 0; i < array.size(); i++) {
                if (array.get(i) < 0) {
                    resultMultiplication *= array.get(i);
                }
            }
        }
        return resultMultiplication;
    }

}
