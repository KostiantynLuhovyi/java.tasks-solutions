package com.lugowoy.tasks.solutions.core.calculationOfPiNumberOnBasisOfFourierSeries;

/**
 * Calculation of the Pi number on the basis of the Fourier series.
 * <p>
 * Created by Konstantin Lugowoy on 11.11.2017.
 */

public class Main {

    private static final int NUMBER_OF_TERMS = 5_000_000;

    public static void main(String[] args) {

        double Pi = 0, q = 4;

        for (int i = 0; i <= NUMBER_OF_TERMS; i++) {
            Pi += q / (2 * i + 1);
            q *= (-1);
        }

        System.out.printf("Calculation of the value of %d the terms of the series.", NUMBER_OF_TERMS);
        System.out.println();
        System.out.println("Result : " + Pi);

    }

}
