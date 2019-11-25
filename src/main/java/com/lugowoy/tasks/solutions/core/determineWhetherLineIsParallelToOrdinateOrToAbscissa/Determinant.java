package com.lugowoy.tasks.determineWhetherLineIsParallelToOrdinateOrToAbscissa;

import com.lugowoy.helper.models.points.Point2D;

/**
 * Created by Konstantin Lugowoy on 28.09.2017.
 */

@FunctionalInterface
public interface Determinant {

    void determine(Point2D<Integer> firstPoint, Point2D<Integer> secondPoint);

}
