package com.lugowoy.tasks.solutions.core.removeCentralDigitNumberOfThreeDigitsNumber;

/**
 * Created by Konstantin Lugowoy on 07-Feb-17.
 */

public class ParserToRemove {

    public void removeCentralDigitOfTheNumber(Number number) {
        int oneDigit, decimalDigit, thousandDigit;

        oneDigit = number.getNumber() % 10;
        number.setNumber(number.getNumber() / 10);

        decimalDigit = number.getNumber() % 10;
        number.setNumber(number.getNumber() / 10);

        thousandDigit = number.getNumber();

        number.setNumber(thousandDigit * 10 + oneDigit);
    }

}
