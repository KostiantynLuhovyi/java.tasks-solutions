package com.lugowoy.tasks.solutions.arrays.multidimensional.findSumOfMatrixElementsLocatedBetweenFirstAndSecondPositiveElementsOfEachRow;

import com.lugowoy.helper.filling.ValuesToFilling;
import com.lugowoy.helper.filling.matrix.numbers.FillingMatrixRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.helper.utils.execution.Executor;

import static com.lugowoy.helper.filling.ValuesToFilling.INT_UPPER_BOUND;
import static com.lugowoy.helper.utils.execution.OutputExecutorTimer.MSG_MILLISECONDS;

/**
 * Find the sum of matrix elements located between the first and second positive elements of each row.
 * <p>
 * Created by Konstantin Lugowoy on 29.10.2018.
 */

public class Main {

    private static final Reader READER = new Reader(new ReadingConsole());

    public static void main(String[] args) {

        System.out.println("Enter rows of the matrix : ");
        int rows = READER.readInt();
        System.out.println("Enter columns of the matrix : ");
        int columns = READER.readInt();

        FillingMatrixRandomPrimitiveIntegers filler = new FillingMatrixRandomPrimitiveIntegers();

        MatrixInts matrix = new MatrixInts(filler.fill(rows, columns, ValuesToFilling.INT_LOWER_BOUND, INT_UPPER_BOUND));

        System.out.println("Matrix : ");
        System.out.println(matrix);

        Executor.execute(() -> findSumOfMatrixElementsLocatedBetweenFirstAndSecondPositiveElementsOfEachRow(matrix),
                               MSG_MILLISECONDS, "Result sum elements : %.3f");

    }

    private static int findSumOfMatrixElementsLocatedBetweenFirstAndSecondPositiveElementsOfEachRow(MatrixInts matrix) {
        int tmpSum = 0;
        int sumAllElements = 0;
        boolean firstPositive = false;
        boolean secondPositive = false;
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                if (matrix.getElement(i, j) > 0 && firstPositive)
                    secondPositive = true;
                else if (firstPositive && !secondPositive){
                    tmpSum += matrix.getElement(i, j);
                }
                else if (matrix.getElement(i, j) > 0 && !firstPositive)
                    firstPositive = true;
            }
            if (firstPositive && !secondPositive) {
                tmpSum = 0;
            }
            firstPositive = false;
            secondPositive = false;
            sumAllElements += tmpSum;
            tmpSum = 0;
        }
        return sumAllElements;
    }

}
