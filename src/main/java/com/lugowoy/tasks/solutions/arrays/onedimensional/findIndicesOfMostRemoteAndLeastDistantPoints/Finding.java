package com.lugowoy.tasks.solutions.arrays.onedimensional.findIndicesOfMostRemoteAndLeastDistantPoints;

import com.lugowoy.helper.calculating.CalculationTwoParameters;
import com.lugowoy.helper.models.points.Point2D;
import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.utils.checking.CheckerArray;

/**
 * Created by Konstantin Lugowoy on 03.07.2017.
 */

@FunctionalInterface
public interface Finding<T> {

    CalculationTwoParameters<Double, Point2D<Double>, Point2D<Double>> CALCULATING = (kFirst, vSecond) ->
                                                                Math.sqrt((Math.pow(kFirst.getX() - vSecond.getX(), 2))
                                                                         + Math.pow(kFirst.getY() - vSecond.getY(), 2));

    void find(T t);

    static void findIndicesOfMaxDistanceBetweenPoints(Array<Point2D<Double>> pointArray) {
        int firstIndex = -1, secondIndex = -1;
        double tmpMax;
        if (CheckerArray.checkLengthInArray(pointArray)) {
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
            System.out.printf("Max distance between two points with index %d and %d is equal %f", firstIndex, secondIndex, distanceResult);
        }
    }

    static void findIndicesOfMinDistanceBetweenPoints(Array<Point2D<Double>> pointArray) {
        int firstIndex = -1, secondIndex = -1;
        double distanceResult = -1;
        if (CheckerArray.checkLengthInArray(pointArray)) {
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
            System.out.printf("Min distance between two points with index %d and %d is equal %f", firstIndex, secondIndex, distanceResult);
        }

    }

}
