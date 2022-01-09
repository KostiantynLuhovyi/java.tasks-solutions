package com.lugowoy.tasks.solutions.arrays.onedimensional.determineSequenceOfNumbersIsIncreasing;

import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.HelperArrayFiller;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.ReaderArrayLength;

/**
 * Given a sequence of integer numbers a1, a2, ..., an. Determine whether it is increasing.
 *
 * <p>Created by Konstantin Lugowoy on 13-Feb-17.
 */
public class Main {

    public static void main(String[] args) {

        ReaderArrayLength readerLength = new ReaderArrayLength();
        int lengthArray = readerLength.read(System.in, System.out,
                                            ReaderArrayLength.MSG_ENTER_ARRAY_LENGTH);

        HelperArrayFiller filler = new HelperArrayFiller();

        ArrayInts array = new ArrayInts(filler.getArray(new FillingArrayRandomPrimitiveIntegers(),
                                                        lengthArray,
                                                        HelperFillerValues.INT_NEGATIVE_HUNDRED,
                                                        HelperFillerValues.INT_POSITIVE_HUNDRED));

        System.out.println("Sequence : " + array + "\n");

        new Executor().execute(() -> {
            boolean resultIncreasingSequence = false;
            if (array.get(1) > array.get(0)) {
                resultIncreasingSequence = true;
            }

            if (resultIncreasingSequence) {
                System.out.println("The sequence of increasing.");
            } else {
                System.out.println("The sequence of a not increasing");
            }
        }, new OutputExecutionTimeToConsole());

    }

}
