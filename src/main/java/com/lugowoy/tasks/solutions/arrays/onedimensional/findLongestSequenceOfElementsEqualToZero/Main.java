package com.lugowoy.tasks.solutions.arrays.onedimensional.findLongestSequenceOfElementsEqualToZero;

import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.HelperArrayFiller;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.ReaderArrayLength;

/**
 * Given an array A. Find the length of the longest sequence of consecutive array elements equal to zero.
 * <p> Created by Konstantin Lugowoy on 18.06.2017.
 */
public class Main {

    private static final int BOUND = 3;

    public static void main(String[] args) {

        ReaderArrayLength readerLength = new ReaderArrayLength();
        int lengthArray = readerLength.read(System.in, System.out,
                                            ReaderArrayLength.MSG_ENTER_ARRAY_LENGTH);

        HelperArrayFiller filler = new HelperArrayFiller();
        ArrayInts array = new ArrayInts(filler.getArray(
                new FillingArrayRandomPrimitiveIntegers(), lengthArray,
                HelperFillerValues.INT_ZERO, BOUND));

        System.out.println("Array: " + array + "\n");

        new Executor().execute(() -> {
            Finding<ArrayInts> finding = Finding::findLongestSequenceOfElementsEqualToZero;
            System.out.println("The longest sequence of array elements equal to zero is equal to "
                               + finding.find(array));
        }, new OutputExecutionTimeToConsole());

    }

}
