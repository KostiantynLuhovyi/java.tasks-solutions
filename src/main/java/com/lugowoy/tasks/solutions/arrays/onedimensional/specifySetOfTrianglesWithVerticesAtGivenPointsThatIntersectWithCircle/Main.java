package com.lugowoy.tasks.solutions.arrays.onedimensional.specifySetOfTrianglesWithVerticesAtGivenPointsThatIntersectWithCircle;

import com.lugowoy.helper.filling.array.points.FillingArrayPoints2DReadIntegers;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.points.Point2D;
import com.lugowoy.helper.models.storages.arrays.Array;

import java.util.Arrays;

/**
 * On the n-plane the points are given by their coordinates and a circle of radius R with center at the origin is also given.
 * Specify the set of all triangles with vertices at given points intersecting a circle;
 * The set of all triangles contained inside the circle.
 *
 * <p> Created by Konstantin Lugowoy on 02.07.2017.
 */

public class Main {

    private static final Reader READER = new Reader(new ReadingConsole());

    public static void main(String[] args) {

        int numberOfPoints = enterNumberOfPoints();

        Array<Point2D<Integer>> pointsArray = new Array<>(new FillingArrayPoints2DReadIntegers(READER).fill(numberOfPoints));

        System.out.println();
        System.out.println("Points : ");
        Arrays.stream(pointsArray.toArray()).forEachOrdered(System.out::println);
        System.out.println();

        double radius = enterRadius();

        System.out.println();
        System.out.println("Result : ");
        TrigonometricDeterminant<Array<Point2D<Integer>>, Double> trigonometricDeterminant =
                TrigonometricDeterminant::determineSetOfTrianglesWithVerticesAtGivenPointsThatIntersectWithCircle;
        trigonometricDeterminant.determine(pointsArray, radius);

    }

    private static int enterNumberOfPoints() {
        System.out.println("Enter number of points : ");
        int numberOfPoints;
        while (true) {
            numberOfPoints = READER.readInt();
            if (numberOfPoints > 0) {
                break;
            } else {
                System.out.println("Incorrect enter data. Re-enter a positive number : ");
            }
        }
        return numberOfPoints;
    }

    private static double enterRadius() {
        System.out.println("Enter the radius of the circle : ");
        double radius;
        while (true) {
            radius = READER.readInt();
            if (radius > 50) {
                break;
            } else {
                System.out.println("The radius of the circle must be greater than 50.");
                System.out.println("Re-enter : ");
            }
        }
        return radius;
    }

}
