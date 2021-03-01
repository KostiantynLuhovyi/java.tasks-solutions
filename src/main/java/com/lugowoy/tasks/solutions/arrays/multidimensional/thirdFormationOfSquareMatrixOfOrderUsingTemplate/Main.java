package com.lugowoy.tasks.solutions.arrays.multidimensional.thirdFormationOfSquareMatrixOfOrderUsingTemplate;

import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.utils.ReaderConsole;

import java.math.BigDecimal;

/**
 * Form a square matrix of order n according to a given pattern:
 * n	0	0	…	0	0	0
 * 0	n-1	0	…	0	0	0
 * 0	0	n-2	…	0	0	0
 * …	…	…	…	…	…	…
 * 0	0	0	…	0	2	0
 * 0	0	0	…	0	0	1
 *
 * <p>Created by Konstantin Lugowoy on 16.10.2017.
 */

public class Main {

    private static final int UPPER_BOUND = 50;

    public static void main(String[] args) {

        System.out.println("Enter the length of the matrix rows and columns: ");
        ReaderConsole reader = new ReaderConsole();
        int n = reader.readInt(BigDecimal.ZERO.intValue(), UPPER_BOUND);

        int[][] matrix = new int[n][n];
        int numIndex = 0, num = n;
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][numIndex] = num;
            numIndex++;
            num--;
        }

        System.out.println("Matrix : \n" + matrix + "\n");

        new Executor().execute(() -> {
            System.out.println("Result matrix : ");
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }, new OutputExecutionTimeToConsole());

    }

}
