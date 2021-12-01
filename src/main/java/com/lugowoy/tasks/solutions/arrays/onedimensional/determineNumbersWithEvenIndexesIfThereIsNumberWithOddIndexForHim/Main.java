package com.lugowoy.tasks.solutions.arrays.onedimensional.determineNumbersWithEvenIndexesIfThereIsNumberWithOddIndexForHim;

import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.HelperArrayFiller;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.ReaderArrayLength;

/**
 * Write a program that enter a sequence of integers and prints numbers with
 * even indexes if there is an equal number with an odd index.
 *
 * <p>Created by Konstantin Lugowoy on 07.05.2018.
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

        System.out.println("Original array:" + array + "\n");

        new Executor().execute(() -> {
            Determinant<ArrayInts> determinant =
                    Determinant::determineNumbersWithEvenIndexesIfThereIsNumberWithOddIndex;
            determinant.determine(array);
        }, new OutputExecutionTimeToConsole());

    }

}
