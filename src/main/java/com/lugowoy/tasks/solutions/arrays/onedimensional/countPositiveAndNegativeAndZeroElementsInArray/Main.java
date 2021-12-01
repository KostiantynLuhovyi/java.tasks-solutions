package com.lugowoy.tasks.solutions.arrays.onedimensional.countPositiveAndNegativeAndZeroElementsInArray;

import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.HelperArrayFiller;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.ReaderArrayLength;

/**
 * Given an array of integer numbers, whose dimension is N. Counting how much it
 * negative, positive and zero elements.
 *
 * <p> Created by Konstantin Lugowoy on 13-Feb-17.
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

        System.out.println("Numbers : \n" + array + "\n");

        new Executor().execute(() -> {
            Counter<ArrayInts> counter = Counter::countNegativeInts;
            System.out.println("Negative number : " + counter.count(array));

            counter = Counter::countZero;
            System.out.println("Zero : " + counter.count(array));

            counter = Counter::countPositiveInts;
            System.out.println("Positive number : " + counter.count(array));
        }, new OutputExecutionTimeToConsole());
    }

}
