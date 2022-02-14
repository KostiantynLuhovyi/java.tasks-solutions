package com.lugowoy.tasks.solutions.arrays.onedimensional.findIndicesOfMostRemoteAndLeastDistantPoints;

import com.lugowoy.helper.calculations.CalculationByTwoParameters;
import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.models.points.Point2D;
import com.lugowoy.helper.utils.Capacity;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Konstantin Lugowoy on 03.07.2017.
 */
@FunctionalInterface
public interface Finding<T> {

    CalculationByTwoParameters<Double, Point2D<Double>, Point2D<Double>>
            CALCULATING = (kFirst, vSecond) -> Math.sqrt((Math.pow(kFirst.getX() - vSecond.getX(), 2))
                                                         + Math.pow(kFirst.getY() - vSecond.getY(), 2));

    void find(T t);

    static void findIndicesOfMaxDistanceBetweenPoints(
            @NotNull final Array<Point2D<Double>> pointArray) {
        CheckerArray.check(pointArray, Capacity.UPPER.get());
        int firstIndex = -1, secondIndex = -1;
        double tmpMax;
        double distanceResult = CALCULATING.calculate(pointArray.get(0), pointArray.get(1));
        for (int i = 1; i < pointArray.size() - 1; i++) {
            for (int j = i + 1; j < pointArray.size(); j++) {
                tmpMax = CALCULATING.calculate(pointArray.get(i), pointArray.get(j));
                if (tmpMax > distanceResult) {
                    distanceResult = tmpMax;
                    firstIndex = i;
                    secondIndex = j;
                }
            }
        }
        System.out.printf("Max distance between two points with index %d and %d is equal %f",
                          firstIndex, secondIndex, distanceResult);
    }

    static void findIndicesOfMinDistanceBetweenPoints(
            @NotNull final Array<Point2D<Double>> pointArray) {
        CheckerArray.check(pointArray, Capacity.UPPER.get());
        int firstIndex = -1, secondIndex = -1;
        double distanceResult = -1;
        double tmpMin = CALCULATING.calculate(pointArray.get(0), pointArray.get(1));
        for (int i = 1; i < pointArray.size() - 1; i++) {
            for (int j = i + 1; j < pointArray.size(); j++) {
                distanceResult = CALCULATING.calculate(pointArray.get(i), pointArray.get(j));
                if (distanceResult < tmpMin) {
                    tmpMin = distanceResult;
                    firstIndex = i;
                    secondIndex = j;
                }
            }
        }
        System.out.printf("Min distance between two points with index %d and %d is equal %f",
                          firstIndex, secondIndex, distanceResult);
    }

}
