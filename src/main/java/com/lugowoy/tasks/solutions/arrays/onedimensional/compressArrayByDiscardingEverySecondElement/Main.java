package com.lugowoy.tasks.solutions.arrays.onedimensional.compressArrayByDiscardingEverySecondElement;

import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.execution.ExecutionTimeOutputToConsole;
import com.lugowoy.helper.utils.execution.Executor;
import com.lugowoy.tasks.solutions.Helper;

import static com.lugowoy.helper.filling.ValuesToFilling.INT_LOWER_BOUND;
import static com.lugowoy.helper.filling.ValuesToFilling.INT_UPPER_BOUND;

/**
 * Given an array with the number of n elements.
 * Compress the array, throwing out every second element from it.
 * <p> Created by Konstantin Lugowoy on 13.03.2017.
 */
public class Main {

    public static void main(String[] args) {
        int lengthOfArray = Helper.enterArrayLengthToConsole();

        ArrayInts array = new ArrayInts(Helper.FILLING_ARRAY_INTS.fill(lengthOfArray, INT_LOWER_BOUND, INT_UPPER_BOUND));

        System.out.println("Original array : " + array);

        Executor.execute(() -> CompressingArray.compressArrayDiscardingEverySecondElement(array),
                                                                     ExecutionTimeOutputToConsole::outputExecutionTime);

    }

}
