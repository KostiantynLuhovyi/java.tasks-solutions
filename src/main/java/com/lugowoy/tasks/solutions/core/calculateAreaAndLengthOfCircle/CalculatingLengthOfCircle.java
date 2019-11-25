package com.lugowoy.tasks.calculateAreaAndLengthOfCircle;

import static java.lang.Math.PI;

/**
 * Created by Konstantin Lugowoy on 01-Feb-17.
 */

public interface CalculatingLengthOfCircle {

    static Circle calculateLengthOfCircle(Circle circle) {
        if (circle != null) {
            circle.setLength(2 * PI * circle.getRadius());
        } else {
            throw new NullPointerException("The object of Circle class passed by argument is equal to null.");
        }
        return circle;
    }

}
