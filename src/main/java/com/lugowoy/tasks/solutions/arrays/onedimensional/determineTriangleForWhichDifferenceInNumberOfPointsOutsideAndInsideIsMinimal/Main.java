package com.lugowoy.tasks.solutions.arrays.onedimensional.determineTriangleForWhichDifferenceInNumberOfPointsOutsideAndInsideIsMinimal;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomDoubles;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.points.Point2D;
import com.lugowoy.helper.models.storages.arrays.Array;

/**
 * In a one-dimensional array with an even number of elements (2N) there are coordinates of N points of the plane.
 * They are arranged in the following order: x1, y1, x2, y2, x3, y3, etc.
 * Identify three points that are the vertices of a triangle for which the difference in the number of points outside it and inside is minimal.
 *
 * <p> Created by Konstantin Lugowoy on 03.07.2017.
 */

public class Main {

    private static final Reader READER = new Reader(new ReadingConsole());

    private static final Determinant<Array<Point2D<Double>>> DETERMINANT = Determinant::defineTriangle;

    private static final double START_BOUND = -50d;
    private static final double END_BOUND = 50d;

    public static void main(String[] args) {

        int lengthArray = enterLengthOfArray();

        Array<Double> array = new Array<>(new FillingArrayRandomDoubles().fill(lengthArray, START_BOUND, END_BOUND));

        System.out.println("Coordinates : ");
        System.out.println(array);
        System.out.println();

        Array<Point2D<Double>> pointArray = createAndFillArrayOfPoints(array);

        System.out.println("Points : ");
        System.out.println(pointArray);
        System.out.println();

        Array<Point2D<Double>> resultPointArray = DETERMINANT.define(pointArray);

        System.out.println("Result points of triangle : " + resultPointArray);

    }

    private static int enterLengthOfArray() {
        System.out.println("Enter the size of the array : ");
        int sizeArray;
        while (true) {
            sizeArray = READER.readInt();
            if (sizeArray % 2 == 0) {
                break;
            } else {
                System.out.println("Number of the size array must be a even number. Re-enter : ");
            }
        }
        return sizeArray;
    }

    private static Point2D<Double> fillPointCoordinates(double coordinateX, double coordinateY) {
        return new Point2D<>(coordinateX, coordinateY);
    }


    private static Array<Point2D<Double>> createAndFillArrayOfPoints(Array<Double> arrayOfCoordinates) {
        Array<Point2D<Double>> pointArray = new Array<>(0);
        int countForCreate = 0;
        for (int i = 0; i < arrayOfCoordinates.size(); i++) {
            if (countForCreate == 1) {
                pointArray.add(fillPointCoordinates(arrayOfCoordinates.get(i - 1), arrayOfCoordinates.get(i)));
                countForCreate--;
            } else {
                countForCreate++;
            }
        }
        return pointArray;
    }

}
