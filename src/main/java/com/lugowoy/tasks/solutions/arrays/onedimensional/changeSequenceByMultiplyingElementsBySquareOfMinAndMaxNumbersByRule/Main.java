package com.lugowoy.tasks.solutions.arrays.onedimensional.changeSequenceByMultiplyingElementsBySquareOfMinAndMaxNumbersByRule;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.ArrayLengthReader;
import com.lugowoy.tasks.solutions.arrays.onedimensional.changeSequenceByMultiplyingElementsBySquareOfMinAndMaxNumbersByRule.Changing;
import com.lugowoy.tasks.solutions.arrays.onedimensional.changeSequenceByMultiplyingElementsBySquareOfMinAndMaxNumbersByRule.Determinant;

import static com.lugowoy.helper.filling.ValuesToFilling.INT_LOWER_BOUND;
import static com.lugowoy.helper.filling.ValuesToFilling.INT_UPPER_BOUND;

/**
 * Given integers a1, a2, ..., an.
 * It is required to multiply all the terms of the sequence a1, a2, ... by the square of its smallest term, if ak ≥ 0,
 * and the square of its largest term, if ak ≤ 0.
 * <p> Created by Konstantin Lugowoy on 25.03.2017.
 */
public class Main {

    private static final Changing<ArrayInts> CHANGING = Changing::changeSequenceByMultiplyingElementsBySquareOfMinAndMaxNumberByRule;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        FillingArrayRandomPrimitiveIntegers filler = new FillingArrayRandomPrimitiveIntegers();

        ArrayInts array = new ArrayInts(filler.fill(lengthOfArray, INT_LOWER_BOUND, INT_UPPER_BOUND));

        System.out.println("Original sequence : " + array);
        System.out.println();

        int squareMinNumberInTheSequence = getSquareMinNumberInTheSequence(array, Determinant::determineMinNumber);

        int squareMaxNumberInTheSequence = getSquareMaxNumberInTheSequence(array, Determinant::determineMaxNumber);

        CHANGING.change(array, squareMinNumberInTheSequence, squareMaxNumberInTheSequence);

        System.out.println();
        System.out.println("Result sequence after changing : " + array);
        System.out.println();

    }

    private static int getSquareMaxNumberInTheSequence(ArrayInts array, Determinant<Integer> determinant) {
        int squareMaxNumberInTheSequence = (int) Math.pow(determinant.determine(array), 2);
        System.out.println("Square max number in the array is " + squareMaxNumberInTheSequence + " .");
        return squareMaxNumberInTheSequence;
    }

    private static int getSquareMinNumberInTheSequence(ArrayInts array, Determinant<Integer> determinant) {
        int squareMinNumberInTheSequence = (int) Math.pow(determinant.determine(array), 2);
        System.out.println("Square min number in the array is " + squareMinNumberInTheSequence + " .");
        return squareMinNumberInTheSequence;
    }

}
