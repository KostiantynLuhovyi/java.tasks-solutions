package com.lugowoy.tasks.calculateDistanceBetweenMostDistantPointsOnLine;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by Konstantin Lugowoy on 10.07.2017.
 */

@FunctionalInterface
public interface Determinant<T extends Number> {

    T determine(Line<T> line);

    static Double determineMinValueOfPointOnLine(Line<Double> line) {
        Optional<Double> optionalMinValueOfPoint = Arrays.stream(line.getPointsOnLine()).min(Double::compareTo);
        double resultValue = 0;
        if (optionalMinValueOfPoint.isPresent()) {
            resultValue = optionalMinValueOfPoint.get();
        } else {
            throw new ArithmeticException("Can not determine the minimal value of point on the line.");
        }
        return resultValue;
    }

    static Double determineMaxValueOfPointOnLine(Line<Double> line) {
        Optional<Double> optionalMaxValueOfPoint = Arrays.stream(line.getPointsOnLine()).max(Double::compareTo);
        double resultValue = 0;
        if (optionalMaxValueOfPoint.isPresent()) {
            resultValue = optionalMaxValueOfPoint.get();
        } else {
            throw new ArithmeticException("Can not determine the maximum value of point on the line.");
        }
        return resultValue;
    }

}
