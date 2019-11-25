package com.lugowoy.tasks.identifyTwoIdenticalNumbers;

/**
 * Created by Konstantin Lugowoy on 08.11.2016.
 */

class ComparingNumbers implements Comparison<NumbersForComparison> {

    @Override
    public void compareNumbers(NumbersForComparison numbersForComparison) {
        String statusCompare;

        if ((numbersForComparison != null)) {

            if (numbersForComparison.getFirstNumber() == numbersForComparison.getSecondNumber()) {

                statusCompare = String.format("The first(%d) and second(%d) numbers are equal." + "%n",
                        numbersForComparison.getFirstNumber(), numbersForComparison.getSecondNumber());
                System.out.println(statusCompare);

            } else if (numbersForComparison.getFirstNumber() == numbersForComparison.getThirdNumber()) {

                statusCompare = String.format("The first(%d) and third(%d) numbers are equal." + "%n",
                        numbersForComparison.getFirstNumber(), numbersForComparison.getThirdNumber());
                System.out.println(statusCompare);

            } else if (numbersForComparison.getSecondNumber() == numbersForComparison.getThirdNumber()) {

                statusCompare = String.format("The second(%d) and third(%d) numbers are equal." + "%n",
                        numbersForComparison.getSecondNumber(), numbersForComparison.getThirdNumber());
                System.out.println(statusCompare);

            } else {
                statusCompare = NO_EQUAL_NUMBERS;
                System.out.println(statusCompare);
            }
        }
    }

}
