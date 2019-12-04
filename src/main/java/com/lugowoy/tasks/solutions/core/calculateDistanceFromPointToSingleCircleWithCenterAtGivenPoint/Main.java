package com.lugowoy.tasks.solutions.core.calculateDistanceFromPointToSingleCircleWithCenterAtGivenPoint;

import com.lugowoy.helper.calculating.CalculationTwoParameters;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.points.Point2D;

import java.util.Objects;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * Write a program that enters the coordinates M (x, y) and C (x, y) of points on the plane,
 * and prints the result of the distance from the point M (x, y) to the unit circle centered at point C (x, y).
 * <p>
 * Created by Konstantin Lugowoy on 10.07.2017.
 */

public class Main {

    private static final Reader READER = new Reader(new ReadingConsole());

    private static final String POINT_M = "M";
    private static final String POINT_C = "C";

    public static void main(String[] args) {

        Point2D<Double> pointM = getPoint(POINT_M);
        Point2D<Double> pointC = getPoint(POINT_C);

        System.out.println(pointM);
        System.out.println(pointC);
        System.out.println();

        double distance = CALCULATING.calculate(pointM, pointC);

        System.out.printf("If we assume that the point C(%.2f, %.2f) is the center of the unit circle, " +
                        "%n then the distance from the point M(%.2f, %.2f) to the unit circle is %.2f .",
                                                  pointC.getX(), pointC.getY(), pointM.getX(), pointM.getY(), distance);

    }

    private static final CalculationTwoParameters<Double, Point2D<Double>, Point2D<Double>> CALCULATING
            = (firstPoint, secondPoint) -> sqrt(pow(firstPoint.getX() - (secondPoint.getX() + 1.0), 2))
                                                + pow(firstPoint.getY() - (secondPoint.getY() + 1.0), 2);

    private static Point2D<Double> getPoint(String pointName) {
        Point2D<Double> point = new Point2D<>(0d, 0d);
        enterCoordinatesOfPoint(pointName, point);
        return point;
    }

    private static void enterCoordinatesOfPoint(String pointName, Point2D<Double> point) {
        if (Objects.nonNull(point)) {
            System.out.println("Enter coordinates for the points " + pointName + " .");
            System.out.println("x : ");
            point.setX(READER.readDouble());
            System.out.println("y : ");
            point.setY(READER.readDouble());
        } else {
            throw new NullPointerException("The argument point is null");
        }
    }

}
