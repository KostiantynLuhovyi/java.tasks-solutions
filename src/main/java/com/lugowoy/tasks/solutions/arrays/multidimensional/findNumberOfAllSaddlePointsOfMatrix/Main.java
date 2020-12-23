package com.lugowoy.tasks.solutions.arrays.multidimensional.findNumberOfAllSaddlePointsOfMatrix;

import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.matrix.numbers.primitives.FillingMatrixRandomPrimitiveIntegers;
import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.tasks.solutions.helper.Helper;
import com.lugowoy.tasks.solutions.helper.HelperFiller;
import org.jetbrains.annotations.NotNull;
import java.util.Objects;

/**
 * Find the number of all saddle points of the matrix.
 *
 * <p>Created by Konstantin Lugowoy on 07.11.2018.
 */
public class Main {

    public static void main(String[] args) {

        int rows = Helper.readConsoleMatrixRows();
        int columns = Helper.readConsoleMatrixColumns();

        MatrixInts matrix = new MatrixInts(new HelperFiller().getArray(
                new FillingMatrixRandomPrimitiveIntegers(), rows, columns,
                HelperFiller.INT_ZERO, HelperFiller.INT_POSITIVE_HUNDRED));

        System.out.println("Matrix : \n" + matrix + "\n");

        Helper.EXECUTOR.execute(() -> findSaddleNumbersOfMatrix(matrix),
                                new OutputExecutionTimeToConsole());

    }

    private static void findSaddleNumbersOfMatrix(
            @NotNull final MatrixInts matrix) {
        Objects.requireNonNull(matrix, "Matrix is null");
        int counterResult = 0;
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                int element = matrix.getElement(i, j);
                if (isMinElementInRow(matrix, i, element)
                    && isMaxElementInColumn(matrix, j, element)) {
                    System.out.println("Saddle value under the row index : " + i
                                       + " and column index :" + j
                                       + " equals : " + element);
                    counterResult++;
                }
            }
        }
        if (counterResult == 0) {
            System.out.println("Matrix does not contain saddle values");
        }
    }

    private static boolean isMinElementInRow(@NotNull final MatrixInts matrix,
                                             final int indexRow,
                                             final int valueToEqual) {
        boolean result = true;
        for (int i = 0; i < matrix.getColumns(); i++) {
            int element = matrix.getElement(indexRow, i);
            if (element < valueToEqual) {
                result = false;
                break;
            }
        }
        return result;
    }

    private static boolean isMaxElementInColumn(@NotNull final MatrixInts matrix,
                                                final int indexColumn,
                                                final int valueToEqual) {
        boolean result = true;
        for (int i = 0; i < matrix.getRows(); i++) {
            int element = matrix.getElement(i, indexColumn);
            if (element > valueToEqual) {
                result = false;
                break;
            }
        }
        return result;
    }

}
