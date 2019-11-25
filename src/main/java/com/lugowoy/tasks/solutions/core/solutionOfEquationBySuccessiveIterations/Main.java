package com.lugowoy.tasks.solutionOfEquationBySuccessiveIterations;

/**
 * The solution of an equation of the form x = f (x) by the method of successive iterations.
 * <p>
 * Created by Konstantin Lugowoy on 14.11.2017.
 */

public class Main {

    private static final double FAULT = 1E-10;

    private static final double NUMBER_OF_COUNT = 1000;

    public static void main(String[] args) {

        double initialApproximateValue = 0;

        double rootOfEquation;
        double function = initialApproximateValue;

        int i = 0;
        do {
            i++;
            rootOfEquation = function;
            function = (rootOfEquation * rootOfEquation + 10) / 7;
        } while ((i <= NUMBER_OF_COUNT) && (Math.abs(rootOfEquation - function) > FAULT));

        rootOfEquation = function;

        System.out.println("Result of the equation : " + rootOfEquation);

    }

}
