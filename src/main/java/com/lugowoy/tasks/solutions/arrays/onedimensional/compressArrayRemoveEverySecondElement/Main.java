package com.lugowoy.tasks.solutions.arrays.onedimensional.compressArrayRemoveEverySecondElement;

import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.HelperArrayFiller;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.ReaderArrayLength;

/**
 * Given an array with the number of n elements. Compress the array, throwing
 * out every second element from it.
 *
 * <p>Created by Konstantin Lugowoy on 13.03.2017.
 */
public class Main {

    public static void main(String[] args) {

        ReaderArrayLength readerArrayLength = new ReaderArrayLength();
        int lengthArray = readerArrayLength.read(System.in, System.out,
                                                 ReaderArrayLength.MSG_ENTER_ARRAY_LENGTH);

        HelperArrayFiller fillerArray = new HelperArrayFiller();

        ArrayInts array = new ArrayInts(fillerArray.getArray(
                new FillingArrayRandomPrimitiveIntegers(), lengthArray,
                HelperFillerValues.INT_NEGATIVE_TEN,
                HelperFillerValues.INT_POSITIVE_TEN));

        System.out.println("Array : \n" + array + "\n");

        new Executor().execute(() -> {
            CompressingArray<ArrayInts> compress =
                    CompressingArray::compressArrayRemoveEverySecondElement;
            compress.compress(array);

            System.out.println("Array after compression : \n" + array + "\n");
        }, new OutputExecutionTimeToConsole());

    }

}
