package com.lugowoy.tasks.exchangeCentralNumberOfTwoNumbers;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

/**
 * Enter from the keyboard two three-digit numbers and change their central numbers.
 * <p>
 * Created by Konstantin Lugowoy on 05-Feb-17.
 */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    public static void main(String[] args) {

        Number firstNumber = enterNumber();
        Number secondNumber = enterNumber();

        System.out.printf("The following values have been entered : \n" +
                        "first number = %d;\nsecond number = %d.\n", firstNumber.getNumber(), secondNumber.getNumber());

        ExchangeCentralNumberOfTwoNumber.exchange(firstNumber, secondNumber);

        System.out.printf("The result to exchange central number of  the two numbers : \n" +
                        "first number = %d;\nsecond number = %d.\n", firstNumber.getNumber(), secondNumber.getNumber());

    }

    private static Number enterNumber() {
        Number number;
        int value;
        do {
            System.out.println("Enter value : ");
            value = READER.readInt();
            if ((value > 102) && (value < 999)) {
                number = new Number(value);
                break;
            } else {
                System.out.println("Not correct input value.");
            }
        } while (true);

        return number;
    }

}
