package com.lugowoy.tasks.solutions.core.calculateDistanceFromPointToStraightLineInPlane;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.points.Point2D;

import java.util.Objects;

/**
 * Write a program that inputs the real coordinates (x, y) and (a, b) of two points onto a plane,
 * and calculate the distance from the point M (x, y) to the straight line OA,
 * where O is the start origin of coordinates, and the point A is different from 0.
 * <p>
 * Created by Konstantin Lugowoy on 11.07.2017.
 */

public class Main {

    private static final Reader READER = new Reader(new ReadingConsole());

    private static final String POINT_M = "M";
    private static final String POINT_A = "A";

    public static void main(String[] args) {

        Point2D<Double> pointM = getPoint(POINT_M);
        Point2D<Double> pointA = getPoint(POINT_A);

        Point2D<Double> pointO = new Point2D<>(0d, 0d);

        if (isDifferent(pointO, pointA)) {
            System.out.printf("Distance from point M(%.2f, %.2f) to line OA is equal : %.2f .",
                                      pointM.getX(), pointM.getY(), getDistanceFromPointToLine(pointM, pointA, pointO));
        } else {
            System.err.println("The coordinates of point O are equal to the coordinates of point A. " +
                                                                       "For this reason, calculations are impossible.");
        }

    }

    private static boolean isDifferent(Point2D<Double> firstPoint, Point2D<Double> secondPoint) {
        return !(firstPoint.getX().equals(secondPoint.getX()) && firstPoint.getY().equals(secondPoint.getY()));
    }

    private static double getDistanceFromPointToLine(Point2D<Double> pointM,
                                                     Point2D<Double> pointA,
                                                     Point2D<Double> pointO) {
        double distanceFromPointToLine, A, B, C;
        A = pointA.getY() - pointO.getY();
        B = pointA.getX() - pointO.getX();
        C = pointA.getY() * pointO.getX() - pointO.getY() * pointA.getX();

        distanceFromPointToLine = (A * pointM.getX() + B * pointM.getY() + C) / Math.sqrt(A * A + B * B);

        return distanceFromPointToLine;
    }

    private static Point2D<Double> getPoint(String pointName) {
        Point2D<Double> point = new Point2D<>(0d, 0d);
        enterCoordinatesOfPoint(pointName, point);
        return point;
    }

    private static void enterCoordinatesOfPoint(String pointName, Point2D<Double> point) {
        System.out.println("Enter coordinates for point " + pointName + " : ");
        if (Objects.nonNull(point)) {
            System.out.println("x : ");
            point.setX(READER.readDouble());
            System.out.println("y : ");
            point.setY(READER.readDouble());
        } else {
            throw new NullPointerException("The object of Point class passed by argument is equal to null.");
        }
    }

}
