package com.lugowoy.tasks.solutions.arrays.onedimensional.outputElementsOneDimensionalArrayAsArgumentsAndAssociatedValues;

/**
 * Created by Konstantin Lugowoy on 23-Feb-17.
 */

@FunctionalInterface
public interface Outputting<T, V extends Number> {

    void output(AssociativeArray<T, V> associativeArray);

}
