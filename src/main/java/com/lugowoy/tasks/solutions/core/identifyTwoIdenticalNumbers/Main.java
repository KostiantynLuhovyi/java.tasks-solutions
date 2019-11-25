package com.lugowoy.tasks.identifyTwoIdenticalNumbers;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.other.GeneratorRandomNumber;

/**
 * Enter three numbers and define two of the same number of them.
 * <p>
 * Created by Konstantin Lugowoy on 07.11.2016.
 */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    private static final int USER_ENTER_NUMBERS = 1;
    private static final int RANDOM_ENTER_NUMBERS = 2;
    private static final int EXIT = 3;

    private static final ComparingNumbers COMPARING_NUMBERS = new ComparingNumbers();

    public static void main(String[] args) {

        NumbersForComparison numbersForComparison;

        do {
            System.out.println("User enter three integers numbers(signed and unsigned), press - \"1\".");
            System.out.println("Random enter three integers numbers(signed and unsigned), press - \"2\".");
            System.out.println("To exit, press - \"3\".");
            System.out.println("Make a choice : ");
            int statusChoice = enterCorrectStatusChoice();

            switch (statusChoice) {
                case USER_ENTER_NUMBERS:
                    numbersForComparison = new NumbersForComparison();
                    System.out.println("Enter the first value : ");
                    numbersForComparison.setFirstNumber(READER.readInt());
                    System.out.println("Enter the second value : ");
                    numbersForComparison.setSecondNumber(READER.readInt());
                    System.out.println("Enter the third value : ");
                    numbersForComparison.setThirdNumber(READER.readInt());
                    COMPARING_NUMBERS.compareNumbers(numbersForComparison);
                    break;
                case RANDOM_ENTER_NUMBERS:
                    numbersForComparison = new NumbersForComparison();
                    numbersForComparison.setFirstNumber(GeneratorRandomNumber.generateInt());
                    numbersForComparison.setSecondNumber(GeneratorRandomNumber.generateInt());
                    numbersForComparison.setThirdNumber(GeneratorRandomNumber.generateInt());
                    COMPARING_NUMBERS.compareNumbers(numbersForComparison);
                    break;
                case EXIT:
                    return;
                default:
                    break;
            }
        } while (true);

    }

    private static int enterCorrectStatusChoice() {
        int statusChoice = 0;
        String description = "Enter a number from 1 to 3\n";
        String inputValue = READER.readString();
        if (isDigit(inputValue)) {
            if (checkCorrectRange(Integer.parseInt(inputValue))) {
                statusChoice = Integer.parseInt(inputValue);
            } else {
                System.out.println(description);
            }
        } else {
            System.out.println(description);
        }
        return statusChoice;
    }

    private static boolean checkCorrectRange(int value) {
        return ((value > 0) && (value < 4));
    }

    private static boolean isDigit(String inputValue) {
        boolean statusDigit = false;
        if (inputValue.matches("\\d")) {
            statusDigit = true;
        }
        return statusDigit;
    }

}
