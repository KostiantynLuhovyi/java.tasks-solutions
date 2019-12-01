package com.lugowoy.tasks.solutions.arrays.onedimensional.determineNumberOfPairsOfPointsDistanceBetweenWhichIsMaximally;

import com.lugowoy.helper.models.points.Point2D;

/**
 * Created by Konstantin Lugowoy on 27.03.2017.
 */

@FunctionalInterface
public interface Determinant {

    Point2D<Double>[] determine(Point2D<Double>[] pointsArray);

    static Point2D<Double>[] determineOfPairsOfPoints(Point2D<Double>[] pointsArray) {
        Point2D[] pairOfPoints = null;
        if (pointsArray.length > 2) {
            pairOfPoints = new Point2D[]{new Point2D(0.0, 0.0), new Point2D(0.0, 0.0)};
            Distancing distancing = Distancing::getDistanceOfPairOfThePoints;
            for (int i = 0; i < pointsArray.length - 1; i++) {
                for (int j = i + 1; j < pointsArray.length; j++) {
                    if (distancing.getDistance(pairOfPoints[0], pairOfPoints[1]) < distancing.getDistance(pointsArray[i], pointsArray[j])) {
                        pairOfPoints = new Point2D[]{pointsArray[i], pointsArray[j]};
                    }
                }
            }
        } else {
            System.err.println("Argument passed an array of points of incorrect size.");
        }
        return pairOfPoints;
    }

}
