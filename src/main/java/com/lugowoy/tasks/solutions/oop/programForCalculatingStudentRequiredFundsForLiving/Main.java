package com.lugowoy.tasks.programForCalculatingStudentRequiredFundsForLiving;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

import java.math.BigDecimal;

/**
 * Monthly student stipend is N UAH, and living expenses exceed the stipend and make M UAH per month.
 * The price increase monthly increases expenses by 3%.
 * Make a program for calculating the amount of money that you need to ask at a time
 * from your parents so that you can live an academic year (10 months), using only this money and a stipend.
 * <p>
 * Created by LugowoyKonstantin on 02.11.2017.
 */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    public static void main(String[] args) {

        System.out.println("Data of student.");
        System.out.println("Enter first name : ");
        String firstName = READER.readString();
        System.out.println("Enter second name : ");
        String secondName = READER.readString();

        System.out.println("Enter amount of stipend : ");
        double amountOfStipend = READER.readDouble();

        Student student = new Student(firstName, secondName, amountOfStipend);

        System.out.println("Enter number month of living int the place of residence : ");
        int monthOfLiving = READER.readInt();
        System.out.println("Enter cost place of residence : ");
        BigDecimal costPlaceOfResidence = new BigDecimal(READER.readDouble());

        PlaceOfResidence placeOfResidence = new PlaceOfResidence(monthOfLiving, costPlaceOfResidence);

        Calculating calculating = Calculating::calculatingAmountOfMoneyThatIsNotEnoughToPayForLiving;
        BigDecimal result = calculating.calculate(student, placeOfResidence);
        if (result.equals(new BigDecimal(0))) {
            System.out.println("The amount of the stipend is more than the cost of the place of residence");
        } else {
            System.out.printf("%.2f not enough to pay for accommodation.", result.doubleValue());
        }

    }

}
