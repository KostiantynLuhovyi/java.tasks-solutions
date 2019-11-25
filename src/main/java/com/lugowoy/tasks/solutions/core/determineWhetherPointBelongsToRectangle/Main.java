package com.lugowoy.tasks.determineWhetherPointBelongsToRectangle;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.points.Point2D;

/**
 * The user enters the coordinates of the upper left, and the lower right corner of the rectangle,
 * as well as the coordinates of the point (X, Y) in the Cartesian coordinate system. Does the point belong to this rectangle?
 * <p>
 * Created by Konstantin Lugowoy on 14.09.2017.
 */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    public static void main(String[] args) {

        System.out.println("Enter coordinates of point the upper left.");
        System.out.println("Coordinates x :");
        double xCoordinateUpperLeft = READER.readDouble();
        System.out.println("Coordinates y :");
        double yCoordinateUpperLeft = READER.readDouble();

        Point2D<Double> pointUpperLeft = new Point2D<>(xCoordinateUpperLeft, yCoordinateUpperLeft);

        System.out.println("Enter coordinates of point the lower right.");
        System.out.println("Coordinates x : ");
        double xCoordinateLowerRight = READER.readDouble();
        System.out.println("Coordinates y : ");
        double yCoordinateLowerRight = READER.readDouble();

        Point2D<Double> pointLowerRight = new Point2D<>(xCoordinateLowerRight, yCoordinateLowerRight);

        System.out.println("Enter the coordinates of the point to define.");
        System.out.println("Coordinates x :");
        double xCoordinatePoint = READER.readDouble();
        System.out.println("Coordinates y :");
        double yCoordinatePoint = READER.readDouble();

        Point2D<Double> point = new Point2D<>(xCoordinatePoint, yCoordinatePoint);

        Determinant determinant = Determinant::determineWhetherPointBelongsToRectangle;

        if (determinant.determine(point, pointUpperLeft, pointLowerRight)) {
            System.out.println("The entered point belongs to the rectangle.");
        } else {
            System.out.println("The entered point does not belong to the rectangle.");
        }

    }

}
