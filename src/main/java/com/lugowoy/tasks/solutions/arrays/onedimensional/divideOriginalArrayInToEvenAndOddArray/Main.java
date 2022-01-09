package com.lugowoy.tasks.solutions.arrays.onedimensional.divideOriginalArrayInToEvenAndOddArray;

import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.HelperArrayFiller;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.ReaderArrayLength;

/**
 * Given an array with the number of elements of N.
 * Form two arrays: the first include elements of the original array with even numbers, and in the second - with odd numbers.
 *
 * <p>Created by Konstantin Lugowoy on 16.03.2017.
 */
public class Main {

    private static final int BOUND = 200;

    public static void main(String[] args) {

        ReaderArrayLength readerLength = new ReaderArrayLength();
        int lengthArray = readerLength.read(System.in, System.out,
                                              ReaderArrayLength.MSG_ENTER_ARRAY_LENGTH);

        HelperArrayFiller fillerArray = new HelperArrayFiller();

        ArrayInts originalArray = new ArrayInts(fillerArray.getArray(
                new FillingArrayRandomPrimitiveIntegers(), lengthArray,
                HelperFillerValues.INT_ZERO, BOUND));

        System.out.println("Original array : " + originalArray + "\n");

        new Executor().execute(() -> {
            SelectingArray<ArrayInts> selecting = SelectingArray::selectArray;

            ArrayInts evenNumbersArray = selecting.select(originalArray, SelectingArray.STATUS_EVEN_NUMBERS);
            ArrayInts oddNumbersArray = selecting.select(originalArray, SelectingArray.STATUS_ODD_NUMBERS);

            System.out.println("Even number array created based on the original array : " + evenNumbersArray);
            System.out.println("Odd number array created based on the original array : " + oddNumbersArray);
        }, new OutputExecutionTimeToConsole());

    }

}
