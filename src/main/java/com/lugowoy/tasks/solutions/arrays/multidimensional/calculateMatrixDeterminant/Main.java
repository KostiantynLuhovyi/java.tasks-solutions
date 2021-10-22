package com.lugowoy.tasks.solutions.arrays.multidimensional.calculateMatrixDeterminant;

import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionResultToConsole;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.matrix.numbers.primitives.FillingMatrixRandomPrimitiveIntegers;
import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.HelperMatrixFiller;
import com.lugowoy.helper.utils.ReaderMatrixLength;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import static java.lang.Math.pow;

/**
 * Calculate the matrix determinant.
 *
 * <p>Created by Konstantin Lugowoy on 31.10.2018.
 */
public class Main {

    private static final String MSG_DETERMINANT_RESULT = "Matrix determinant : %.3f\n";

    public static void main(String[] args) {

        ReaderMatrixLength readerMatrixLength = new ReaderMatrixLength();
        int rows = readerMatrixLength.readRows(System.in, System.out,
                                               ReaderMatrixLength.MSG_ENTER_MATRIX_ROWS);
        int columns = readerMatrixLength.readColumns(System.in, System.out,
                                                     ReaderMatrixLength.MSG_ENTER_MATRIX_COLUMNS);

        HelperMatrixFiller fillerMatrix = new HelperMatrixFiller();

        MatrixInts matrix = new MatrixInts(fillerMatrix.getArray(
                new FillingMatrixRandomPrimitiveIntegers(), rows, columns,
                HelperFillerValues.INT_NEGATIVE_THOUSAND,
                HelperFillerValues.INT_POSITIVE_THOUSAND));

        System.out.println("Matrix :\n" + matrix + "\n");

        CalculatorMatrixDeterminant<Double, MatrixInts> calculator =
                CalculatorMatrixDeterminant::calculateDeterminantMatrix;

        new Executor().execute(() -> calculator.calculate(matrix),
                               new OutputExecutionResultToConsole(),
                               MSG_DETERMINANT_RESULT,
                               new OutputExecutionTimeToConsole());

    }

}
