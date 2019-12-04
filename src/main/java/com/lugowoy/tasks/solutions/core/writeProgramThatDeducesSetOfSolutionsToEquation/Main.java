package com.lugowoy.tasks.solutions.core.writeProgramThatDeducesSetOfSolutionsToEquation;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * Write a program that introduces three integers and prints the set of solutions of equation ax² + bx + c = 0;
 * <p>
 * Created by Konstantin Lugowoy on 11.07.2017.
 */

public class Main {

    private static final Reader READER = new Reader(new ReadingConsole());

    public static void main(String[] args) {

        System.out.println("Enter integer number \'a\' : ");
        int a = READER.readInt();

        System.out.println("Enter integer number \'b\' : ");
        int b = READER.readInt();

        System.out.println("Enter integer number \'c\' : ");
        int c = READER.readInt();

        double discriminant = calculateDiscriminant(a, b, c);
        if (discriminant < 0) {
            System.out.println("The equation has no roots.");
        } else if (discriminant == 0) {
            double x = (-b + sqrt(discriminant)) / (2 * a);
            System.out.println("The equation has one root : " + x + " .");
        } else if (discriminant > 0) {
            double x1 = (-b + sqrt(discriminant)) / (2 * a);
            double x2 = (-b - sqrt(discriminant)) / (2 * a);
            System.out.printf("The equation has two roots.\n" +
                    "First root : %.2f .\n" +
                    "Second root : %.2f .", x1, x2);
        }

    }

    private static double calculateDiscriminant(int a, int b, int c) {
        return pow(b, 2) - 4 * a * c;
    }

}
