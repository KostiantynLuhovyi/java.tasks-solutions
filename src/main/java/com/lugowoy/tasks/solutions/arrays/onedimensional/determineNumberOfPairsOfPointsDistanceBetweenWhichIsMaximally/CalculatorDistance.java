package com.lugowoy.tasks.solutions.arrays.onedimensional.determineNumberOfPairsOfPointsDistanceBetweenWhichIsMaximally;

import com.lugowoy.helper.models.points.Point2D;

/**
 * Created by Konstantin Lugowoy on 27.03.2017.
 */
@FunctionalInterface
public interface CalculatorDistance {

    double calculate(Point2D<Double> thisPoint, Point2D<Double> thatPoint);

    static double calculateDistanceBetweenPoints(Point2D<Double> thisPoint,
                                                 Point2D<Double> thatPoint) {
        return Math.hypot(thisPoint.getX() - thatPoint.getX(),
                          thisPoint.getY() - thatPoint.getY());
    }

}
