package com.lugowoy.tasks.tasksForWorkingWithVectors.calculating;

import com.lugowoy.tasks.tasksForWorkingWithVectors.vectors.Vector2D;

import java.math.BigDecimal;

/**
 * Created by LugowoyKonstantin on 29.11.2018.
 */

@FunctionalInterface
public interface CalculatingVector2D<T extends Number> {

    Vector2D<T> calculate(Vector2D<T> firstVector, Vector2D<T> secondVector);

    @SuppressWarnings("unchecked")
    static <T extends Number> Vector2D<T> calculateAdditionOfVectors(Vector2D<T> firstVector, Vector2D<T> secondVector) {
        Vector2D<T> result = new Vector2D<>();
        if (isEqualVectorLength(firstVector, secondVector)) {
            result.setX((T) new BigDecimal(firstVector.getX().doubleValue()).add(new BigDecimal(secondVector.getX().doubleValue())));
            result.setY((T) new BigDecimal(firstVector.getY().doubleValue()).add(new BigDecimal(secondVector.getY().doubleValue())));
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    static <T extends Number> Vector2D<T> calculateSubtractionOfVectors(Vector2D<T> firstVector, Vector2D<T> secondVector) {
        Vector2D<T> result = new Vector2D<>();
        if (isEqualVectorLength(firstVector, secondVector)) {
            result.setX((T) new BigDecimal(firstVector.getX().doubleValue()).subtract(new BigDecimal(secondVector.getX().doubleValue())));
            result.setY((T) new BigDecimal(firstVector.getY().doubleValue()).subtract(new BigDecimal(secondVector.getY().doubleValue())));
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    static <T extends Number> Vector2D<T> calculateMultiplicationOfVectors(Vector2D<T> firstVector, Vector2D<T> secondVector) {
        Vector2D<T> result = new Vector2D<>();
        if (isEqualVectorLength(firstVector, secondVector)) {
            result.setX((T) new BigDecimal(firstVector.getX().doubleValue()).multiply(new BigDecimal(secondVector.getX().doubleValue())));
            result.setY((T) new BigDecimal(firstVector.getY().doubleValue()).multiply(new BigDecimal(secondVector.getY().doubleValue())));
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    static <T extends Number> Vector2D<T> incrementVector(Vector2D<T> vector2D) {
        vector2D.setX((T) Double.valueOf(new BigDecimal(vector2D.getX().doubleValue()).add(new BigDecimal(1)).doubleValue()));
        vector2D.setY((T) Double.valueOf(new BigDecimal(vector2D.getY().doubleValue()).add(new BigDecimal(1)).doubleValue()));
        return vector2D;
    }

    @SuppressWarnings("unchecked")
    static <T extends Number> Vector2D<T> decrementVector(Vector2D<T> vector2D) {
        vector2D.setX((T) Double.valueOf(new BigDecimal(vector2D.getX().doubleValue()).subtract(new BigDecimal(1)).doubleValue()));
        vector2D.setY((T) Double.valueOf(new BigDecimal(vector2D.getY().doubleValue()).subtract(new BigDecimal(1)).doubleValue()));
    }


    private static <T extends Number> boolean isEqualVectorLength(Vector2D<T> firstVector, Vector2D<T> secondVector) {
        return firstVector.getLength() == secondVector.getLength();
    }

}
