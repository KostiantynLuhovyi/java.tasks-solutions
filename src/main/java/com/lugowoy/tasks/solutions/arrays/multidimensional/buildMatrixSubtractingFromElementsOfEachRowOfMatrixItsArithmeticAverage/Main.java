package com.lugowoy.tasks.solutions.arrays.multidimensional.buildMatrixSubtractingFromElementsOfEachRowOfMatrixItsArithmeticAverage;

import com.lugowoy.helper.filling.matrix.numbers.FillingMatrixRandomPrimitiveDoubles;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.matrices.MatrixDoubles;
import com.lugowoy.helper.utils.execution.Executor;

import java.math.BigDecimal;

import static com.lugowoy.helper.filling.ValuesToFilling.DOUBLE_UPPER_BOUND;
import static com.lugowoy.helper.utils.execution.OutputExecutorResult.MSG_STRING_RESULT;
import static com.lugowoy.helper.utils.execution.OutputExecutorTimer.MSG_MINUTES_AND_SECONDS;
import static java.math.RoundingMode.HALF_DOWN;

/**
 * Build a matrix, subtracting from the elements of each row of the matrix its arithmetic average.
 *
 * <p> Created by Konstantin Lugowoy on 30.10.2018.
 */
public class Main {

    private static final Reader READER = new Reader(new ReadingConsole());

    public static void main(String[] args) {

        System.out.println("Enter rows of the matrix : ");
        int rows = READER.readInt();
        System.out.println("Enter columns of the matrix : ");
        int columns = READER.readInt();

        MatrixDoubles matrix = new MatrixDoubles(new FillingMatrixRandomPrimitiveDoubles().fill(rows, columns, DOUBLE_UPPER_BOUND));

        System.out.println("Original matrix : ");
        System.out.println(matrix);

        Executor.execute(() -> subtractArithmeticAverageValueFromElementsOfMatrix(matrix), MSG_MINUTES_AND_SECONDS, MSG_STRING_RESULT);

    }

    private static MatrixDoubles subtractArithmeticAverageValueFromElementsOfMatrix(MatrixDoubles matrix) {
        int scale = 2;
        double arithmeticAverage = calculateArithmeticAverageOfMatrix(matrix);
        for (int i = 0; i < matrix.getRows(); i++){
            for (int j = 0; j < matrix.getColumns(); j++) {
                double element = matrix.getElement(i, j);
                BigDecimal newValue = new BigDecimal(element - arithmeticAverage).setScale(scale, HALF_DOWN);
                matrix.setElement(i, j, newValue.doubleValue());
            }
            arithmeticAverage = 0;
        }
        return matrix;
    }

    private static double calculateArithmeticAverageOfMatrix(MatrixDoubles matrix) {
        double resultArithmeticAverage = 0;
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                resultArithmeticAverage += matrix.getElement(i, j);
            }
            resultArithmeticAverage /= matrix.getColumns();
        }
        return resultArithmeticAverage;
    }

}
