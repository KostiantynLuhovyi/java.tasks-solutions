package com.lugowoy.tasks.solutions.arrays.onedimensional.createArrayOfZeroElementsOfAnotherArray;

import com.lugowoy.helper.models.arrays.AbstractArray;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Konstantin Lugowoy on 12-Feb-17.
 */
@FunctionalInterface
public interface Filling<T extends AbstractArray> {

    T fillArray(@NotNull final T array);

}
