package com.lugowoy.tasks.solutions.arrays.onedimensional.determineMostRepeatedElementInArray;

import com.lugowoy.helper.models.arrays.AbstractArray;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Konstantin Lugowoy on 22.03.2017.
 */
@FunctionalInterface
public interface Determinant<T extends AbstractArray> {

    void determine(@NotNull final T array);

}
