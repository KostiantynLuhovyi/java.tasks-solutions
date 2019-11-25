package com.lugowoy.tasks.tasksForWorkingWithVectors.calculating;

import com.lugowoy.tasks.tasksForWorkingWithVectors.vectors.Vector2D;

/**
 * Created by LugowoyKonstantin on 12.12.2018.
 */

@FunctionalInterface
public interface CalculatingVector<T extends Number> {

    Vector2D<T> calculate(Vector2D<T> firstVector, Vector2D<T> secondVector);

}
