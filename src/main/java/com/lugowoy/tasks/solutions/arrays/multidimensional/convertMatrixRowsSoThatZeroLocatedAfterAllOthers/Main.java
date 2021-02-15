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

        new Executor().execute(
                () -> convertMatrixRowsSoThatZeroLocatedAfterAllOther(matrix),
                new OutputExecutionResultToConsole(),
                OutputExecutionResultToConsole.RESULT_MATRIX,
                new OutputExecutionTimeToConsole());

    }

    private static MatrixInts convertMatrixRowsSoThatZeroLocatedAfterAllOther(
            @NotNull final MatrixInts matrix) {
        Objects.requireNonNull(matrix, "Matrix is null");
        int indexElementOfRow = 0;
        for (int i = 0; i < matrix.getRows(); i++) {
            int[] tmp = new int[matrix.getRows()];
            for (int j = 0; j < matrix.getColumns(); j++) {
                int element = matrix.getElement(i, j);
                if (element != 0) {
                    tmp[indexElementOfRow] = element;
                } else {
                    continue;
                }
                indexElementOfRow++;
            }
            matrix.setRowFromArray(tmp, i);
            indexElementOfRow = 0;
        }
        return matrix;
    }

}
