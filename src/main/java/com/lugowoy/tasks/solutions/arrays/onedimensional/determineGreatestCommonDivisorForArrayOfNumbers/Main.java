package com.lugowoy.tasks.solutions.arrays.onedimensional.determineGreatestCommonDivisorForArrayOfNumbers;

import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.Capacity;
import com.lugowoy.helper.utils.HelperArrayFiller;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.ReaderArrayLength;

/**
 * Write a program that enter a sequence of integers that finds and prints their
 * greatest common divisor.
 *
 * <p> Created by Konstantin Lugowoy on 09.05.2018.
 */
public class Main {

    public static void main(String[] args) {

        ReaderArrayLength readerLength = new ReaderArrayLength();

        int lengthArray = readerLength.read(System.in, System.out,
                                            ReaderArrayLength.MSG_ENTER_ARRAY_LENGTH);

        HelperArrayFiller fillerArray = new HelperArrayFiller();

        ArrayInts array = new ArrayInts(fillerArray.getArray(
                new FillingArrayRandomPrimitiveIntegers(), lengthArray,
                HelperFillerValues.INT_ZERO, HelperFillerValues.INT_POSITIVE_THOUSAND));

        System.out.println(array);

        new Executor().execute(() -> {
            DeterminantGreatestCommonDivisor<ArrayInts> determinantGCD =
                    DeterminantGreatestCommonDivisor::determineGreatestCommonDivisor;
            System.out.println("The greatest common divisor of the array is : "
                               + determinantGCD.determine(array));
        }, new OutputExecutionTimeToConsole());
    }

}
