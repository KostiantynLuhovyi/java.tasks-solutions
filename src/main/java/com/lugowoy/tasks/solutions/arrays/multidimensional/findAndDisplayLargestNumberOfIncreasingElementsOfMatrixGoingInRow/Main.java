package com.lugowoy.tasks.solutions.arrays.multidimensional.findAndDisplayLargestNumberOfIncreasingElementsOfMatrixGoingInRow;

import com.lugowoy.helper.filling.matrix.numbers.FillingMatrixRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.execution.Executor;

import static com.lugowoy.helper.utils.execution.OutputExecutorTimer.MSG_MILLISECONDS;

/**
 * Find and display the largest number of increasing elements of the matrix, going in a row.
 * <p> Created by Konstantin Lugowoy on 28.10.2018.
 */
public class Main {

    private static final Reader READER = new Reader(new ReadingConsole());

    private static final int LOWER_BOUND = -20;
    private static final int UPPER_BOUND = 20;

    public static void main(String[] args) {

        System.out.println("Enter rows of the matrix : ");
        int rows = READER.readInt();
        System.out.println("Enter columns of the matrix : ");
        int columns = READER.readInt();

        FillingMatrixRandomPrimitiveIntegers filler = new FillingMatrixRandomPrimitiveIntegers();

        MatrixInts matrix = new MatrixInts(filler.fill(rows, columns, LOWER_BOUND, UPPER_BOUND));

        System.out.println("Matrix : ");
        System.out.println(matrix);

        Executor.execute(() -> findLargestNumberOfIncreasingElementsOfMatrixGoingInRow(matrix), MSG_MILLISECONDS, "Result sequence : %s");

    }

    private static ArrayInts findLargestNumberOfIncreasingElementsOfMatrixGoingInRow(MatrixInts matrix) {
        ArrayInts tmpArray = convertMatrixIntoArray(matrix);
        int countIncreasingElements = 0;
        int maxSequence = 0;
        int indexLastIncreasingElement = 0;
        for (int i = 0; i < tmpArray.size() - 1; i++) {
            if (tmpArray.get(i) < tmpArray.get(i + 1)) {
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
        System.arraycopy(tmpArray.toArray(), indexLastIncreasingElement - maxSequence,
                         ints, 0, maxSequence + 1);
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
