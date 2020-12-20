package com.lugowoy.tasks.solutions.helper;

import com.lugowoy.helper.filling.array.numbers.FillerArrayNumbers;
import com.lugowoy.helper.filling.array.numbers.FillingArrayNumbers;
import com.lugowoy.helper.filling.array.numbers.primitives.FillerArrayDoublePrimitives;
import com.lugowoy.helper.filling.array.numbers.primitives.FillerArrayIntegerPrimitives;
import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayDoublePrimitives;
import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayIntegerPrimitives;
import com.lugowoy.helper.filling.array.points.FillerArrayPoints;
import com.lugowoy.helper.filling.array.points.FillingArrayPoints;
import com.lugowoy.helper.filling.array.strings.FillerArrayStrings;
import com.lugowoy.helper.filling.array.strings.FillingArrayStrings;
import com.lugowoy.helper.filling.matrix.numbers.FillerMatrixNumbers;
import com.lugowoy.helper.filling.matrix.numbers.FillingMatrixNumbers;
import com.lugowoy.helper.filling.matrix.numbers.primitives.FillerMatrixDoublePrimitives;
import com.lugowoy.helper.filling.matrix.numbers.primitives.FillerMatrixIntegerPrimitives;
import com.lugowoy.helper.filling.matrix.numbers.primitives.FillingMatrixDoublePrimitives;
import com.lugowoy.helper.filling.matrix.numbers.primitives.FillingMatrixIntegerPrimitives;
import com.lugowoy.helper.models.points.Point2D;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * <p>Created by Konstantin Lugowoy on 14.12.2020.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 */
//TODO write documentation
public class HelperFiller {

    public static final int INT_ZERO = 0;
    public static final int INT_NEGATIVE_ONE = -1;
    public static final int INT_POSITIVE_ONE = 1;
    public static final int INT_NEGATIVE_TEN = -10;
    public static final int INT_POSITIVE_TEN = 10;
    public static final int INT_NEGATIVE_HUNDRED = -100;
    public static final int INT_POSITIVE_HUNDRED = 100;
    public static final int INT_NEGATIVE_THOUSAND = -1000;
    public static final int INT_POSITIVE_THOUSAND = 1000;

    public static final double DOUBLE_ZERO = 0.0;
    public static final double DOUBLE_NEGATIVE_ONE = -1;
    public static final double DOUBLE_POSITIVE_ONE = 1;
    public static final double DOUBLE_NEGATIVE_TEN = -10.0;
    public static final double DOUBLE_POSITIVE_TEN = 10;
    public static final double DOUBLE_NEGATIVE_HUNDRED = -100.0;
    public static final double DOUBLE_POSITIVE_HUNDRED = 100.0;
    public static final double DOUBLE_NEGATIVE_THOUSAND = -1000.0;
    public static final double DOUBLE_POSITIVE_THOUSAND = 1000.0;

    public int[] getArray(@NotNull final FillingArrayIntegerPrimitives filling,
                          final int lengthArray, final int lowerBound,
                          final int upperBound) {
        Objects.requireNonNull(filling, "Filling is null");
        return new FillerArrayIntegerPrimitives(filling).fill(lengthArray,
                                                              lowerBound,
                                                              upperBound);
    }

    public double[] getArray(
            @NotNull final FillingArrayDoublePrimitives filling,
            final int lengthArray, final double lowerBound,
            final double upperBound) {
        Objects.requireNonNull(filling, "Filling is null");
        return new FillerArrayDoublePrimitives(filling).fill(lengthArray,
                                                             lowerBound,
                                                             upperBound);
    }

    public Integer[] getArray(
            @NotNull final FillingArrayNumbers<Integer> filling,
            final int lengthArray, @NotNull final Integer lowerBound,
            @NotNull final Integer upperBound) {
        Objects.requireNonNull(filling, "Filling is null");
        return new FillerArrayNumbers<>(filling).fill(lengthArray, lowerBound,
                                                      upperBound);
    }

    public Double[] getArray(@NotNull final FillingArrayNumbers<Double> filling,
                             final int lengthArray,
                             @NotNull final Double lowerBound,
                             @NotNull final Double upperBound) {
        Objects.requireNonNull(filling, "Filling is null");
        return new FillerArrayNumbers<>(filling).fill(lengthArray, lowerBound,
                                                      upperBound);
    }

    public String[] getArray(@NotNull final FillingArrayStrings filling,
                             final Integer lengthArray,
                             @NotNull final Integer lowerBound,
                             @NotNull final Integer upperBound) {
        Objects.requireNonNull(filling, "Filling is null");
        return new FillerArrayStrings(filling).fill(lengthArray, lowerBound,
                                                    upperBound);
    }

    public Point2D<Integer>[] getArray(@NotNull
                                       final FillingArrayPoints<Point2D<Integer>, Integer> filling,
                                       final int lengthArray,
                                       @NotNull final Integer lowerBound,
                                       @NotNull final Integer upperBound) {
        Objects.requireNonNull(filling, "Filling is null");
        return new FillerArrayPoints<>(filling).fill(lengthArray, lowerBound,
                                                     upperBound);
    }

    public Point2D<Double>[] getArray(
            @NotNull final FillingArrayPoints<Point2D<Double>, Double> filling,
            final int lengthArray, @NotNull final Double lowerBound,
            @NotNull final Double upperBound) {
        Objects.requireNonNull(filling, "Filling is null");
        return new FillerArrayPoints<>(filling).fill(lengthArray, lowerBound,
                                                     upperBound);
    }

    public Integer[][] getArray(
            @NotNull final FillingMatrixNumbers<Integer> filling,
            final int rows, final int columns,
            @NotNull final Integer lowerBound,
            @NotNull final Integer upperBound) {
        Objects.requireNonNull(filling, "Filling is null");
        return new FillerMatrixNumbers<>(filling).fill(rows, columns,
                                                       lowerBound, upperBound);
    }

    public Double[][] getArray(
            @NotNull final FillingMatrixNumbers<Double> filling, final int rows,
            final int columns, @NotNull final Double lowerBound,
            @NotNull final Double upperBound) {
        Objects.requireNonNull(filling, "Filling is null");
        return new FillerMatrixNumbers<>(filling).fill(rows, columns,
                                                       lowerBound, upperBound);
    }

    public int[][] getArray(
            @NotNull final FillingMatrixIntegerPrimitives filling,
            final int rows, final int columns,
            @NotNull final Integer lowerBound,
            @NotNull final Integer upperBound) {
        Objects.requireNonNull(filling, "Filling is null");
        return new FillerMatrixIntegerPrimitives(filling).fill(rows, columns,
                                                               lowerBound,
                                                               upperBound);
    }

    public double[][] getArray(
            @NotNull final FillingMatrixDoublePrimitives filling,
            final int rows, final int columns, @NotNull final Double lowerBound,
            @NotNull final Double upperBound) {
        Objects.requireNonNull(filling, "Filling is null");
        return new FillerMatrixDoublePrimitives(filling).fill(rows, columns,
                                                              lowerBound,
                                                              upperBound);
    }

}
