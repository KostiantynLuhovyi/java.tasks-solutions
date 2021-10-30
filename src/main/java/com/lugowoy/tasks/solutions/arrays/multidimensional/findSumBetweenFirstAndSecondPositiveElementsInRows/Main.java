package com.lugowoy.tasks.solutions.arrays.multidimensional.findSumBetweenFirstAndSecondPositiveElementsInRows;

import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.matrix.numbers.primitives.FillingMatrixRandomPrimitiveIntegers;
import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.HelperMatrixFiller;
import com.lugowoy.helper.utils.ReaderMatrixLength;

/**
 * Find the sum of matrix elements located between the first and second positive
 * elements of each row.
 *
 * <p>Created by Konstantin Lugowoy on 29.10.2018.
 */
public class Main {

    private static final String RESULT_SUM_ELEMENTS = "Result sum elements in the %d row: %d";

    public static void main(String[] args) {

        ReaderMatrixLength readerMatrixLength = new ReaderMatrixLength();

        int rows = readerMatrixLength.readRows(System.in, System.out,
                                               ReaderMatrixLength.MSG_ENTER_MATRIX_ROWS);
        int columns = readerMatrixLength.readColumns(System.in, System.out,
                                                     ReaderMatrixLength.MSG_ENTER_MATRIX_COLUMNS);

        HelperMatrixFiller fillerMatrix = new HelperMatrixFiller();

        MatrixInts matrix = new MatrixInts(fillerMatrix.getArray(
                new FillingMatrixRandomPrimitiveIntegers(), rows, columns,
                HelperFillerValues.INT_NEGATIVE_TEN,
                HelperFillerValues.INT_POSITIVE_TEN));

        System.out.println("Matrix : \n" + matrix + "\n");


        new Executor().execute(() -> {
            FinderMatrixElements finder = new FinderMatrixElements();
            CalculatorMatrixElements calculator = new CalculatorMatrixElements();
            for (int i = 0; i < matrix.getRows(); i++) {
                int indexFirstPositive = finder.indexFirstPositiveMatrixElementInRow(matrix, i);
                int indexSecondPositive = finder.indexSecondPositiveMatrixElementInRow(matrix, i);
                int sum = calculator.calculateSumBetweenFirstAndSecondPositiveElementsInRow(
                                matrix, i, indexFirstPositive,
                                indexSecondPositive);
                System.out.printf(RESULT_SUM_ELEMENTS, i, sum);
            }
        }, new OutputExecutionTimeToConsole());

    }

}