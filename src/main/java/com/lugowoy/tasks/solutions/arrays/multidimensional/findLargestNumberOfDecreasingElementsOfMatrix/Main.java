package com.lugowoy.tasks.solutions.arrays.multidimensional.findLargestNumberOfDecreasingElementsOfMatrix;

import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionResultToConsole;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.matrix.numbers.primitives.FillingMatrixRandomPrimitiveIntegers;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.HelperMatrixFiller;
import com.lugowoy.helper.utils.ReaderMatrixLength;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * Find and display the largest number of decreasing elements of the matrix,
 * going in a row.
 *
 * <p>Created by Konstantin Lugowoy on 29.10.2018.
 */
public class Main {

    private static final int LOWER_BOUND = -20;
    private static final int UPPER_BOUND = 20;

    public static void main(String[] args) {

        ReaderMatrixLength readerMatrixLength = new ReaderMatrixLength();
        int rows = readerMatrixLength.readRows(System.in, System.out,
                                               ReaderMatrixLength.MSG_ENTER_MATRIX_ROWS);
        int columns = readerMatrixLength.readColumns(System.in, System.out,
                                                     ReaderMatrixLength.MSG_ENTER_MATRIX_COLUMNS);

        HelperMatrixFiller fillerMatrix = new HelperMatrixFiller();
        MatrixInts matrix = new MatrixInts(fillerMatrix.getArray(
                new FillingMatrixRandomPrimitiveIntegers(), rows, columns,
                LOWER_BOUND, UPPER_BOUND));

        System.out.println("Matrix : \n" + matrix + "\n");

        new Executor().execute(
                () -> findLargestNumberOfDecreasingElementsGoingInRows(matrix),
                new OutputExecutionResultToConsole(),
                OutputExecutionResultToConsole.RESULT_SEQUENCE,
                new OutputExecutionTimeToConsole());

    }

    private static ArrayInts findLargestNumberOfDecreasingElementsGoingInRows(
            @NotNull final MatrixInts matrix) {
        Objects.requireNonNull(matrix, "Matrix is null");
        ArrayInts tmpArray = convertMatrixIntoArray(matrix);
        int countIncreasingElements = 0;
        int maxSequence = 0;
        int indexLastIncreasingElement = 0;
        for (int i = 0; i < tmpArray.size() - 1; i++) {
            if (tmpArray.get(i) > tmpArray.get(i + 1)) {
                countIncreasingElements++;
                if (countIncreasingElements > maxSequence) {
                    maxSequence = countIncreasingElements;
                    indexLastIncreasingElement = i + 1;
                }
            } else {
                countIncreasingElements = 0;
            }
        }
        int[] ints = new int[maxSequence + 1];
        System.arraycopy(tmpArray.toArray(),
                         indexLastIncreasingElement - maxSequence, ints, 0,
                         maxSequence + 1);
        return new ArrayInts(ints);
    }

    private static ArrayInts convertMatrixIntoArray(
            @NotNull final MatrixInts matrix) {
        Objects.requireNonNull(matrix, "Matrix is null");
        ArrayInts resultArray = new ArrayInts();
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                resultArray.add(matrix.getElement(i, j));
            }
        }
        return resultArray;
    }
}
