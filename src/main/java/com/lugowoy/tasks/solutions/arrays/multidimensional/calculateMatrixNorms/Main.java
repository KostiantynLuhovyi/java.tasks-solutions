package com.lugowoy.tasks.solutions.arrays.multidimensional.calculateMatrixNorms;

import com.lugowoy.helper.filling.matrix.numbers.FillingMatrixRandomPrimitiveDoubles;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.matrices.MatrixDoubles;

import static com.lugowoy.helper.filling.ValuesToFilling.DOUBLE_LOWER_BOUND;
import static com.lugowoy.helper.filling.ValuesToFilling.DOUBLE_UPPER_BOUND;

/**
 * Calculate the matrix norms.
 *
 * <p> Created by Konstantin Lugowoy on 30.10.2018.
 */

public class Main {

    private static final Reader READER = new Reader(new ReadingConsole());

    public static void main(String[] args) {

        System.out.println("Enter rows of the matrix : ");
        int rows = READER.readInt();
        System.out.println("Enter columns of the matrix : ");
        int columns = READER.readInt();

        FillingMatrixRandomPrimitiveDoubles filler = new FillingMatrixRandomPrimitiveDoubles();

        MatrixDoubles matrix = new MatrixDoubles(filler.fill(rows, columns, DOUBLE_LOWER_BOUND, DOUBLE_UPPER_BOUND));

        System.out.println("Matrix : ");
        System.out.println(matrix);

        CalculatorMatrixNorms calculatorMatrixNorms = CalculatorMatrixNorms::calculateMatrixRowsNorm;
        double normMatrixRows = calculatorMatrixNorms.calculateMatrixNorm(matrix);

        calculatorMatrixNorms = CalculatorMatrixNorms::calculateMatrixColumnsNorm;
        double normMatrixColumns = calculatorMatrixNorms.calculateMatrixNorm(matrix);

        System.out.printf("Norm of rows : %.3f", normMatrixRows);
        System.out.println();
        System.out.printf("Norm of columns : %.3f", normMatrixColumns);

    }

}
