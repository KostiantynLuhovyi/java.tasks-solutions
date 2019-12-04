package com.lugowoy.tasks.solutions.core.productOfSquareMatrices;

import com.lugowoy.helper.utils.generating.GeneratorRandomNumber;

/**
 * Product of square matrices.
 * <p>
 * Created by Konstantin Lugowoy on 14.11.2017.
 */

public class Main {

    private static final int LENGTH_ARRAY = 5;
    private static final int MIN_BOUND = -10;
    private static final int MAX_BOUND = 10;

    public static void main(String[] args) {

        int[][] firstMatrix = new int[LENGTH_ARRAY][LENGTH_ARRAY];
        int[][] secondMatrix = new int[LENGTH_ARRAY][LENGTH_ARRAY];
        int[][] resultMatrix = new int[LENGTH_ARRAY][LENGTH_ARRAY];

        System.out.println("First matrix : ");
        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[i].length; j++) {
                firstMatrix[i][j] = GeneratorRandomNumber.generateInt(MIN_BOUND, MAX_BOUND);
                System.out.print(firstMatrix[i][j] + (j != LENGTH_ARRAY - 1 ? "\t" : "\n"));
            }
        }

        System.out.println("Second matrix : ");
        for (int i = 0; i < secondMatrix.length; i++) {
            for (int j = 0; j < secondMatrix[i].length; j++) {
                secondMatrix[i][j] = GeneratorRandomNumber.generateInt(MIN_BOUND, MAX_BOUND);
                System.out.print(secondMatrix[i][j] + (j != LENGTH_ARRAY - 1 ? "\t" : "\n"));
            }
        }

        System.out.println("Result : ");
        for (int i = 0; i < LENGTH_ARRAY; i++) {
            for (int j = 0; j < LENGTH_ARRAY; j++) {
                for (int k = 0; k < LENGTH_ARRAY; k++) {
                    resultMatrix[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                }
                System.out.print(resultMatrix[i][j] + (j != LENGTH_ARRAY - 1 ? "\t" : "\n"));
            }
        }

    }

}
