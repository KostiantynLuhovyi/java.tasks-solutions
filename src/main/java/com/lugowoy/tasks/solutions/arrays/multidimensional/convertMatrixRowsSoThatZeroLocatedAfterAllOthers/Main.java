package com.lugowoy.tasks.solutions.arrays.multidimensional.convertMatrixRowsSoThatZeroLocatedAfterAllOthers;

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

/**
 * Convert the rows of the matrix so that the elements equal to zero are located
 * after all the others.
 *
 * <p>Created by Konstantin Lugowoy on 06.11.2018.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        ReaderMatrixLength readerMatrixLength = new ReaderMatrixLength();

        int rows = readerMatrixLength.readRows(System.in, System.out,
                                               ReaderMatrixLength.MSG_ENTER_MATRIX_ROWS);
        int columns = readerMatrixLength.readColumns(System.in, System.out,
                                                     ReaderMatrixLength.MSG_ENTER_MATRIX_COLUMNS);

        HelperMatrixFiller fillerMatrix = new HelperMatrixFiller();

        MatrixInts matrix = new MatrixInts(fillerMatrix.getArray(
                new FillingMatrixRandomPrimitiveIntegers(), rows, columns,
                HelperFillerValues.INT_ZERO,
                HelperFillerValues.INT_POSITIVE_TEN));

        System.out.println("Original matrix :\n" + matrix + "\n");

        ConverterMatrix<MatrixInts> converter =
                ConverterMatrix::convertMatrixSoThatRowsWithZerosAreAtEnd;

        new Executor().execute(
                () -> {
                    converter.convert(matrix);
                    System.out.println("Matrix after conversion\n" + matrix + "\n");
                }, new OutputExecutionTimeToConsole());

    }

}
