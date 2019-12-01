package com.lugowoy.tasks.solutions.arrays.onedimensional.determineNumberOfPairsOfPointsDistanceBetweenWhichIsMaximally;

import com.lugowoy.helper.models.points.Point2D;

/**
 * Created by Konstantin Lugowoy on 27.03.2017.
 */

@FunctionalInterface
public interface Distancing {

    double getDistance(Point2D<Double> thisPoint, Point2D<Double> thatPoint);

    static double getDistanceOfPairOfThePoints(Point2D<Double> thisPoint, Point2D<Double> thatPoint) {
        return Math.hypot(thisPoint.getX() - thatPoint.getX(), thisPoint.getY() - thatPoint.getY());
    }

}
