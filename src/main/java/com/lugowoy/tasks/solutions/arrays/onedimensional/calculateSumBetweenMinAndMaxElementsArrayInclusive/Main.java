package com.lugowoy.tasks.solutions.arrays.onedimensional.calculateSumBetweenMinAndMaxElementsArrayInclusive;

import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.HelperArrayFiller;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.ReaderArrayLength;

/**
 * Calculate the sum of array elements located between the minimum and maximum
 * elements inclusive.
 *
 * <p>Created by Konstantin Lugowoy on 27.03.2017.
 */
public class Main {

    private static final String RESULT_SUM_BETWEEN_MIN_AND_MAX_ELEMENTS =
            "Sum of array elements between the min and max elements inclusive is : %d";

    public static void main(String[] args) {

        ReaderArrayLength readerArrayLength = new ReaderArrayLength();
        int lengthArray = readerArrayLength.read(System.in, System.out,
                                                 ReaderArrayLength.MSG_ENTER_ARRAY_LENGTH);

        HelperArrayFiller fillerArray = new HelperArrayFiller();

        ArrayInts array = new ArrayInts(fillerArray.getArray(
                new FillingArrayRandomPrimitiveIntegers(), lengthArray,
                HelperFillerValues.INT_NEGATIVE_TEN,
                HelperFillerValues.INT_POSITIVE_TEN));

        System.out.println("Original array : " + array + "\n");

        new Executor().execute(() -> {
            DeterminantArrayElementIndex<ArrayInts> determinant =
                    DeterminantArrayElementIndex::determineMinElementIndex;
            int indexMinElement = determinant.determine(array);
            System.out.println("Index min element in the array is : " + indexMinElement);

            determinant = DeterminantArrayElementIndex::determineMaxElementIndex;
            int indexMaxElement = determinant.determine(array);
            System.out.println("Index max element in the array is : " + indexMaxElement);

            CalculationSumArrayElements<Integer, ArrayInts> calc =
                    CalculationSumArrayElements::calculateSumBetweenMinAndMaxArrayElement;
            int resultSum = calc.calculate(array, indexMinElement, indexMaxElement);

            System.out.printf(RESULT_SUM_BETWEEN_MIN_AND_MAX_ELEMENTS, resultSum);
        }, new OutputExecutionTimeToConsole());

    }

}
