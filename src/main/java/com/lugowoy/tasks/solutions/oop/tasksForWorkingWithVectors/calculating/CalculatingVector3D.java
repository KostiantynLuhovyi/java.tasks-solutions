package com.lugowoy.tasks.tasksForWorkingWithVectors.calculating;

import com.lugowoy.tasks.tasksForWorkingWithVectors.vectors.Vector2D;
import com.lugowoy.tasks.tasksForWorkingWithVectors.vectors.Vector3D;

import java.math.BigDecimal;

/**
 * Created by LugowoyKonstantin on 12.12.2018.
 */

public class CalculatingVector3D {

    @SuppressWarnings("unchecked")
    static <T extends Number> Vector3D<T> calculateAdditionOfVectors(Vector3D<T> firstVector, Vector3D<T> secondVector) {
        Vector3D<T> result = new Vector3D<>();
        if (isEqualVectorLength(firstVector, secondVector)) {
            result.setX((T) new BigDecimal(firstVector.getX().doubleValue()).add(new BigDecimal(secondVector.getX().doubleValue())));
            result.setY((T) new BigDecimal(firstVector.getY().doubleValue()).add(new BigDecimal(secondVector.getY().doubleValue())));
            result.setZ((T) new BigDecimal(firstVector.getZ().doubleValue()).add(new BigDecimal(secondVector.getZ().doubleValue())));
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    static <T extends Number> Vector3D<T> calculateSubtractionOfVectors(Vector3D<T> firstVector, Vector3D<T> secondVector) {
        Vector3D<T> result = new Vector3D<>();
        if (isEqualVectorLength(firstVector, secondVector)) {
            result.setX((T) new BigDecimal(firstVector.getX().doubleValue()).subtract(new BigDecimal(secondVector.getX().doubleValue())));
            result.setY((T) new BigDecimal(firstVector.getY().doubleValue()).subtract(new BigDecimal(secondVector.getY().doubleValue())));
            result.setZ((T) new BigDecimal(firstVector.getZ().doubleValue()).subtract(new BigDecimal(secondVector.getZ().doubleValue())));
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    static <T extends Number> Vector3D<T> calculateMultiplicationOfVectors(Vector3D<T> firstVector, Vector3D<T> secondVector) {
        Vector3D<T> result = new Vector3D<>();
        if (isEqualVectorLength(firstVector, secondVector)) {
            result.setX((T) new BigDecimal(firstVector.getX().doubleValue()).multiply(new BigDecimal(secondVector.getX().doubleValue())));
            result.setY((T) new BigDecimal(firstVector.getY().doubleValue()).multiply(new BigDecimal(secondVector.getY().doubleValue())));
            result.setZ((T) new BigDecimal(firstVector.getZ().doubleValue()).multiply(new BigDecimal(secondVector.getZ().doubleValue())));
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    static <T extends Number> Vector3D<T> incrementVector(Vector3D<T> vector3D) {
        vector3D.setX((T) Double.valueOf(new BigDecimal(vector3D.getX().doubleValue()).add(new BigDecimal(1)).doubleValue()));
        vector3D.setY((T) Double.valueOf(new BigDecimal(vector3D.getY().doubleValue()).add(new BigDecimal(1)).doubleValue()));
        vector3D.setZ((T) Double.valueOf(new BigDecimal(vector3D.getZ().doubleValue()).add(new BigDecimal(1)).doubleValue()));
        return vector3D;
    }

    @SuppressWarnings("unchecked")
    static <T extends Number> Vector3D<T> decrementVector(Vector2D<T> vector2D) {
        vector2D.setX((T) Double.valueOf(new BigDecimal(vector2D.getX().doubleValue()).subtract(new BigDecimal(1)).doubleValue()));
        vector2D.setY((T) Double.valueOf(new BigDecimal(vector2D.getY().doubleValue()).subtract(new BigDecimal(1)).doubleValue()));
    }

    private static <T extends Number> boolean isEqualVectorLength(Vector3D<T> firstVector, Vector3D<T> secondVector) {
        return firstVector.getLength() == secondVector.getLength();
    }

}
