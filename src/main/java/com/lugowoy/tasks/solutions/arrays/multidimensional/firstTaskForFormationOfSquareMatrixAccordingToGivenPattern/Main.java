package com.lugowoy.tasks.solutions.arrays.multidimensional.firstTaskForFormationOfSquareMatrixAccordingToGivenPattern;

import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.helper.utils.ReaderConsole;
import com.lugowoy.tasks.solutions.helper.Helper;

/**
 * Form a square matrix of order n according to a given pattern:
 *  1   2   3   …  n
 *  n  n-1 n-2  …  1
 *  1   2   3   …  n
 *  n  n-1 n-2  …  1
 *  …   …   …   …  …
 *  n  n-1 n-2  …  1
 *      (n – even number).
 *
 * <p>Created by Konstantin Lugowoy on 15.10.2017.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Enter the length of the matrix elements : ");
        ReaderConsole reader = new ReaderConsole();
        int n = reader.readInt();

        Helper.EXECUTOR.execute(() -> {
            System.out.println("Result matrix by pattern : \n"
                               + createMatrixByPattern(n));
        }, new OutputExecutionTimeToConsole());

    }

    private static MatrixInts createMatrixByPattern(final int n) {
        int[][] array = new int[n][n];
        int k = 1, num = n;
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < array.length; j++) {
                    array[i][j] = k;
                    k++;
                }
                k = 1;
            } else {
                for (int j = 0; j < array.length; j++) {
                    array[i][j] = num;
                    num--;
                }
                num = n;
            }
        }
        return new MatrixInts(array);
    }

}
