package com.lugowoy.tasks.calculationPercentageOfSum;

import com.lugowoy.helper.calculating.CalculationOneParameter;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Write a program that finds the percentage P of the sum of S.
 * <p>
 * Created by Konstantin Lugowoy on 04-Jan-17.
 */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    public static void main(String[] args) {

        System.out.println("Enter sum : ");
        BigDecimal sum = new BigDecimal(READER.readDouble());

        System.out.println("Enter part of the sum : ");
        BigDecimal partOfTheSum = new BigDecimal(READER.readDouble());

        Variable variable = new Variable(sum, partOfTheSum);

        Comparable<Variable> variableComparable = variableToCompare -> {
            int result;
            if (variableToCompare.getSum().doubleValue() > variableToCompare.getPartOfSum().doubleValue()) {
                result = 1;
            } else {
                result = 0;
            }
            return result;
        };

        if (variableComparable.compareTo(variable) > 0) {
            CalculationOneParameter<Variable, Variable> calculatorVariable = new CalculatingPercentOfSum()::calculateThePercentageOfTheSum;
            calculatorVariable.calculate(variable);

            System.out.printf("Result calculation the percent of the sum of equal : %s",
                    variable.getPercent().setScale(2, RoundingMode.HALF_DOWN).stripTrailingZeros().toPlainString());
        } else {
            System.out.println("It is impossible to calculate the percentage of the sum.");
        }

    }

}
