package com.lugowoy.tasks.solutions.arrays.onedimensional.findIndicesOfMostRemoteAndLeastDistantPoints;

import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.points.Point2D;
import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.utils.checking.CheckerArray;
import com.lugowoy.helper.utils.generating.GeneratorRandomNumber;

import java.util.Arrays;

/**
 * In a one-dimensional array with an even number of elements (2N) there are coordinates of N points of the plane.
 * They are arranged in the following order: x1, y1, x2, y2, x3, y3, etc.
 * Find the numbers of the most distant points and the points that are the least distant from each other.
 *
 * <p> Created by Konstantin Lugowoy on 03.07.2017.
 */

public class Main {

    public static void main(String[] args) {

        int numberPointOfPlane = getNumberQuantityPointsOfPlane();

        Array<Point2D<Double>> pointsArray = new Array<>(numberPointOfPlane);

        fillArrayPoints(pointsArray);

        System.out.println("Points : ");
        Arrays.stream(pointsArray.toArray()).forEachOrdered(System.out::println);
        System.out.println();

        Finding<Array<Point2D<Double>>> finding = Finding::findIndicesOfMaxDistanceBetweenPoints;
        finding.find(pointsArray);

        System.out.println();

        finding = Finding::findIndicesOfMinDistanceBetweenPoints;
        finding.find(pointsArray);

    }

    private static int getNumberQuantityPointsOfPlane() {
        System.out.println("Enter the number points of the plane : ");
        ReadingConsole reader = new ReadingConsole();
        int numberQuantityPointOfPlane;
        while (true) {
            numberQuantityPointOfPlane = reader.readInt();
            if ((numberQuantityPointOfPlane > 0) && (numberQuantityPointOfPlane % 2 == 0)) {
                break;
            } else {
                System.out.println("The number points of the plane a must be positive and even number.");
                System.out.println("Re-enter : ");
            }
        }
        return numberQuantityPointOfPlane;
    }

    private static void fillArrayPoints(Array<Point2D<Double>> pointArray) {
        if (CheckerArray.checkLengthInArray(pointArray)) {
            for (int i = 0; i < pointArray.size(); i++) {
                double coordinateX = GeneratorRandomNumber.generateDouble();
                double coordinateY = GeneratorRandomNumber.generateDouble();
                pointArray.set(i, new Point2D<>(coordinateX, coordinateY));
            }
        }
    }

}
