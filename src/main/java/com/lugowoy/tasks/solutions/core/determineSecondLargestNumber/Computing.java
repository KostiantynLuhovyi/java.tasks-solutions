package com.lugowoy.tasks.determineSecondLargestNumber;

/**
 * Created by Konstantin Lugowoy on 14.11.2016.
 */

@FunctionalInterface
interface Computing<T> {

    int compute(T t);

}
