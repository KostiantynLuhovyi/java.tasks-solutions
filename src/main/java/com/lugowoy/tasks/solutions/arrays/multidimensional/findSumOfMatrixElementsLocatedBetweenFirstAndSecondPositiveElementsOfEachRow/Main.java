package com.lugowoy.tasks.solutions.arrays.multidimensional.findSumOfMatrixElementsLocatedBetweenFirstAndSecondPositiveElementsOfEachRow;

import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.helper.utils.execution.ExecutionResultOutputToConsole;
import com.lugowoy.helper.utils.execution.ExecutionTimeOutputToConsole;
import com.lugowoy.helper.utils.execution.Executor;
import com.lugowoy.tasks.solutions.Helper;

import static com.lugowoy.helper.filling.ValuesToFilling.INT_LOWER_BOUND;
import static com.lugowoy.helper.filling.ValuesToFilling.INT_UPPER_BOUND;

/**
 * Find the sum of matrix elements located between the first and second positive elements of each row.
 * <p> Created by Konstantin Lugowoy on 29.10.2018.
 */
public class Main {

    private static final String RESULT_SUM_ELEMENTS = "Result sum elements : %d";

    public static void main(String[] args) throws Exception {

        int rows = Helper.enterMatrixRowCountToConsole();
        int columns = Helper.enterMatrixColumnCountToConsole();

        MatrixInts matrix = new MatrixInts(Helper.FILLING_MATRIX_INTS.fill(rows, columns, INT_LOWER_BOUND, INT_UPPER_BOUND));

        System.out.println("Matrix : ");
        System.out.println(matrix);

        Executor.execute(() -> findSumOfMatrixElementsLocatedBetweenFirstAndSecondPositiveElementsOfEachRow(matrix),
                                    ExecutionResultOutputToConsole::outputExecutionResultToConsole, RESULT_SUM_ELEMENTS,
                                    ExecutionTimeOutputToConsole::outputExecutionTime);

    }

    private static int findSumOfMatrixElementsLocatedBetweenFirstAndSecondPositiveElementsOfEachRow(MatrixInts matrix) {
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
