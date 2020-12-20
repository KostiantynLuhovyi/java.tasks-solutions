package com.lugowoy.tasks.solutions.arrays.multidimensional.compressMatrixByDeletingRowsAndColumnsWithZeros;

import com.lugowoy.helper.execution.OutputExecutionResultToConsole;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.matrix.numbers.primitives.FillingMatrixRandomPrimitiveIntegers;
import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.tasks.solutions.helper.Helper;
import com.lugowoy.tasks.solutions.helper.HelperFiller;
import org.jetbrains.annotations.NotNull;
import java.util.Objects;

/**
 * Compress the matrix by deleting rows and columns filled with zeros from it.
 *
 * <p>Created by Konstantin Lugowoy on 01.11.2018.
 */
public class Main {

    public static void main(String[] args) {

        int rows = Helper.readConsoleMatrixRows();
        int columns = Helper.readConsoleMatrixColumns();

        MatrixInts matrix = new MatrixInts(new HelperFiller().getArray(
                new FillingMatrixRandomPrimitiveIntegers(), rows, columns,
                HelperFiller.INT_ZERO, HelperFiller.INT_POSITIVE_ONE));

        System.out.println("Matrix : \n" + matrix + "\n");

        Helper.EXECUTOR.execute(() -> compressMatrix(matrix),
                                new OutputExecutionResultToConsole(),
                                Helper.RESULT_MATRIX,
                                new OutputExecutionTimeToConsole());

    }

    private static MatrixInts compressMatrix(@NotNull final MatrixInts matrix) {
        //todo Consider the solution to this problem using one cycle.
        Objects.requireNonNull(matrix, "Matrix is null");
        for (int i = 0; i < matrix.getRows(); i++) {
            int indexRowZeros = getIndexRowWithZeros(matrix, i);
            if (indexRowZeros != -1) {
                matrix.compressRow(indexRowZeros);
                --i;
            }
        }
        for (int i = 0; i < matrix.getColumns(); i++) {
            int indexColumnZeros = getIndexColumnWithZeros(matrix, i);
            if (indexColumnZeros != -1) {
                matrix.compressColumn(indexColumnZeros);
                --i;
            }
        }
        return matrix;
    }

    private static int getIndexColumnWithZeros(@NotNull final MatrixInts matrix,
                                               final int indexRow) {
        Objects.requireNonNull(matrix, "Matrix is null");
        int resultIndexRow = -1;
        int counterZeros = 0;
        for (int i = 0; i < matrix.getColumns(); i++) {
            if (matrix.getElement(indexRow, i) == 0) {
                counterZeros++;
            } else {
                break;
            }
        }
        if (counterZeros == matrix.getColumns()) {
            resultIndexRow = indexRow;
        }
        return resultIndexRow;
    }

    private static int getIndexRowWithZeros(@NotNull final MatrixInts matrix,
                                            final int indexColumn) {
        Objects.requireNonNull(matrix, "Matrix is null");
        int resultIndexColumn = -1;
        int counterZeros = 0;
        for (int i = 0; i < matrix.getRows(); i++) {
            if (matrix.getElement(i, indexColumn) == 0) {
                counterZeros++;
            } else {
                break;
            }
        }
        if (counterZeros == matrix.getRows()) {
            resultIndexColumn = indexColumn;
        }
        return resultIndexColumn;
    }

}
