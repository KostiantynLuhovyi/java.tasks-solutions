package com.lugowoy.tasks.solutions.arrays.multidimensional.moveMinimumElementIUsingPermutationOfRowsAndColumns;

import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.matrix.numbers.primitives.FillingMatrixRandomPrimitiveIntegers;
import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.HelperMatrixFiller;
import com.lugowoy.helper.utils.ReaderConsole;
import com.lugowoy.helper.utils.ReaderMatrixLength;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * Move the minimum matrix element to the specified location using permutation
 * of rows and columns.
 *
 * <p>Created by Konstantin Lugowoy on 05.11.2018.
 */
public class Main {

    private static final int BOUND = 200;

    public static void main(String[] args) {

        ReaderMatrixLength readerMatrixLength = new ReaderMatrixLength();
        int rows = readerMatrixLength.readRows(System.in, System.out,
                                               ReaderMatrixLength.MSG_ENTER_MATRIX_ROWS);
        int columns = readerMatrixLength.readColumns(System.in, System.out,
                                                     ReaderMatrixLength.MSG_ENTER_MATRIX_COLUMNS);

        HelperMatrixFiller fillerMatrix = new HelperMatrixFiller();
        MatrixInts matrix = new MatrixInts(fillerMatrix.getArray(
                new FillingMatrixRandomPrimitiveIntegers(), rows, columns,
                HelperFillerValues.INT_ZERO, BOUND));

        System.out.println("Original matrix : \n" + matrix + "\n");

        ReaderConsole readerConsole = new ReaderConsole();
        System.out.println("Enter the number of row for move : ");
        int indexRowToMove = readerConsole.readInt();
        System.out.println("Enter the number of column for move : ");
        int indexColumnToMove = readerConsole.readInt();

        new Executor().execute(() -> {
            IndexMinElement indexMinElement = new IndexMinElement();
            indexMinElement.findAndSetIndexesMinElement(matrix);
            int indexRowMinElement = indexMinElement.getIndexRowMinElement();
            int indexColumnMinElement =
                    indexMinElement.getIndexColumnMinElement();

            moveMinimumMatrixElementToSpecifiedLocation(matrix,
                                                        indexRowMinElement,
                                                        indexColumnMinElement,
                                                        indexRowToMove,
                                                        indexColumnToMove);

            System.out.println("Result matrix after move minimal element : \n");
            System.out.println(matrix);
        }, new OutputExecutionTimeToConsole());


    }

    private static void moveMinimumMatrixElementToSpecifiedLocation(
            @NotNull final MatrixInts matrix, final int indexRowMinElement,
            final int indexColumnMinElement, final int indexRowToMove,
            final int indexColumnToMove) {
        Objects.requireNonNull(matrix, "Matrix is null");
        if (indexRowToMove <= matrix.getRows() && indexColumnToMove <= matrix
                .getColumns()) {
            moveByRows(matrix, indexRowMinElement, indexRowToMove);
            moveByColumns(matrix, indexColumnMinElement, indexColumnToMove);
        } else {
            System.err.println("Incorrect indexes arguments.");
        }
    }

    private static void moveByColumns(final @NotNull MatrixInts matrix,
                                      final int indexColumnMinElement,
                                      final int indexColumnToMove) {
        Objects.requireNonNull(matrix, "Matrix is null");
        for (int i = 0; i < matrix.getColumns(); i++) {
            int tmp = matrix.getElement(i, indexColumnMinElement);
            matrix.setElement(i, indexColumnMinElement,
                              matrix.getElement(i, indexColumnToMove));
            matrix.setElement(i, indexColumnToMove, tmp);
        }
    }

    private static void moveByRows(final @NotNull MatrixInts matrix,
                                   final int indexRowMinElement,
                                   final int indexRowToMove) {
        Objects.requireNonNull(matrix, "Matrix is null");
        for (int i = 0; i < matrix.getRows(); i++) {
            int tmp = matrix.getElement(indexRowMinElement, i);
            matrix.setElement(indexRowMinElement, i,
                              matrix.getElement(indexRowToMove, i));
            matrix.setElement(indexRowToMove, i, tmp);
        }
    }

    private static class IndexMinElement {

        private int indexRowMinElement = 0;
        private int indexColumnMinElement = 0;

        public void findAndSetIndexesMinElement(
                @NotNull final MatrixInts matrix) {
            Objects.requireNonNull(matrix, "Matrix is null");
            int minElement = Integer.MAX_VALUE;
            for (int i = 0; i < matrix.getRows(); i++) {
                for (int j = 0; j < matrix.getColumns(); j++) {
                    int element = matrix.getElement(i, j);
                    if (element < minElement) {
                        minElement = element;
                        this.indexRowMinElement = i;
                        this.indexColumnMinElement = j;
                    }
                }
            }
        }

        public int getIndexRowMinElement() {
            return indexRowMinElement;
        }

        public int getIndexColumnMinElement() {
            return indexColumnMinElement;
        }

    }

}
