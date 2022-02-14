package com.lugowoy.tasks.solutions.arrays.onedimensional.outputNumbersFromArrayThatSatisfyConditionForSolutionOfTask;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.Capacity;
import com.lugowoy.helper.utils.HelperArrayFiller;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.ReaderArrayLength;
import org.jetbrains.annotations.NotNull;

/**
 * Write a program that has an array of random integers
 * and prints three of its (not necessarily distinct) elements x, y, and z, such that x * y = z.
 *
 * <p>Created by Konstantin Lugowoy on 25.04.2018.
 */
public class Main {

    private static final int BOUND = 20;

    public static void main(String[] args) {

        ReaderArrayLength readerLength = new ReaderArrayLength();
        int lengthArray = readerLength.read(System.in, System.out,
                                            ReaderArrayLength.MSG_ENTER_ARRAY_LENGTH);

        HelperArrayFiller filler = new HelperArrayFiller();
        ArrayInts array = new ArrayInts(filler.getArray(
                new FillingArrayRandomPrimitiveIntegers(), lengthArray,
                HelperFillerValues.INT_ZERO, BOUND));

        System.out.println("Array: " + array);

        new Executor().execute(() -> {
            printExpressionWithNumbersSatisfyingCondition(array);
        }, new OutputExecutionTimeToConsole());

    }

    private static void printExpressionWithNumbersSatisfyingCondition(
            @NotNull final ArrayInts array) {
        CheckerArray.check(array, Capacity.UPPER.get());
        int countExpression = 0;
        for (int i = 0; i < array.size(); i++) {
            for (int j = i + 1; j < array.size(); j++) {
                for (int k = 0; k < array.size(); k++) {
                    if (array.get(i) * array.get(j) == array.get(k)) {
                        System.out.printf("Expression: %d * %d = %d.\n", array.get(i), array.get(j), array.get(k));
                        countExpression++;
                    }
                }
            }
            if (countExpression == 0) {
                System.out.println("No numbers were found to evaluate the expression by condition.");
            }
        }
    }

}