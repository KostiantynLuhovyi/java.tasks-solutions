package com.lugowoy.tasks.solutions.arrays.multidimensional.compressMatrixByRemovingRowsAndColumnsFilledWithZerosFromIt;

import com.lugowoy.helper.filling.matrix.numbers.FillingMatrixRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.helper.utils.execution.Executor;

import static com.lugowoy.helper.utils.execution.OutputExecutorTimer.MSG_MILLISECONDS;

/**
 * Compact the matrix by removing rows and columns filled with zeros from it.
 *
 * <p> Created by Konstantin Lugowoy on 01.11.2018.
 */

public class Main {

    private static final Reader READER = new Reader(new ReadingConsole());

    private static final int UPPER_BOUND = 1;

    private static final String MSG_OUTPUT_RESULT = "Result matrix : \n %s";

    public static void main(String[] args) {

        System.out.println("Enter rows of the matrix : ");
        int rows = READER.readInt();
        System.out.println("Enter columns of the matrix : ");
        int columns = READER.readInt();

        FillingMatrixRandomPrimitiveIntegers filler = new FillingMatrixRandomPrimitiveIntegers();

        MatrixInts matrix = new MatrixInts(filler.fill(rows, columns, UPPER_BOUND));

        System.out.println("Original matrix : ");
        System.out.println(matrix);

        Executor.execute(() -> compressMatrix(matrix), MSG_MILLISECONDS, MSG_OUTPUT_RESULT);

    }

    private static MatrixInts compressMatrix(MatrixInts matrix) {
        for (int i = 0; i < matrix.getRows(); i++) {
            int indexRowZeros = getIndexRowFilledZeros(matrix, i);
            if (indexRowZeros != -1) {
                matrix.compressRow(indexRowZeros);
                --i;
            }
        }
        for (int i = 0; i < matrix.getColumns(); i++) {
            int indexColumnZeros = getIndexColumnFilledZeros(matrix, i);
            if (indexColumnZeros != -1) {
                matrix.compressColumn(indexColumnZeros);
                --i;
            }
        }
        return matrix;
    }

    private static int getIndexRowFilledZeros(MatrixInts matrix, int indexRow) {
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

    private static int getIndexColumnFilledZeros(MatrixInts matrix, int indexColumn) {
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
