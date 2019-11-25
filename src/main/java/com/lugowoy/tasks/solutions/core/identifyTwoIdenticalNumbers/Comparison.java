package com.lugowoy.tasks.identifyTwoIdenticalNumbers;

/**
 * Created by Konstantin Lugowoy on 08.11.2016.
 */

interface Comparison<T> {

    String NO_EQUAL_NUMBERS = "Among the three numbers is not equal.\n";

    void compareNumbers(T t);

}
