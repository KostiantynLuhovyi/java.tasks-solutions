package com.lugowoy.tasks.solutions.arrays.onedimensional.determineNumberOfArrayInWhichRemainderOfDivisionIsEqualToCertainNumber;

import com.lugowoy.helper.models.arrays.AbstractArray;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Konstantin Lugowoy on 14-Feb-17.
 */
@FunctionalInterface
public interface Determinant<T extends AbstractArray> {

    void determinate(@NotNull final T tArray, int numberToModulo, int resultModulo);

}
