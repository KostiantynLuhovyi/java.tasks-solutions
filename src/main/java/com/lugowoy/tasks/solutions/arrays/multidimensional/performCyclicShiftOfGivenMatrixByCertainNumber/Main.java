package com.lugowoy.tasks.solutions.arrays.multidimensional.performCyclicShiftOfGivenMatrixByCertainNumber;

import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.matrix.numbers.primitives.FillingMatrixRandomPrimitiveIntegers;
import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.HelperMatrixFiller;
import com.lugowoy.helper.utils.ReaderConsole;
import com.lugowoy.helper.utils.ReaderMatrixLength;

/**
 * Perform a cyclic shift of a given matrix by a certain number of positions to
 * the right (left, up, down).
 *
 * <p>Created by Konstantin Lugowoy on 28.10.2018.
 */
public class Main {

    private static final int BOUND = 20;

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

        System.out.println("Matrix : \n" + matrix + "\n");

        int numberToShiftMatrix = enterNumberToShiftMatrix(matrix.getRows());

        System.out.println("Select an action to perform : ");
        System.out.println("Press 1, to shift the matrix to the right.");
        System.out.println("Press 2, to shift the matrix to the left.");
        System.out.println("Press 3, to shift the matrix to the up.");
        System.out.println("Press 4, to shift the matrix to the down.");
        int selectValue = selectionActionToPerform();

        new Executor().execute(() -> {
            ShifterMatrix<MatrixInts> shifter;
            switch (selectValue) {
                case 1:
                    shifter = ShifterMatrixPrimitiveInteger::shiftMatrixToRight;
                    shifter.shift(matrix, numberToShiftMatrix);
                    break;
                case 2:
                    shifter = ShifterMatrixPrimitiveInteger::shiftMatrixToLeft;
                    shifter.shift(matrix, numberToShiftMatrix);
                    break;
                case 3:
                    shifter = ShifterMatrixPrimitiveInteger::shiftMatrixToUp;
                    shifter.shift(matrix, numberToShiftMatrix);
                    break;
                case 4:
                    shifter = ShifterMatrixPrimitiveInteger::shiftMatrixToDown;
                    shifter.shift(matrix, numberToShiftMatrix);
                    break;
            }

            System.out.println("Result matrix : ");
            System.out.println(matrix);
        }, new OutputExecutionTimeToConsole());

    }

    private static int enterNumberToShiftMatrix(int rows) {
        int resultNumber;
        ReaderConsole reader = new ReaderConsole();
        System.out.println("Enter the number to shift the matrix");
        while (true) {
            resultNumber = reader.readInt();
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
        ReaderConsole reader = new ReaderConsole();
        while (true) {
            resultSelection = reader.readInt();
            if (resultSelection > 0 && resultSelection <= 4) {
                break;
            } else {
                System.out.println("Incorrect value. Re-enter : ");
            }
        }
        return resultSelection;
    }

}

