package com.lugowoy.tasks.solutions.arrays.multidimensional.constructPascalTriangle;

import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import org.jetbrains.annotations.NotNull;
import java.util.Objects;

/**
 * Write a program that builds a Pascal triangle to a depth of 12. Each number
 * of a triangle is stored in an array of the appropriate length, and the array
 * of rows is stored in an array, the elements of which are 12 arrays of type
 * int.
 *
 * <p>Created by Konstantin Lugowoy on 28.06.2017.
 */
public class Main {

    private static final int LENGTH_PASCAL_TRIANGLE = 12;

    public static void main(String[] args) {

        int[][] pascalTriangle = new int[LENGTH_PASCAL_TRIANGLE][];

        new Executor().execute(() -> showPascalTriangle(pascalTriangle),
                               new OutputExecutionTimeToConsole());

    }

    private static void showPascalTriangle(@NotNull final int[][] matrix) {
        Objects.requireNonNull(matrix, "Matrix is null");
        matrix[0] = new int[1];
        matrix[1] = new int[2];
        matrix[1][0] = matrix[1][1] = 1;

        System.out.println(matrix[0][0] = 1);
        System.out.println(matrix[1][0] + " " + matrix[1][1]);

        for (int i = 2; i < matrix.length; i++) {
            matrix[i] = new int[i + 1];
            System.out.print((matrix[i][0] = 1) + " ");
            for (int j = 1; j < i; j++) {
                System.out.print((matrix[i][j] =
                                          matrix[i - 1][j - 1]
                                          + matrix[i - 1][j]) + " ");
            }
            System.out.println(matrix[i][i] = 1);
        }

    }

}
