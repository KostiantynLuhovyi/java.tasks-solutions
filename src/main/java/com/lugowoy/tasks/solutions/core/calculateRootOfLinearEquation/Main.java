package com.lugowoy.tasks.solutions.core.calculateRootOfLinearEquation;

import com.lugowoy.helper.calculating.CalculationOneParameter;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

/**
 * Write a program that finds the root of the linear equation ax + b = 0.
 * <p>
 * Created by Konstantin Lugowoy on 14-Dec-16.
 */

public class Main {

    private static final Reader READER = new Reader(new ReadingConsole());

    public static void main(String[] args) {

        LinearEquation equation = new LinearEquation();

        CalculationOneParameter<LinearEquation, LinearEquation> linearEquation = new CalculatingLinearEquation()::calculateLinearEquation;

        System.out.println("Calculate root in the linear equation : ax + b = 0");

        System.out.println("Enter value \"a\" : ");
        equation.setA(READER.readDouble());

        System.out.println("Enter value \"b\" : ");
        equation.setB(READER.readDouble());

        linearEquation.calculate(equation);

        System.out.format("Root (x) in the linear equation equal : %f", equation.getXRootLinearEquation());

    }

}
