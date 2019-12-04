package com.lugowoy.tasks.solutions.core.convertingDegreesTemperatures;

/**
 * Created by Konstantin lugowoy on 11-Jan-17.
 */

public interface Converting<T> {

    T convert(T t, TemperatureScale scale);

}
