package com.lugowoy.tasks.solutions.arrays.multidimensional.performCyclicShiftOfGivenMatrixByCertainNumber;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.tasks.solutions.Helper;

/**
 * Perform a cyclic shift of a given matrix by a certain number of positions to the right (left, up, down).
 * <p> Created by Konstantin Lugowoy on 28.10.2018.
 */
public class Main {

    private static final Reader READER = new Reader(new ReadingConsole());

    private static final int BOUND = 20;

    public static void main(String[] args) {

        int rows = Helper.enterMatrixRowCountToConsole();
        int columns = Helper.enterMatrixColumnCountToConsole();

        MatrixInts matrix = new MatrixInts(Helper.FILLING_MATRIX_INTS.fill(rows, columns, BOUND));

        System.out.println("Original matrix : ");
        System.out.println(matrix);

        int numberToShiftMatrix = enterNumberToShiftMatrix(matrix.getRows());

        System.out.println("Select an action to perform : ");
        System.out.println("Press 1, to shift the matrix to the right.");
        System.out.println("Press 2, to shift the matrix to the left.");
        System.out.println("Press 3, to shift the matrix to the up.");
        System.out.println("Press 4, to shift the matrix to the down.");
        int selectValue = selectionActionToPerform();

        Shifter<Integer> shifter;
        switch (selectValue) {
            case 1:
                shifter = ShifterIntegerMatrix::shiftMatrixToRight;
                shifter.shift(matrix, numberToShiftMatrix);
                break;
            case 2:
                shifter = ShifterIntegerMatrix::shiftMatrixToLeft;
                shifter.shift(matrix, numberToShiftMatrix);
                break;
            case 3:
                shifter = ShifterIntegerMatrix::shiftMatrixToUp;
                shifter.shift(matrix, numberToShiftMatrix);
                break;
            case 4:
                shifter = ShifterIntegerMatrix::shiftMatrixToDown;
                shifter.shift(matrix, numberToShiftMatrix);
                break;
        }

        System.out.println("Result matrix : ");
        System.out.println(matrix);

    }

    private static int enterNumberToShiftMatrix(int rows) {
        int resultNumber;
        System.out.println("Enter the number to shift the matrix");
        while (true) {
            resultNumber = READER.readInt();
            if (resultNumber >= 0 && resultNumber <= rows) {
                break;
            } else {
                System.out.println("Incorrect value. Re-enter : ");
            }
        }
        return resultNumber;
    }

    private static int selectionActionToPerform() {
        int resultSelection;
        while (true) {
            resultSelection = READER.readInt();
            if (resultSelection > 0 && resultSelection <= 4) {
                break;
            } else {
                System.out.println("Incorrect value. Re-enter : ");
            }
        }
        return resultSelection;
    }

}

