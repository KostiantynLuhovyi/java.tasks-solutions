package com.lugowoy.tasks.solutions.arrays.multidimensional.rebuildMatrixBySubtractingArithmeticMeanFromRowElements;

import com.lugowoy.helper.checkers.CheckerMatrix;
import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionResultToConsole;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.matrix.numbers.primitives.FillingMatrixRandomPrimitiveDoubles;
import com.lugowoy.helper.models.matrices.MatrixDoubles;
import com.lugowoy.helper.utils.Capacity;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.HelperMatrixFiller;
import com.lugowoy.helper.utils.ReaderMatrixLength;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_DOWN;

/**
 * Rebuild the matrix by subtracting from the elements of each row of the matrix
 * the arithmetic mean of the elements of the row.
 *
 * <p>Created by Konstantin Lugowoy on 30.10.2018.
 */
public class Main {

    public static void main(String[] args) {

        ReaderMatrixLength readerMatrixLength = new ReaderMatrixLength();
        int rows = readerMatrixLength.readRows(System.in, System.out,
                                               ReaderMatrixLength.MSG_ENTER_MATRIX_ROWS);
        int columns = readerMatrixLength.readColumns(System.in, System.out,
                                                     ReaderMatrixLength.MSG_ENTER_MATRIX_COLUMNS);

        HelperMatrixFiller fillerMatrix = new HelperMatrixFiller();

        MatrixDoubles matrix = new MatrixDoubles(fillerMatrix.getArray(
                new FillingMatrixRandomPrimitiveDoubles(), rows, columns,
                HelperFillerValues.DOUBLE_ZERO,
                HelperFillerValues.DOUBLE_POSITIVE_TEN));

        System.out.println("Matrix : \n" + matrix + "\n");

        new Executor().execute(
                () -> subtractArithmeticMeanFromRowElements(matrix),
                new OutputExecutionResultToConsole(),
                OutputExecutionResultToConsole.RESULT_MATRIX,
                new OutputExecutionTimeToConsole());

    }

    private static MatrixDoubles subtractArithmeticMeanFromRowElements(
            @NotNull final MatrixDoubles matrix) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        int scale = 2;
        double arithmeticAverageValue;
        for (int i = 0; i < matrix.getRows(); i++) {
            arithmeticAverageValue = calculateArithmeticMeanOfMatrixRowElements(matrix, i);
            for (int j = 0; j < matrix.getColumns(); j++) {
                double element = matrix.getElement(i, j);
                BigDecimal newValue = new BigDecimal(
                        element - arithmeticAverageValue).setScale(scale, HALF_DOWN);
                matrix.setElement(newValue.doubleValue(), i, j);
            }
        }
        return matrix;
    }

    private static double calculateArithmeticMeanOfMatrixRowElements(
            @NotNull final MatrixDoubles matrix, int indexRow) {
        double resultArithmeticAverage = 0;
        for (int j = 0; j < matrix.getColumns(); j++) {
            resultArithmeticAverage += matrix.getElement(indexRow, j);
        }
        resultArithmeticAverage /= matrix.getRows();
        return resultArithmeticAverage;
    }

}
