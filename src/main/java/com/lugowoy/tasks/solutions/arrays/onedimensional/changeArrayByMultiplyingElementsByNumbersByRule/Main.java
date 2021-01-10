package com.lugowoy.tasks.solutions.arrays.onedimensional.changeArrayByMultiplyingElementsByNumbersByRule;

import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.Capacity;
import com.lugowoy.tasks.solutions.helper.Helper;
import com.lugowoy.tasks.solutions.helper.HelperFiller;

/**
 * Given integers a1, a2, ..., an. It is required to multiply all the terms of
 * the sequence a1, a2, ... by the square of its smallest term, if ak ≥ 0, and
 * the square of its largest term, if ak ≤ 0.
 *
 * <p>Created by Konstantin Lugowoy on 25.03.2017.
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

            DeterminantElementArray determinant =
                    DeterminantElementArray::determineMinElement;
            int minValue = determinant.determine(array);

            determinant = DeterminantElementArray::determineMaxElement;
            int maxValue = determinant.determine(array);

            MultiplyingArrayElements multiply =
                    MultiplyingArrayElements::multiplyElementsBySquareMinOrMaxValue;
            multiply.multiply(array, minValue, maxValue);

            System.out.println("Result array : " + array);

        }, new OutputExecutionTimeToConsole());

    }

}
