package com.lugowoy.tasks.solutions.arrays.multidimensional.findSumOfMatrixElementsLocatedBetweenFirstAndSecondPositiveElementsOfEachRow;

import com.lugowoy.helper.execution.OutputExecutionResultToConsole;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.matrix.numbers.primitives.FillingMatrixRandomPrimitiveIntegers;
import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.tasks.solutions.helper.Helper;
import com.lugowoy.tasks.solutions.helper.HelperFiller;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * Find the sum of matrix elements located between the first and second positive
 * elements of each row.
 *
 * <p>Created by Konstantin Lugowoy on 29.10.2018.
 */
public class Main {

    private static final String RESULT_SUM_ELEMENTS =
            "Result sum elements : %d";

    public static void main(String[] args) throws Exception {

        int rows = Helper.readConsoleMatrixRows();
        int columns = Helper.readConsoleMatrixColumns();

        MatrixInts matrix = new MatrixInts(new HelperFiller().getArray(
                new FillingMatrixRandomPrimitiveIntegers(), rows, columns,
                HelperFiller.INT_NEGATIVE_TEN, HelperFiller.INT_POSITIVE_TEN));

        System.out.println("Matrix : \n" + matrix + "\n");

        Helper.EXECUTOR.execute(() -> findSumOfMatrixElements(matrix),
                                new OutputExecutionResultToConsole(),
                                RESULT_SUM_ELEMENTS,
                                new OutputExecutionTimeToConsole());

    }

    private static int findSumOfMatrixElements(
            @NotNull final MatrixInts matrix) {
        Objects.requireNonNull(matrix, "Matrix is null");
        int tmpSum = 0;
        int sumAllElements = 0;
        boolean firstPositive = false;
        boolean secondPositive = false;
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                int element = matrix.getElement(i, j);
                if (element > 0 && firstPositive) {
                    secondPositive = true;
                } else if (firstPositive && !secondPositive) {
                    tmpSum += element;
                } else if (element > 0 && !firstPositive) {
                    firstPositive = true;
                }
            }
            if (firstPositive && !secondPositive) {
                tmpSum = 0;
            }
            firstPositive = false;
            secondPositive = false;
            sumAllElements += tmpSum;
            tmpSum = 0;
        }
        return sumAllElements;
    }

}
