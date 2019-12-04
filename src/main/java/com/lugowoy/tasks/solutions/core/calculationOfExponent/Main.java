package com.lugowoy.tasks.solutions.core.calculationOfExponent;

/**
 * Calculation of the exponent.
 * <p>
 * Created by Konstantin Lugowoy on 10.11.2017.
 */

public class Main {

    private static final int BOUND = 1_000_000;

    public static void main(String[] args) {

        double x = 1, q = 1, s = 0;

        for (int i = 0; i <= BOUND; i++) {
            s += q;
            q *= x / (i + 1);
        }

        System.out.println("Exponent \"x\" : " + s);

    }

}
