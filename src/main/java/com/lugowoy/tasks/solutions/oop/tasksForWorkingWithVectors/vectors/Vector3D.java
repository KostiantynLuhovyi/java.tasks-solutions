package com.lugowoy.tasks.tasksForWorkingWithVectors.vectors;

import java.math.BigDecimal;

/**
 * Created by Konstantin Lugowoy on 29.11.2018.
 */

public class Vector3D<T extends Number> extends Vector2D<T> {

    public Vector3D(int dimension) {
        super(dimension);
    }

    public Vector3D(T[] vector) {
        super(vector);
    }

    @Override
    public boolean equalsVectors(Vector2D<T> vector2D) {
        boolean equalsResult = false;
        if (vector2D != null) {
            if ((super.getX().doubleValue() == vector2D.getX().doubleValue())
                    && (super.getY().doubleValue() == vector2D.getY().doubleValue())
                        && (this.getZ().doubleValue() == ((Vector3D<T>)vector2D).getZ().doubleValue())) {
                equalsResult = true;
            }
        }
        return equalsResult;
    }

    @Override
    public BigDecimal getModuleVector() {
        return new BigDecimal(Math.sqrt(new BigDecimal(Math.pow(this.getX().doubleValue(), 2))
                                            .add(new BigDecimal(Math.pow(this.getY().doubleValue(), 2)))
                                                .add(new BigDecimal(Math.pow(this.getZ().doubleValue(), 2)))
                              .doubleValue()));
    }

    public T getZ() {
        return super.getVector()[3];
    }

    public void setZ(T t) {
        super.getVector()[3] = t;
    }

}
