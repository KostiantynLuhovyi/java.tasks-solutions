package com.lugowoy.tasks.solutions.arrays.onedimensional.findSubsetOfContiguousElementsWhoseElementValuesSumToNumber;

import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.HelperArrayFiller;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.ReaderArrayLength;
import com.lugowoy.helper.utils.ReaderConsole;

/**
 * Find subset of contiguous elements of array sum of values of elements which is equal to number.
 *
 * <p>Created by Konstantin Lugowoy on 18.06.2017.
 */
public class Main {

    public static final int MIN_NUMBER = 0;
    public static final int MAX_NUMBER = 200;

    public static void main(String[] args) {

        ReaderArrayLength readerLength = new ReaderArrayLength();
        int lengthArray = readerLength.read(System.in, System.out,
                                            ReaderArrayLength.MSG_ENTER_ARRAY_LENGTH);

        HelperArrayFiller filler = new HelperArrayFiller();
        ArrayInts array = new ArrayInts(filler.getArray(
                new FillingArrayRandomPrimitiveIntegers(), lengthArray,
                HelperFillerValues.INT_ZERO, HelperFillerValues.INT_POSITIVE_HUNDRED));

        System.out.println("Array: " + array + "\n");

        int number = new ReaderConsole().readInt(MIN_NUMBER, MAX_NUMBER);

        new Executor().execute(() -> {
            Finding<ArrayInts> finding = Finding::findSubsetOfElementsWhoseSumValuesISEqualToNumber;

            ArrayInts resultArray = new ArrayInts(finding.find(array, number));

            if (resultArray.size() > 0) {
                System.out.println("Result : " + resultArray);
            } else{
                System.out.println("An array does not contain such a sequence of elements.");
            }
        }, new OutputExecutionTimeToConsole());

    }

}
