package com.lugowoy.tasks.solutions.arrays.onedimensional.determineNumberOfPairsOfPointsDistanceBetweenWhichIsMaximally;

import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.models.points.Point2D;

import java.util.Arrays;

/**
 * The coordinates of n points on the plane are given: (X1, Y2), ..., (Xn, Yn)
 * (n ≤ 40). Find the number of pairs of points, the distance between which is
 * maximally (assume that such a pair is unique).
 *
 * <p>Created by Konstantin Lugowoy on 27.03.2017.
 */
public class Main {

    private static final DeterminantPairsPoints<Double> DETERMINANT =
            DeterminantPairsPoints::determinePairsOfPoints;

    private static final int NUMBER_OF_POINTS = 20;

    public static void main(String[] args) {

        Point2D<Double>[] pointsArray = new Point2D[NUMBER_OF_POINTS];

        fill(pointsArray);

        System.out.println("Original points array : ");
        Arrays.stream(pointsArray).forEachOrdered(System.out::println);

        new Executor().execute(() -> {
            Point2D<Double>[] resultPointArray = DETERMINANT.determine(pointsArray);

            System.out.println("Result pair of points : ");
            Arrays.stream(resultPointArray).forEachOrdered(System.out::println);
        }, new OutputExecutionTimeToConsole());

    }

    private static void fill(Point2D<Double>[] pointsArray) {
        for (int i = 0; i < pointsArray.length; i++) {
            pointsArray[i] = new Point2D<>((Math.random() * 40) + 1, (Math.random() * 40) + 1);
        }
    }

}
