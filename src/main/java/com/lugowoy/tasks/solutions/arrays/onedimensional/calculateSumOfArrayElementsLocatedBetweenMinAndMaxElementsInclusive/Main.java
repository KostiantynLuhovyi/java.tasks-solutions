package com.lugowoy.tasks.solutions.arrays.onedimensional.calculateSumOfArrayElementsLocatedBetweenMinAndMaxElementsInclusive;

import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.execution.ExecutionResultOutputToConsole;
import com.lugowoy.helper.utils.execution.ExecutionTimeOutputToConsole;
import com.lugowoy.helper.utils.execution.Executor;
import com.lugowoy.tasks.solutions.Helper;

import static com.lugowoy.helper.filling.ValuesToFilling.INT_LOWER_BOUND;
import static com.lugowoy.helper.filling.ValuesToFilling.INT_UPPER_BOUND;
import static com.lugowoy.tasks.solutions.arrays.onedimensional.calculateSumOfArrayElementsLocatedBetweenMinAndMaxElementsInclusive.CalculationSumBetweenElements.calculateSumBetweenMinAndMaxElementsIndices;

/**
 * Calculate the sum of array elements located between the minimum and maximum elements inclusive.
 * <p> Created by Konstantin Lugowoy on 27.03.2017.
 */
public class Main {

    private static final String RESULT_SUM_BETWEEN_MIN_AND_MAX_INDICES =
                              "Sum of elements of the array located between the min and max elements inclusive is : %d";

    public static void main(String[] args) throws Exception {

        int lengthOfArray = Helper.enterArrayLengthToConsole();

        ArrayInts array = new ArrayInts(Helper.FILLING_ARRAY_INTS.fill(lengthOfArray, INT_LOWER_BOUND, INT_UPPER_BOUND));

        System.out.println("Original array : " + array);

        System.out.println();

        DeterminantElementIndex determinantElementIndex = DeterminantElementIndex::determineMinElementIndex;
        int indexMinElement = determinantElementIndex.determineElementIndex(array);
        System.out.println("Index min element in the array is : " + indexMinElement);

        determinantElementIndex = DeterminantElementIndex::determineMaxElementIndex;
        int indexMaxElement = determinantElementIndex.determineElementIndex(array);
        System.out.println("Index max element in the array is : " + indexMaxElement);

        System.out.println();


        Executor.execute(() -> calculateSumBetweenMinAndMaxElementsIndices(array, indexMinElement, indexMaxElement),
                 ExecutionResultOutputToConsole::outputExecutionResultToConsole, RESULT_SUM_BETWEEN_MIN_AND_MAX_INDICES,
                 ExecutionTimeOutputToConsole::outputExecutionTime);

    }

}
