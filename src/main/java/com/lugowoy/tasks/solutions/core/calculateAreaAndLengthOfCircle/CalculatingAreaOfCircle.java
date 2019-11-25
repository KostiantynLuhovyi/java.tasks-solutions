package com.lugowoy.tasks.calculateAreaAndLengthOfCircle;

import java.util.Objects;

import static java.lang.Math.PI;
import static java.lang.Math.pow;

/**
 * Created by Konstantin Lugowoy on 15-Dec-16.
 */

public interface CalculatingAreaOfCircle {

    static Circle calculateAreaOfCircle(Circle circle) {
        if (Objects.nonNull(circle)) {
            circle.setArea(PI * pow(circle.getRadius(), 2));
        } else {
            throw new NullPointerException("The object of Circle class passed by argument is equal to null.");
        }
        return circle;
    }

}
