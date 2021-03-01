package com.lugowoy.tasks.solutions.arrays.multidimensional.secondFormationOfSquareMatrixOfOrderUsingTemplate;

import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.utils.ReaderConsole;

/**
 * Form a square matrix of order n according to a given pattern:
 * 0	0	0	…	0	0	1
 * 0	0	0	…	0	2	0
 * 0	0	0	…	3	0	0
 * …	…	…	…	…	…	…
 * 0	n-1	0	…	0	0	0
 * n	0	0	…	0	0	0
 *
 * <p>Created by Konstantin Lugowoy on 16.10.2017.
 */
public class Main {

    private static final int UPPER_BOUND = 50;

    public static void main(String[] args) {

        System.out.println("Enter the length of the matrix elements : ");
        int n = new ReaderConsole().readInt(0, UPPER_BOUND);

        int[][] array = new int[n][n];

        new Executor().execute(() -> {
            int indexNum = array.length - 1, num = 1;
            for (int i = 0; i < array.length; i++) {
                array[i][indexNum] = num;
                num++;
                indexNum--;
            }

            System.out.println("Result matrix  : \n");
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    System.out.print(array[i][j] + " ");
                }
                System.out.println();
            }
        }, new OutputExecutionTimeToConsole());

    }

}
