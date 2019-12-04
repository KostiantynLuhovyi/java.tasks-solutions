package com.lugowoy.tasks.solutions.core.determineSecondLargestNumber;

/**
 * Created by Konstantin Lugowoy on 14.11.2016.
 */

@FunctionalInterface
interface Computing<T> {

    int compute(T t);

}
