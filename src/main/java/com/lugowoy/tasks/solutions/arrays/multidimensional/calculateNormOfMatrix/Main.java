package com.lugowoy.tasks.solutions.arrays.multidimensional.calculateNormOfMatrix;

import com.lugowoy.helper.models.matrices.MatrixDoubles;
import com.lugowoy.tasks.solutions.Helper;

import javax.swing.*;

import static com.lugowoy.helper.filling.ValuesToFilling.DOUBLE_LOWER_BOUND;
import static com.lugowoy.helper.filling.ValuesToFilling.DOUBLE_UPPER_BOUND;

/**
 * Calculate norm of the matrix.
 * <p> Created by Konstantin Lugowoy on 30.10.2018.
 */
public class Main {

    private static final String MSG_RESULT_ROWS_NORM = "Norm of rows : %.3f";
    private static final String MSG_RESULT_COLUMNS_NORM = "Norm of columns : %.3f";

    public static void main(String[] args) {

        int rows = Helper.enterMatrixRowCountToConsole();
        int columns = Helper.enterMatrixColumnCountToConsole();

        MatrixDoubles matrix = new MatrixDoubles(Helper.FILLING_MATRIX_DOUBLES.fill(rows, columns, DOUBLE_LOWER_BOUND, DOUBLE_UPPER_BOUND));

        System.out.println("Matrix : \n" + matrix);
        System.out.println();

        CalculatorMatrixNorms calculatorMatrixNorms = CalculatorMatrixNorms::calculateMatrixRowsNorm;
        double normMatrixRows = calculatorMatrixNorms.calculateMatrixNorm(matrix);

        calculatorMatrixNorms = CalculatorMatrixNorms::calculateMatrixColumnsNorm;
        double normMatrixColumns = calculatorMatrixNorms.calculateMatrixNorm(matrix);

        System.out.printf(MSG_RESULT_ROWS_NORM, normMatrixRows);
        System.out.println();
        System.out.printf(MSG_RESULT_COLUMNS_NORM, normMatrixColumns);

    }

}
