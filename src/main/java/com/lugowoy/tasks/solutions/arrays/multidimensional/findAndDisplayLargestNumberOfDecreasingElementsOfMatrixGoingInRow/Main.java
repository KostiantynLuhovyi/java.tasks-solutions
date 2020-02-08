package com.lugowoy.tasks.solutions.arrays.multidimensional.findAndDisplayLargestNumberOfDecreasingElementsOfMatrixGoingInRow;

import com.lugowoy.helper.filling.matrix.numbers.FillingMatrixRandomPrimitiveIntegers;
import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.execution.ExecutionResultOutputToConsole;
import com.lugowoy.helper.utils.execution.ExecutionTimeOutputToConsole;
import com.lugowoy.helper.utils.execution.Executor;
import com.lugowoy.tasks.solutions.Helper;

import static com.lugowoy.tasks.solutions.Helper.RESULT_SEQUENCE;

/**
 * Find and display the largest number of decreasing elements of the matrix, going in a row.
 * <p> Created by Konstantin Lugowoy on 29.10.2018.
 */
public class Main {

    private static final int LOWER_BOUND = -20;
    private static final int UPPER_BOUND = 20;

    public static void main(String[] args) throws Exception {

        int rows = Helper.enterMatrixRowCountToConsole();
        int columns = Helper.enterMatrixColumnCountToConsole();

        MatrixInts matrix = new MatrixInts(Helper.FILLING_MATRIX_INTS.fill(rows, columns, LOWER_BOUND, UPPER_BOUND));

        System.out.println("Matrix : ");
        System.out.println(matrix);

        Executor.execute(() -> findLargestNumberOfDecreasingElementsOfMatrixGoingInRow(matrix),
                                        ExecutionResultOutputToConsole::outputExecutionResultToConsole, RESULT_SEQUENCE,
                                        ExecutionTimeOutputToConsole::outputExecutionTime);

    }

    private static ArrayInts findLargestNumberOfDecreasingElementsOfMatrixGoingInRow(MatrixInts matrix) {
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
        System.arraycopy(tmpArray.toArray(), indexLastIncreasingElement - maxSequence, ints, 0, maxSequence + 1);
        return new ArrayInts(ints);
    }

    private static ArrayInts convertMatrixIntoArray(MatrixInts matrix) {
        ArrayInts resultArray = new ArrayInts();
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                resultArray.add(matrix.getElement(i, j));
            }
        }
        return resultArray;
    }
}
