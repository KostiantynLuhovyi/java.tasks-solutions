package com.lugowoy.tasks.solutions.core.convertKilometersToMilesOfSeaAndLand;

/**
 * Created by Konstantin Lugowoy on 31-Dec-16.
 */

public interface Converting<T> {

    T convert(T t);

    double convert(double kilometers);

}
