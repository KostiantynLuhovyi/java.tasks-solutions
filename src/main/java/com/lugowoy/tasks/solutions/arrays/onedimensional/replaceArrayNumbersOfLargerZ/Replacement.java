package com.lugowoy.tasks.solutions.arrays.onedimensional.replaceArrayNumbersOfLargerZ;

/**
 * Created by Konstantin Lugowoy on 13-Feb-17.
 */
@FunctionalInterface
public interface Replacement<T, V> {

    void replace(T numbersSequence, V v);

}
