package com.lugowoy.tasks.solutions.arrays.onedimensional.determineNumberOfLocalMaximaInArray;

import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.HelperArrayFiller;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.ReaderArrayLength;

/**
 * Write a program that enter a non-empty array of integers and prints the
 * number of local maximum (an element is a local maximum if it has neighbors
 * elements larger than itself).
 *
 * <p>Created by Konstantin Lugowoy on 07.05.2018.
 */
public class Main {

    private static final int BOUND = 200;

    public static void main(String[] args) {

        ReaderArrayLength readerLength = new ReaderArrayLength();
        int lengthArray = readerLength.read(System.in, System.out,
                                            ReaderArrayLength.MSG_ENTER_ARRAY_LENGTH);

        HelperArrayFiller fillerArray = new HelperArrayFiller();

        ArrayInts array = new ArrayInts(fillerArray.getArray(
                new FillingArrayRandomPrimitiveIntegers(), lengthArray,
                HelperFillerValues.INT_ZERO, BOUND));

        System.out.println(array);

        new Executor().execute(() -> {
            Determinant<ArrayInts> determinant = Determinant::determineNumbersOfLocalMaximum;
            determinant.determine(array);
        }, new OutputExecutionTimeToConsole());

    }

}
