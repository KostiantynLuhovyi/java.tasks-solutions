package com.lugowoy.tasks.tasksForWorkingWithVectors.vectors;

import java.math.BigDecimal;

/**
 * Created by LugowoyKonstantin on 29.11.2018.
 */

public class Vector2D<T extends Number> extends Vector<T> {

    public Vector2D(T[] vector) {
        super(vector);
    }

    public boolean equalsVectors(Vector2D<T> vector2D) {
        boolean equalsResult = false;
        if (vector2D != null) {
            if ((this.getX().doubleValue() == vector2D.getX().doubleValue())
                    && (this.getY().doubleValue() == vector2D.getY().doubleValue())) {
                equalsResult = true;
            }
        }
        return equalsResult;
    }

    public BigDecimal getModuleVector() {
        return new BigDecimal(Math.sqrt(new BigDecimal(Math.pow(this.getX().doubleValue(), 2))
                                            .add(new BigDecimal(Math.pow(this.getY().doubleValue(), 2)))
                              .doubleValue()));
    }

    public void setX(T t) {
        super.getVector()[0] = t;
    }

    public T getX() {
        return super.getVector()[0];
    }

    public void setY(T t) {
        super.getVector()[1] = t;
    }

    public T getY() {
        return super.getVector()[1];
    }

}
