package com.lugowoy.tasks.solutions.arrays.multidimensional.rotateMatrixByCertainNumberOfDegrees;

import com.lugowoy.helper.models.matrices.MatrixInts;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Konstantin Lugowoy on 30.10.2018.
 */
@FunctionalInterface
public interface RotatorMatrix {

    MatrixInts rotateMatrix(@NotNull final MatrixInts matrix);

}
