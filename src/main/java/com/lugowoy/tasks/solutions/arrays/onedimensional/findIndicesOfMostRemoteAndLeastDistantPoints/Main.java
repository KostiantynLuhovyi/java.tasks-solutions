package com.lugowoy.tasks.solutions.arrays.onedimensional.findIndicesOfMostRemoteAndLeastDistantPoints;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegers;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.models.points.Point2D;
import com.lugowoy.helper.utils.Capacity;
import com.lugowoy.helper.utils.HelperArrayFiller;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.RandomNumber;
import com.lugowoy.helper.utils.ReaderArrayLength;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * In a one-dimensional array with an even number of elements (2N) there are coordinates of N points of the plane.
 * They are arranged in the following order: x1, y1, x2, y2, x3, y3, etc.
 * Find the numbers of the most distant points and the points that are the least distant from each other.
 *
 * <p>Created by Konstantin Lugowoy on 03.07.2017.
 */
public class Main {

    public static void main(String[] args) {

        int lengthArray = readEvenLengthArray();

        HelperArrayFiller fillerArray = new HelperArrayFiller();

        Array<Integer> integerArray = new Array<>(fillerArray.getArray(
                new FillingArrayRandomIntegers(), lengthArray,
                HelperFillerValues.INT_NEGATIVE_HUNDRED,
                HelperFillerValues.INT_POSITIVE_HUNDRED));

        Array<Point2D<Double>> pointsArray = new Array<>();

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

    private static void fillArrayPoints(@NotNull final Array<Point2D<Double>> pointArray) {
        CheckerArray.check(pointArray, Capacity.UPPER.get());
        RandomNumber randomNumber = new RandomNumber();
        for (int i = 0; i < pointArray.size(); i++) {
            double coordinateX = randomNumber.generateDouble(HelperFillerValues.DOUBLE_POSITIVE_THOUSAND);
            double coordinateY = randomNumber.generateDouble(HelperFillerValues.DOUBLE_POSITIVE_THOUSAND);
            pointArray.set(i, new Point2D<>(coordinateX, coordinateY));
        }

    }

    private static int readEvenLengthArray() {
        ReaderArrayLength readerLength = new ReaderArrayLength();
        int resultEvenLength = 0;
        while (true) {
            resultEvenLength = readerLength.read(System.in, System.out,
                                                 "Enter even number length of the array : ");
            if (resultEvenLength > 0 && ((resultEvenLength % 2) == 0)) {
                break;
            } else {
                System.out.println("Incorrect length. Repeat:");
            }
        }
        return resultEvenLength;
    }

}
