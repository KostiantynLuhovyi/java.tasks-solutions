package com.lugowoy.tasks.tasksForWorkingWithVectors.vectors;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;

/**
 * Created by LugowoyKonstantin on 17.12.2018.
 */

public abstract class Vector<T> {

    public static final int DIMENSION_ON_SURFACE = 2;
    public static final int DIMENSION_IN_SPACE = 3;

    private final int dimension;

    private Object[] vector;

    protected Vector() {
        this.dimension = -1;
    }

    public Vector(int dimension) {
        if (dimension > 0) {
            this.dimension = dimension;
            this.vector = new Object[dimension];
        } else {
            throw new IllegalArgumentException("Incorrect value dimension.");
        }
    }

    public Vector(T[] vector) {
        if (vector != null) {
            this.dimension = vector.length;
            this.vector = new Object[this.dimension];
            if (this.dimension > 0) System.arraycopy(vector, 0, this.vector, 0, this.dimension);
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument vector passed is null."));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vector)) return false;
        Vector<?> vector1 = (Vector<?>) o;
        return dimension == vector1.dimension &&
                Arrays.equals(vector, vector1.vector);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(dimension);
        result = 31 * result + Arrays.hashCode(vector);
        return result;
    }

    @Override
    public String toString() {
        return "Vector[" +
                "dimension=" + dimension +
                ", vector=" + Arrays.toString(vector) +
                ']';
    }

    public int getDimension() {
        return dimension;
    }

    public void setVector(T[] vector) {
        if (vector != null) {
            this.vector = vector;
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument vector passed is null."));
        }
    }

    @SuppressWarnings("unchecked")
    T[] getVector() {
        return (T[]) this.vector;
    }

    public void set(int indexDimension, T value) {
        if (indexDimension >= 0 && indexDimension <= this.vector.length) {
            this.vector[indexDimension] = value;
        } else {
            throw new IllegalArgumentException("Incorrect index dimension.");
        }
    }

    @SuppressWarnings("unchecked")
    private T get(int indexDimension) {
        T result;
        if (indexDimension >= 0 && indexDimension <= this.vector.length) {
            result = (T) this.vector[indexDimension];
        } else {
            throw new IllegalArgumentException("Incorrect index dimension.");
        }
        return result;
    }

    public abstract BigDecimal getModuleVector();

}
