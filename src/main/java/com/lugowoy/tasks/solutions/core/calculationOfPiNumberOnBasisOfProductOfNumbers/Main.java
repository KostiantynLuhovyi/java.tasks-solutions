package com.lugowoy.tasks.calculationOfPiNumberOnBasisOfProductOfNumbers;

/**
 * Calculating the number Pi on the basis of the product of numbers.
 * <p>
 * Created by Konstantin Lugowoy on 11.11.2017.
 */

public class Main {

    private static final int NUMBER_OF_FACTORS = 20;

    public static void main(String[] args) {

        double Pi = 2, q = Math.sqrt(2);

        for (int i = 0; i <= NUMBER_OF_FACTORS; i++) {
            Pi *= 2 / q;
            q = Math.sqrt(2 + q);
        }

        System.out.printf("Calculating the value by %d multipliers.", NUMBER_OF_FACTORS);
        System.out.println();
        System.out.println("Result : " + Pi);

    }

}
