package com.lugowoy.tasks.solutions;

import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.filling.array.numbers.FillerArrayNumbers;
import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomPrimitiveDoubles;
import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.filling.array.points.FillerArrayPoints;
import com.lugowoy.helper.filling.array.strings.FillerArrayStrings;
import com.lugowoy.helper.filling.matrix.numbers.FillerMatrixNumbers;
import com.lugowoy.helper.filling.matrix.numbers.FillingMatrixRandomPrimitiveDoubles;
import com.lugowoy.helper.filling.matrix.numbers.FillingMatrixRandomPrimitiveIntegers;
import com.lugowoy.helper.models.points.Point2D;
import com.lugowoy.helper.utils.ReaderConsole;

import java.math.BigDecimal;

/**
 * <p>Created by Konstantin Lugowoy on 03.02.2020.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 */
public class Helper {

    public static final double DEFAULT_LOWER_BOUND = -10.0;
    public static final double ZERO = BigDecimal.ZERO.doubleValue();
    public static final double DEFAULT_UPPER_BOUND = 10.0;

    public static final String RESULT_MATRIX = "Result matrix : \n%s";
    public static final String RESULT_ARRAY = "Result array : \n%s";
    public static final String RESULT_SEQUENCE = "Result sequence : \n%s";

    public static final Executor EXECUTOR = new Executor();

    public static FillerArrayNumbers<Integer> fillerArrayIntegers;
    public static FillerArrayNumbers<Double> fillerArrayDoubles;

    public static FillerArrayStrings fillerArrayStrings;

    public static FillerArrayPoints<Point2D<Integer>, Integer>
            fillerArray2DPointsIntegers;
    public static FillerArrayPoints<Point2D<Double>, Double>
            fillerArray2DPointsDoubles;

    public static FillerMatrixNumbers<Integer> fillerMatrixIntegers;
    public static FillerMatrixNumbers<Double> fillerMatrixDoubles;

    public static final FillingArrayRandomPrimitiveIntegers FILLING_ARRAY_INTS =
            new FillingArrayRandomPrimitiveIntegers();
    public static final FillingArrayRandomPrimitiveDoubles
            FILLING_ARRAY_DOUBLES = new FillingArrayRandomPrimitiveDoubles();

    public static final FillingMatrixRandomPrimitiveIntegers
            FILLING_MATRIX_INTS = new FillingMatrixRandomPrimitiveIntegers();
    public static final FillingMatrixRandomPrimitiveDoubles
            FILLING_MATRIX_DOUBLES = new FillingMatrixRandomPrimitiveDoubles();

    public static int readMatrixRows() {
        System.out.println("Enter rows count of the matrix : ");
        return new ReaderConsole().readInt();
    }

    public static int readMatrixColumns() {
        System.out.println("Enter columns count of the matrix : ");
        return new ReaderConsole().readInt();
    }

}
