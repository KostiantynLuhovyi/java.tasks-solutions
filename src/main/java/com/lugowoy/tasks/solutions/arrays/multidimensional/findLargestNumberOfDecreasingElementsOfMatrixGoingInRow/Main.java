package com.lugowoy.tasks.solutions.arrays.multidimensional.findLargestNumberOfDecreasingElementsOfMatrixGoingInRow;

import com.lugowoy.helper.execution.OutputExecutionResultToConsole;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.matrix.numbers.primitives.FillingMatrixRandomPrimitiveIntegers;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.tasks.solutions.helper.Helper;
import com.lugowoy.tasks.solutions.helper.HelperFiller;
import org.jetbrains.annotations.NotNull;
import java.util.Objects;

import static com.lugowoy.tasks.solutions.helper.Helper.RESULT_SEQUENCE;

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

        int rows = Helper.readConsoleMatrixRows();
        int columns = Helper.readConsoleMatrixColumns();

        MatrixInts matrix = new MatrixInts(new HelperFiller().getArray(
                new FillingMatrixRandomPrimitiveIntegers(), rows, columns,
                LOWER_BOUND, UPPER_BOUND));

        System.out.println("Matrix : \n" + matrix + "\n");

        Helper.EXECUTOR.execute(
                () -> findLargestNumberOfDecreasingElementsGoingInRows(matrix),
                new OutputExecutionResultToConsole(), RESULT_SEQUENCE,
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
