package com.lugowoy.tasks.calculateAreaAndLengthOfCircle;

import com.lugowoy.helper.calculating.CalculationOneParameter;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

/**
 * Write a program that prompts the user to enter the radius of the circle,
 * and then finds the area and the lengthRoom of the circumference.
 * The number Pi to set the program as a real constant.
 * <p>
 * Created by Konstantin Lugowoy on 15-Dec-16.
 */
public class Main {

    public static void main(String[] args) {

        Circle circle = new Circle();

        System.out.println("Enter the radius of the circle : ");
        circle.setRadius(Reader.getReader(new ReadingConsole()).readDouble());

        CalculationOneParameter<Circle, Circle> calculator = CalculatingAreaOfCircle::calculateAreaOfCircle;
        calculator.calculate(circle);

        System.out.format("The area of the circle is equal to %f", circle.getArea());
        System.out.println();

        calculator = CalculatingLengthOfCircle::calculateLengthOfCircle;
        calculator.calculate(circle);

        System.out.format("The length of the circle is equal to %.3f", circle.getLength());
        System.out.println();

    }

}
