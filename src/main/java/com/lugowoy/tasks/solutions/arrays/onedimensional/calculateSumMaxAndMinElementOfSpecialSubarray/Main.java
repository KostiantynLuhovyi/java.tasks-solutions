package com.lugowoy.tasks.solutions.arrays.onedimensional.calculateSumMaxAndMinElementOfSpecialSubarray;

import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.HelperArrayFiller;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.ReaderArrayLength;

/**
 * Given onedimensional array A[n]. Find: max(a2, a4, ..., a2k) + min(a1, a3,
 * ..., a2k-1).
 *
 * <p>Created by Konstantin Lugowoy on 01.03.2017.
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

        System.out.println("Array : " + array + "\n");

        new Executor().execute(() -> {
            DeterminantSubarray<ArrayInts> determinantSubarray =
                    DeterminantSubarray::determineEvenSubarray;
            ArrayInts evenSubarray = determinantSubarray.determine(array);

            determinantSubarray = DeterminantSubarray::determineOddSubarray;
            ArrayInts oddSubarray = determinantSubarray.determine(array);

            DeterminantElementArray<ArrayInts> determinant =
                    DeterminantElementArray::determineMaxElement;
            int maxElement = determinant.determine(evenSubarray);
            System.out.println("Max element in the even numbers subarray is "
                               + maxElement);

            determinant = DeterminantElementArray::determineMinElement;
            int minElement = determinant.determine(oddSubarray);
            System.out.println("Min element in the odd numbers subarray is "
                               + minElement);

            System.out.println();
            System.out.println("Result summation : " + (maxElement + minElement));
        }, new OutputExecutionTimeToConsole());

    }

}
