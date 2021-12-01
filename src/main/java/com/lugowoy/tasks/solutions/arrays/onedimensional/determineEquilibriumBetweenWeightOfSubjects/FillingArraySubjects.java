package com.lugowoy.tasks.solutions.arrays.onedimensional.determineEquilibriumBetweenWeightOfSubjects;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.filling.array.FillingArray;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.utils.Capacity;
import com.lugowoy.helper.utils.RandomNumber;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Konstantin Lugowoy on 27.05.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @since 1.0
 * <p>
 * The class provides functionality to fill an object of the {@link
 * com.lugowoy.helper.models.arrays.Array} class and classical arrays with data
 * of the object of the {@link Subject} class type.
 */
public class FillingArraySubjects implements FillingArray<Subject> {

    private final int boundSubjectValue;

    public FillingArraySubjects(final int boundSubjectValue) {
        this.boundSubjectValue = boundSubjectValue;
    }

    /**
     * Fills an object of the {@link Array} class with data of the object of the
     * {@link Subject} class.
     *
     * @param array The object of the {@link Array} class to be filled with data
     * of the object of the {@link Subject} class.
     * @throws IllegalArgumentException If object of the {@link Array} class
     * argument is null.
     */
    @Override
    public void fill(@NotNull final Array<Subject> array) {
        CheckerArray.check(array, Capacity.UPPER.get());
        Subject[] subjects = new Subject[array.size()];
        this.initializeArrayElements(subjects);
        array.setArray(subjects);
    }

    /**
     * Fills an array with data of the object of the {@link Subject} class.
     *
     * @param subjects The array to be filled with data of the object {@link
     * Subject} class.
     * @throws IllegalArgumentException If the array argument is null.
     */
    @Override
    public void fill(Subject[] subjects) {
        CheckerArray.check(subjects, Capacity.UPPER.get());
        this.initializeArrayElements(subjects);
    }

    /**
     * Fills an array with data of the object of the {@link Subject} class.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created
     * array. If the value of "lengthArray" is less than {@link Capacity#LOWER}
     * or is greatest than {@link Capacity#UPPER}, created array of length
     * {@link com.lugowoy.helper.models.arrays.AbstractArray#DEFAULT_CAPACITY}.
     *
     * @param lengthArray The length(size) of the array to be filled with data
     * of the object of the {@link Subject} class type.
     * @return Created and filled array with data of the object of the {@link
     * Subject} class type.
     */
    @Override
    public Subject[] fill(int lengthArray) {
        CheckerArray.check(lengthArray);
        Subject[] subjects = new Subject[lengthArray];
        this.initializeArrayElements(subjects);
        return subjects;
    }

    private void initializeArrayElements(Subject[] arraySubjects) {
        int idCounter = 1;
        RandomNumber randomNumber = new RandomNumber();
        for (int i = 0; i < arraySubjects.length; i++) {
            arraySubjects[i] = new Subject(idCounter,
                                           randomNumber.generateInt(this.boundSubjectValue));
            idCounter++;
        }
    }

}
