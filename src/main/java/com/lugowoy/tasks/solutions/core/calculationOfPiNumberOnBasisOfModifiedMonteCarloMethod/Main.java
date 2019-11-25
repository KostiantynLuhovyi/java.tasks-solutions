package com.lugowoy.tasks.calculationOfPiNumberOnBasisOfModifiedMonteCarloMethod;

import com.lugowoy.helper.models.points.Point2D;

/**
 * Calculation of the Pi number on the basis of the modified Monte Carlo method.
 * <p>
 * Created by Konstantin Lugowoy on 11.11.2017.
 */

public class Main {

    private static final int NUMBER_OF_POINTS = 100000;

    public static void main(String[] args) {

        long countOfPoints = 0;

        for (int i = 0; i <= NUMBER_OF_POINTS; i++) {
            for (int j = 0; j <= NUMBER_OF_POINTS; j++) {
                Point2D<Double> point = new Point2D<>((double) i / NUMBER_OF_POINTS, (double) j / NUMBER_OF_POINTS);

                if (((point.getX() - 0.5) * (point.getX() - 0.5) + (point.getY() - 0.5) * (point.getY() - 0.5)) <= 0.25) {
                    countOfPoints++;
                }
            }
        }

        double Pi = (double) (4 * countOfPoints / (NUMBER_OF_POINTS + 1) / (NUMBER_OF_POINTS + 1));

        System.out.printf("Calculating a value by %d points", countOfPoints);
        System.out.println();
        System.out.println("Result : " + Pi);

    }

}
