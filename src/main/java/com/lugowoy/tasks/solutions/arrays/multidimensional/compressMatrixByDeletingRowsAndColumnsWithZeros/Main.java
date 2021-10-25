package com.lugowoy.tasks.solutions.arrays.multidimensional.compressMatrixByDeletingRowsAndColumnsWithZeros;

import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.matrix.numbers.primitives.FillingMatrixRandomPrimitiveIntegers;
import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.HelperMatrixFiller;
import com.lugowoy.helper.utils.ReaderMatrixLength;

/**
 * Compress the matrix by deleting rows and columns filled with zeros from it.
 *
 * <p>Created by Konstantin Lugowoy on 01.11.2018.
 */
public class Main {

    public static void main(String[] args) {

        ReaderMatrixLength readerMatrixLength = new ReaderMatrixLength();
        int rows = readerMatrixLength.readRows(System.in, System.out,
                                               ReaderMatrixLength.MSG_ENTER_MATRIX_ROWS);
        int columns = readerMatrixLength.readColumns(System.in, System.out,
                                                     ReaderMatrixLength.MSG_ENTER_MATRIX_COLUMNS);

        HelperMatrixFiller fillerMatrix = new HelperMatrixFiller();

        MatrixInts matrix = new MatrixInts(fillerMatrix.getArray(
                new FillingMatrixRandomPrimitiveIntegers(), rows, columns,
                HelperFillerValues.INT_ZERO,
                HelperFillerValues.INT_POSITIVE_ONE));

        System.out.println("Matrix : \n" + matrix + "\n");

        CompressorMatrix<MatrixInts> compressorMatrix =
                CompressorMatrix::compressMatrixRemovingRowsAndColumnsWithZeros;


        new Executor().execute(() -> {
            System.out.println("Result after compression: ");
            compressorMatrix.compress(matrix);
            System.out.println(matrix);
        }, new OutputExecutionTimeToConsole());

    }


}
