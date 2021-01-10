package com.lugowoy.tasks.solutions.arrays.onedimensional.calculateSumMaxAndMinElementOfSpecialSubarray;

import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.Capacity;
import com.lugowoy.tasks.solutions.helper.Helper;
import com.lugowoy.tasks.solutions.helper.HelperFiller;

/**
 * Given onedimensional array A[n]. Find: max(a2, a4, ..., a2k) + min(a1, a3,
 * ..., a2k-1).
 *
 * <p>Created by Konstantin Lugowoy on 01.03.2017.
 */
public class Main {

    public static void main(String[] args) {

        int lengthArray = Helper.readConsoleArrayLength(
                Helper.INPUT_LENGTH_ARRAY, Capacity.UPPER.get());

        ArrayInts array = new ArrayInts(new HelperFiller().getArray(
                new FillingArrayRandomPrimitiveIntegers(), lengthArray,
                HelperFiller.INT_NEGATIVE_TEN, HelperFiller.INT_POSITIVE_TEN));

        System.out.println("Array : " + array + "\n");

        Helper.EXECUTOR.execute(() -> {

            DeterminantSubarray determinantSubarray =
                    DeterminantSubarray::determineEvenSubarray;
            ArrayInts evenSubarray = determinantSubarray.determine(array);

            determinantSubarray = DeterminantSubarray::determineOddSubarray;
            ArrayInts oddSubarray = determinantSubarray.determine(array);

            DeterminantElementArray<ArrayInts> determinant =
                    DeterminantElementArray::determineMaxElement;
            int maxElement = determinant.determine(evenSubarray);
            System.out.println("Max element in the even numbers subarray is " + maxElement);

            determinant = DeterminantElementArray::determineMinElement;
            int minElement = determinant.determine(oddSubarray);
            System.out.println("Min element in the odd numbers subarray is " + minElement);

            System.out.println();
            System.out.println("Result summation : " + (maxElement + minElement));

        }, new OutputExecutionTimeToConsole());

    }

}
