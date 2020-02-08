package com.lugowoy.tasks.solutions;

import com.lugowoy.helper.filling.array.numbers.FillerArrayNumbers;
import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomPrimitiveDoubles;
import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.filling.array.points.FillerArrayPoints;
import com.lugowoy.helper.filling.array.strings.FillerArrayStrings;
import com.lugowoy.helper.filling.matrix.numbers.FillerMatrixNumbers;
import com.lugowoy.helper.filling.matrix.numbers.FillingMatrixRandomPrimitiveDoubles;
import com.lugowoy.helper.filling.matrix.numbers.FillingMatrixRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.points.Point2D;
import com.lugowoy.helper.models.points.Point3D;
import com.lugowoy.helper.utils.ArrayLengthReader;

/**
 * Created by Konstantin Lugowoy on 03.02.2020.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 */
public class Helper {

    public static final String RESULT_MATRIX = "Result matrix : \n %s";
    public static final String RESULT_SEQUENCE = "Result sequence : %s";

    public static final FillerArrayNumbers<Integer> FILLER_ARRAY_INTEGERS = new FillerArrayNumbers<>();
    public static final FillerArrayNumbers<Double> FILLER_ARRAY_DOUBLES = new FillerArrayNumbers<>();

    public static final FillerArrayStrings FILLER_ARRAY_STRINGS = new FillerArrayStrings();

    public static final FillerArrayPoints<Point2D<Integer>, Integer> FILLER_ARRAY_2D_POINTS_INTEGERS = new FillerArrayPoints<>();
    public static final FillerArrayPoints<Point2D<Double>, Double> FILLER_ARRAY_2D_POINTS_DOUBLES = new FillerArrayPoints<>();
    public static final FillerArrayPoints<Point3D<Integer>, Integer> FILLER_ARRAY_3D_POINTS_INTEGERS = new FillerArrayPoints<>();
    public static final FillerArrayPoints<Point3D<Double>, Double> FILLER_ARRAY_3D_POINTS_DOUBLES = new FillerArrayPoints<>();

    public static final FillerMatrixNumbers<Integer> FILLER_MATRIX_INTEGERS = new FillerMatrixNumbers<>();
    public static final FillerMatrixNumbers<Double> FILLER_MATRIX_DOUBLES = new FillerMatrixNumbers<>();

    public static final FillingArrayRandomPrimitiveIntegers FILLING_ARRAY_INTS = new FillingArrayRandomPrimitiveIntegers();
    public static final FillingArrayRandomPrimitiveDoubles FILLING_ARRAY_DOUBLES = new FillingArrayRandomPrimitiveDoubles();

    public static final FillingMatrixRandomPrimitiveIntegers FILLING_MATRIX_INTS = new FillingMatrixRandomPrimitiveIntegers();
    public static final FillingMatrixRandomPrimitiveDoubles FILLING_MATRIX_DOUBLES = new FillingMatrixRandomPrimitiveDoubles();

    public static final Reader READER_CONSOLE = new Reader(new ReadingConsole());

    public static int enterArrayLengthToConsole() {
        System.out.println("Enter length of the array : ");
        return ArrayLengthReader.readLength(READER_CONSOLE);
    }

    public static int enterMatrixRowCountToConsole() {
        System.out.println("Enter row count of the matrix : ");
        return READER_CONSOLE.readInt();
    }

    public static int enterMatrixColumnCountToConsole() {
        System.out.println("Enter column count of the matrix : ");
        return READER_CONSOLE.readInt();
    }

}
