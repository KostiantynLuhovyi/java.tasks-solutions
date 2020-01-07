package com.lugowoy.tasks.solutions.arrays.multidimensional.convertRowsOfMatrixSoThatElementsEqualToZeroLocatedAfterAllOthers;

import com.lugowoy.helper.filling.matrix.numbers.FillingMatrixRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.helper.utils.execution.Executor;
import com.lugowoy.helper.utils.execution.OutputExecutorTimer;

import java.util.Arrays;

import static com.lugowoy.helper.filling.ValuesToFilling.INT_UPPER_BOUND;
import static com.lugowoy.helper.utils.execution.OutputExecutorTimer.*;

/**
 * Convert the rows of the matrix so that the elements equal to zero are located after all the others.
 * <p> Created by Konstantin Lugowoy on 06.11.2018.
 */
public class Main {

    private static final Reader READER = new Reader(new ReadingConsole());

    private static final String MSG_OUTPUT_RESULT = "Result matrix : \n %s";

    public static void main(String[] args) {

        System.out.println("Enter rows of the matrix : ");
        int rows = READER.readInt();
        System.out.println("Enter columns of the matrix : ");
        int columns = READER.readInt();

        FillingMatrixRandomPrimitiveIntegers filler = new FillingMatrixRandomPrimitiveIntegers();

        MatrixInts matrix = new MatrixInts(filler.fill(rows, columns, INT_UPPER_BOUND));

        System.out.println("Original matrix : ");
        System.out.println(matrix);

        Executor.execute(() -> convertRowsOfMatrixSoThatZeroElementsLocatedAfterOther(matrix), MSG_MILLISECONDS, MSG_OUTPUT_RESULT);

    }

    private static MatrixInts convertRowsOfMatrixSoThatZeroElementsLocatedAfterOther(MatrixInts matrix) {
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
