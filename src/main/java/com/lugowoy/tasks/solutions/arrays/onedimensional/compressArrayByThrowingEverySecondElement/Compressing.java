package com.lugowoy.tasks.solutions.arrays.onedimensional.compressArrayByThrowingEverySecondElement;

import com.lugowoy.helper.models.storages.arrays.AbstractArray;

/**
 * Created by Konstantin Lugowoy on 13.03.2017.
 */
@FunctionalInterface
public interface Compressing<T extends AbstractArray> {

    void compress(T t);

}
