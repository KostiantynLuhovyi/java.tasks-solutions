package com.lugowoy.tasks.determineSecondLargestNumber;

/**
 * Created by Konstantin Lugowoy on 14.11.2016.
 */

public class ComputingSecondLargestNumber {

    public static int computeSecondLargestNumber(Numbers numbers) {

        int secondLargestNumber = 0;

        if ((numbers.getFirstNumber() < numbers.getSecondNumber()) && (numbers.getFirstNumber() < numbers.getThirdNumber())) {
            secondLargestNumber = getSecondLargestNumber(numbers.getSecondNumber(), numbers.getThirdNumber());
        } else if ((numbers.getSecondNumber() < numbers.getFirstNumber()) && (numbers.getSecondNumber() < numbers.getThirdNumber())) {
            secondLargestNumber = getSecondLargestNumber(numbers.getFirstNumber(), numbers.getThirdNumber());
        } else if ((numbers.getThirdNumber() < numbers.getFirstNumber()) && (numbers.getThirdNumber() < numbers.getSecondNumber())) {
            secondLargestNumber = getSecondLargestNumber(numbers.getFirstNumber(), numbers.getSecondNumber());
        } else {
            System.out.println("Can not find the second largest number of. The numbers are equal. ");
        }
        return secondLargestNumber;
    }

    private static int getSecondLargestNumber(int firstLargestNumberForComparing, int secondLargestNumberForComparing) {
        int secondLargestNumber = 0;
        if (firstLargestNumberForComparing < secondLargestNumberForComparing) {
            secondLargestNumber = firstLargestNumberForComparing;
        } else if (secondLargestNumberForComparing < firstLargestNumberForComparing) {
            secondLargestNumber = secondLargestNumberForComparing;
        } else {
            System.out.println("Can not find the second largest number of. The numbers are equal.");
        }
        return secondLargestNumber;
    }

}
