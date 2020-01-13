package com.lugowoy.tasks.solutions.arrays.onedimensional.determineTriangleForWhichDifferenceInNumberOfPointsOutsideAndInsideIsMinimal;

import com.lugowoy.helper.calculating.CalculationThreeParameters;
import com.lugowoy.helper.models.points.Point2D;

/**
 * Created by Konstantin Lugowoy on 08.07.2017.
 */
@FunctionalInterface
public interface CheckInsidePoint {

    CalculationThreeParameters<Double, Point2D<Double>, Point2D<Double>, Point2D<Double>> CALCULATION = (kFirst, vSecond, zThird) -> {
        double tmpResFirst = Math.hypot(kFirst.getX() - vSecond.getX(),
                                        kFirst.getY() - vSecond.getY());
        double tmpResSecond = Math.hypot(vSecond.getX() - zThird.getX(),
                                         vSecond.getY() - zThird.getY());
        double tmpResThird = Math.hypot(zThird.getX() - kFirst.getX(),
                                        zThird.getY() - kFirst.getY());

        double tmp = (tmpResFirst + tmpResSecond + tmpResThird) / 2;

        return Math.sqrt(tmp * (tmp - tmpResFirst) * (tmp - tmpResSecond) * (tmp - tmpResThird));
    };

    int isInside(Point2D<Double> pointToCheck, Point2D<Double> firstPoint, Point2D<Double> secondPoint, Point2D<Double> thirdPoint);

    static int isInsideTrianglePoints(Point2D<Double> pointToCheck, Point2D<Double> firstPoint,
                                      Point2D<Double> secondPoint, Point2D<Double> thirdPoint) {
        double areaTriangle = CALCULATION.calculate(firstPoint, secondPoint, thirdPoint);

        double firstAreaToCheck = CALCULATION.calculate(pointToCheck, firstPoint, secondPoint);
        double secondAreaToCheck = CALCULATION.calculate(pointToCheck, secondPoint, thirdPoint);
        double thirdAreaToCheck = CALCULATION.calculate(pointToCheck, thirdPoint, firstPoint);

        if (firstAreaToCheck == 0 || secondAreaToCheck == 0 || thirdAreaToCheck == 0)
            return 0;

        return areaTriangle == firstAreaToCheck + secondAreaToCheck + thirdAreaToCheck ? 1 : -1;
    }

}
