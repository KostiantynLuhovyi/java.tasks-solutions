package com.lugowoy.tasks.solutions.arrays.onedimensional.changeSequenceByMultiplyingElementsBySquareOfMinAndMaxNumbersByRule;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.AbstractArray;
import com.lugowoy.helper.models.storages.arrays.ArrayDoubles;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.ArrayLengthReader;
import com.lugowoy.helper.utils.execution.ExecutionResultOutputToConsole;
import com.lugowoy.helper.utils.execution.ExecutionTimeOutputToConsole;
import com.lugowoy.helper.utils.execution.Executor;
import com.lugowoy.tasks.solutions.Helper;

import static com.lugowoy.helper.filling.ValuesToFilling.INT_LOWER_BOUND;
import static com.lugowoy.helper.filling.ValuesToFilling.INT_UPPER_BOUND;
import static com.lugowoy.tasks.solutions.Helper.RESULT_MATRIX;

/**
 * Given integers a1, a2, ..., an.
 * It is required to multiply all the terms of the sequence a1, a2, ... by the square of its smallest term, if ak ≥ 0,
 * and the square of its largest term, if ak ≤ 0.
 * <p> Created by Konstantin Lugowoy on 25.03.2017.
 */
public class Main {

    private static final MultiplyingSequenceElementsByRule<ArrayDoubles, Double> MULTIPLYING =
                             MultiplyingSequenceElementsByRule::multiplySequenceElementsBySquareOfMinAndMaxNumberByRule;

    public static void main(String[] args) throws Exception {

        int lengthOfArray = Helper.enterArrayLengthToConsole();

        ArrayDoubles array = new ArrayDoubles(Helper.FILLING_ARRAY_DOUBLES.fill(lengthOfArray, INT_LOWER_BOUND, INT_UPPER_BOUND));

        System.out.println("Original sequence : " + array);
        System.out.println();

        double squareMinNumber = squareMinNumberOfSequence(array, DeterminantElement::determineMinNumber);
        System.out.printf("Square min number of the array is : %.3f", squareMinNumber);
        double squareMaxNumber = squareMaxNumberOfSequence(array, DeterminantElement::determineMaxNumber);
        System.out.printf("Square max number of the array is : %.3f", squareMaxNumber);

        Executor.execute(() -> MULTIPLYING.multiply(array, squareMinNumber, squareMaxNumber),
                                          ExecutionResultOutputToConsole::outputExecutionResultToConsole, RESULT_MATRIX,
                                          ExecutionTimeOutputToConsole::outputExecutionTime);

    }

    private static double squareMaxNumberOfSequence(ArrayDoubles array, DeterminantElement<ArrayDoubles, Double> determinant) {
        return Math.pow(determinant.determine(array), 2);
    }

    private static double squareMinNumberOfSequence(ArrayDoubles array, DeterminantElement<ArrayDoubles, Double> determinant) {
        return Math.pow(determinant.determine(array), 2);
    }

}
