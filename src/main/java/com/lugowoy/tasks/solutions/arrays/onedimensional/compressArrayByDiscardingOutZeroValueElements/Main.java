package com.lugowoy.tasks.solutions.arrays.onedimensional.compressArrayByDiscardingOutZeroValueElements;

import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.HelperArrayFiller;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.ReaderArrayLength;

/**
 * An array containing integers is specified. Compress it, throwing out the zero
 * elements.
 *
 * <p>Created by Konstantin Lugowoy on 16.03.2017.
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

        System.out.println("Original array : " + array);

        new Executor().execute(() -> {
            CompressingArray<ArrayInts> compression =
                    CompressingArray::compressByRemovingZeroElements;
            compression.compress(array);
        }, new OutputExecutionTimeToConsole());

    }

}
