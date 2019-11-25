package com.lugowoy.tasks.determineWhetherLineIsParallelToOrdinateOrToAbscissa;

import com.lugowoy.helper.models.points.Point2D;

/**
 * Created by Konstantin Lugowoy on 28.09.2017.
 */

public class DeterminantOfLineParallelism {

    public static void determineWhetherLineIsParallelToOrdinateOrToAbscissa(Point2D<Integer> firstPoint,
                                                                            Point2D<Integer> secondPoint) {
        if (firstPoint.getX().intValue() == secondPoint.getX().intValue()
                && firstPoint.getY().intValue() != secondPoint.getY().intValue()) {
            System.out.println("The straight line passing the point along the coordinates entered is parallel to the y-axis.");
        } else if (firstPoint.getY().intValue() == secondPoint.getY().intValue()
                && firstPoint.getX().intValue() != secondPoint.getX().intValue()) {
            System.out.println("The straight line passing the point along the coordinates entered is parallel to the x-axis.");
        } else if (firstPoint.getX().intValue() == secondPoint.getX().intValue()
                && firstPoint.getY().intValue() == secondPoint.getY().intValue()) {
            System.out.println("");
        } else {
            System.out.println("The straight line passing through the entered coordinates is not parallel to the axes.");
        }
    }

}
