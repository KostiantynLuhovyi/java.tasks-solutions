package com.lugowoy.tasks.solutions.arrays.multidimensional.rebuildMatrixBySubtractingFromElementsOfEachRowOfMatrixArithmeticMeanOfElementsOfRow;

import com.lugowoy.helper.execution.OutputExecutionResultToConsole;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.matrix.numbers.primitives.FillingMatrixRandomPrimitiveDoubles;
import com.lugowoy.helper.models.matrices.MatrixDoubles;
import com.lugowoy.tasks.solutions.helper.Helper;
import com.lugowoy.tasks.solutions.helper.HelperFiller;
import org.jetbrains.annotations.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

import static java.math.RoundingMode.HALF_DOWN;

/**
 * Rebuild the matrix by subtracting from the elements of each row of the matrix
 * the arithmetic mean of the elements of the row.
 *
 * <p>Created by Konstantin Lugowoy on 30.10.2018.
 */
public class Main {

    public static void main(String[] args) {

        int rows = Helper.readConsoleMatrixRows();
        int columns = Helper.readConsoleMatrixColumns();

        MatrixDoubles matrix = new MatrixDoubles(new HelperFiller().getArray(
                new FillingMatrixRandomPrimitiveDoubles(), rows, columns,
                HelperFiller.DOUBLE_ZERO, HelperFiller.DOUBLE_POSITIVE_TEN));

        System.out.println("Matrix : \n" + matrix + "\n");

        Helper.EXECUTOR.execute(
                () -> subtractArithmeticAverageValueFromEachMatrixElement(matrix),
                new OutputExecutionResultToConsole(), Helper.RESULT_MATRIX,
                new OutputExecutionTimeToConsole());

    }

    private static MatrixDoubles subtractArithmeticAverageValueFromEachMatrixElement(
            @NotNull final MatrixDoubles matrix) {
        Objects.requireNonNull(matrix, "Matrix is null");
        int scale = 2;
        double arithmeticAverageValue;
        for (int i = 0; i < matrix.getRows(); i++) {
            arithmeticAverageValue = calculateArithmeticAverageOfMatrixRow(matrix, i);
            for (int j = 0; j < matrix.getColumns(); j++) {
                double element = matrix.getElement(i, j);
                BigDecimal newValue = new BigDecimal(
                        element - arithmeticAverageValue).setScale(scale, HALF_DOWN);
                matrix.setElement(newValue.doubleValue(), i, j);
            }
        }
        return matrix;
    }

    private static double calculateArithmeticAverageOfMatrixRow(
            MatrixDoubles matrix, int indexRow) {
        double resultArithmeticAverage = 0;
        for (int j = 0; j < matrix.getColumns(); j++) {
            resultArithmeticAverage += matrix.getElement(indexRow, j);
        }
        resultArithmeticAverage /= matrix.getRows();
        return resultArithmeticAverage;
    }

}
