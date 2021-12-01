package com.lugowoy.tasks.solutions.arrays.onedimensional.determineNumberOfPairsOfPointsDistanceBetweenWhichIsMaximally;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.models.points.Point2D;
import com.lugowoy.helper.utils.Capacity;

/**
 * Created by Konstantin Lugowoy on 27.03.2017.
 */
@FunctionalInterface
public interface DeterminantPairsPoints<T extends Number> {

    Point2D<T>[] determine(Point2D<T>[] pointsArray);

    static Point2D<Double>[] determinePairsOfPoints(Point2D<Double>[] pointsArray) {
        CheckerArray.check(pointsArray, Capacity.UPPER.get());
        Point2D<Double>[] pairOfPoints = new Point2D[0];
        if (pointsArray.length > 2) {
            pairOfPoints = new Point2D[] {new Point2D<>(0.0, 0.0), new Point2D<>(0.0, 0.0)};
            CalculatorDistance calculatorDistance =
                    CalculatorDistance::calculateDistanceBetweenPoints;
            for (int i = 0; i < pointsArray.length - 1; i++) {
                for (int j = i + 1; j < pointsArray.length; j++) {
                    if (calculatorDistance.calculate(pairOfPoints[0], pairOfPoints[1])
                        < calculatorDistance.calculate(pointsArray[i], pointsArray[j])) {
                        pairOfPoints = new Point2D[] {pointsArray[i], pointsArray[j]};
                    }
                }
            }
        } else {
            System.err.println("Argument passed an array of points of incorrect size.");
        }
        return pairOfPoints;
    }

}
