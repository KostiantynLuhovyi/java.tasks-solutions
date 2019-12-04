package com.lugowoy.tasks.solutions.core.determineWhetherPointBelongsToRectangle;

import com.lugowoy.helper.models.points.Point2D;

/**
 * Created by Konstantin Lugowoy on 14.09.2017.
 */

@FunctionalInterface
public interface Determinant {

    boolean determine(Point2D<Double> point, Point2D<Double> pointFirst, Point2D<Double> pointSecond);

    static boolean determineWhetherPointBelongsToRectangle(Point2D<Double> concretePoint,
                                                           Point2D<Double> pointUpperLeft,
                                                           Point2D<Double> pointLowerRight) {
        return (((concretePoint.getX() > pointUpperLeft.getX()) && (concretePoint.getX() < pointLowerRight.getX()))
                &&
                ((concretePoint.getY() < pointUpperLeft.getY()) && (concretePoint.getY() > pointLowerRight.getY())));
    }

}
