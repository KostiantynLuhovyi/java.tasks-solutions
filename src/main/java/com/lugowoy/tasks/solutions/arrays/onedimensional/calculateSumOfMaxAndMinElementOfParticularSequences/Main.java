package com.lugowoy.tasks.solutions.arrays.onedimensional.calculateSumOfMaxAndMinElementOfParticularSequences;

import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.Capacity;
import com.lugowoy.tasks.solutions.helper.Helper;
import com.lugowoy.tasks.solutions.helper.HelperFiller;

/**
 * Given onedimensional array A[n].
 * Find: max(a2, a4, ..., a2k) + min(a1, a3, ..., a2k-1).
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
            DeterminantSequence determinantSequence = DeterminantSequence::determineEvenSequence;
            ArrayInts evenSequence = determinantSequence.determine(array);

            determinantSequence = DeterminantSequence::determineOddSequence;
            ArrayInts oddSequence = determinantSequence.determine(array);

            DeterminantElement<ArrayInts> determinant = DeterminantElement::determineMaxElement;
            int maxElement = determinant.determine(evenSequence);
            System.out.println("Max element in the sequence even numbers is " + maxElement);

            determinant = DeterminantElement::determineMinElement;
            int minElement = determinant.determine(oddSequence);
            System.out.println("Min element in the sequence odd number is " + minElement);

            System.out.println();
            System.out.println("Result summation : " + (maxElement + minElement));

        }, new OutputExecutionTimeToConsole());

    }

}
