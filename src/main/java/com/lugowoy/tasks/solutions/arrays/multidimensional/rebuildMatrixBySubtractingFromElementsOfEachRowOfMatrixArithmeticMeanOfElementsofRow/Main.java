package com.lugowoy.tasks.solutions.arrays.multidimensional.rebuildMatrixBySubtractingFromElementsOfEachRowOfMatrixArithmeticMeanOfElementsofRow;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.matrices.MatrixDoubles;
import com.lugowoy.helper.utils.execution.ExecutionResultOutputToConsole;
import com.lugowoy.helper.utils.execution.ExecutionTimeOutputToConsole;
import com.lugowoy.helper.utils.execution.Executor;
import com.lugowoy.tasks.solutions.Helper;

import java.math.BigDecimal;

import static com.lugowoy.helper.filling.ValuesToFilling.DOUBLE_UPPER_BOUND;
import static com.lugowoy.helper.utils.execution.ExecutionResultOutputToConsole.RESULT_STRING;
import static java.math.RoundingMode.HALF_DOWN;

/**
 * Rebuild the matrix by subtracting from the elements of each row of the matrix the arithmetic mean of the elements of the row.
 * <p> Created by Konstantin Lugowoy on 30.10.2018.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        int rows = Helper.enterMatrixRowCountToConsole();
        int columns = Helper.enterMatrixColumnCountToConsole();

        MatrixDoubles matrix = new MatrixDoubles(Helper.FILLING_MATRIX_DOUBLES.fill(rows, columns, DOUBLE_UPPER_BOUND));

        System.out.println("Matrix : \n" + matrix);

        Executor.execute(() -> subtractArithmeticAverageValueFromEachMatrixElement(matrix),
                                          ExecutionResultOutputToConsole::outputExecutionResultToConsole, RESULT_STRING,
                                          ExecutionTimeOutputToConsole::outputExecutionTime);

    }

    private static MatrixDoubles subtractArithmeticAverageValueFromEachMatrixElement(MatrixDoubles matrix) {
        int scale = 2;
        double arithmeticAverageValue;
        for (int i = 0; i < matrix.getRows(); i++) {
            arithmeticAverageValue = calculateArithmeticAverageOfMatrixRow(matrix, i);
            for (int j = 0; j < matrix.getColumns(); j++) {
                double element = matrix.getElement(i, j);
                BigDecimal newValue = new BigDecimal(element - arithmeticAverageValue).setScale(scale, HALF_DOWN);
                matrix.setElement(i, j, newValue.doubleValue());
            }
        }
        return matrix;
    }

    private static double calculateArithmeticAverageOfMatrixRow(MatrixDoubles matrix, int indexRow) {
        double resultArithmeticAverage = 0;
        for (int j = 0; j < matrix.getColumns(); j++) {
            resultArithmeticAverage += matrix.getElement(indexRow, j);
        }
        resultArithmeticAverage /= matrix.getRows();
        return resultArithmeticAverage;
    }



}
