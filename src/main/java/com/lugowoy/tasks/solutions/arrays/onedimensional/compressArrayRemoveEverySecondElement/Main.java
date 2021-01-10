package com.lugowoy.tasks.solutions.arrays.onedimensional.compressArrayRemoveEverySecondElement;

import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.Capacity;
import com.lugowoy.tasks.solutions.helper.Helper;
import com.lugowoy.tasks.solutions.helper.HelperFiller;

/**
 * Given an array with the number of n elements. Compress the array, throwing
 * out every second element from it.
 *
 * <p>Created by Konstantin Lugowoy on 13.03.2017.
 */
public class Main {

    public static void main(String[] args) {
        int lengthArray = Helper.readConsoleArrayLength(
                Helper.INPUT_LENGTH_ARRAY, Capacity.UPPER.get());

        ArrayInts array = new ArrayInts(new HelperFiller().getArray(
                new FillingArrayRandomPrimitiveIntegers(), lengthArray,
                HelperFiller.INT_NEGATIVE_TEN, HelperFiller.INT_POSITIVE_TEN));

        System.out.println("Array : " + array);

        Helper.EXECUTOR.execute(() -> {

            CompressingArray compress =
                    CompressingArray::compressArrayRemoveEverySecondElement;
            compress.compress(array);

            System.out.println("Array after compression : " + array);

        }, new OutputExecutionTimeToConsole());

    }

}
