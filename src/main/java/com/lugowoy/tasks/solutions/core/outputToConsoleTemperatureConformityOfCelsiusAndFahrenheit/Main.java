package com.lugowoy.tasks.solutions.core.outputToConsoleTemperatureConformityOfCelsiusAndFahrenheit;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

/**
 * The program prints a table of temperature correlations for Celsius and Fahrenheit in the specified range.
 * <p>
 * Created by Konstantin Lugowoy on 05.10.2017.
 */

public class Main {

    private static final Reader READER = new Reader(new ReadingConsole());

    private static final int MIN_TEMPERATURE = -150;
    private static final int MAX_TEMPERATURE = 150;

    public static void main(String[] args) {

        System.out.println("Enter the lower boundary of temperature in Celsius : ");
        double lowerBoundInCelsius = enterValueOfTemperatureCelsius();
        System.out.println("Enter the upper boundary of temperature in Celsius : ");
        double upperBoundInCelsius = enterValueOfTemperatureCelsius();

        if (lowerBoundInCelsius < upperBoundInCelsius) {
            System.out.println("The output occurs every 5 degrees Celsius.");
            System.out.print("Celsius degrees" + "      " + "Fahrenheits degrees");
            System.out.println();
            for (int i = (int) lowerBoundInCelsius; i <= upperBoundInCelsius; i += 5) {
                System.out.printf("      %.2f          %.2f        ", lowerBoundInCelsius, ((lowerBoundInCelsius * 1.8) + 32.0));
                System.out.println();
                lowerBoundInCelsius += 5.0;
            }
        } else {
            System.out.println("It is impossible to calculate as the values are not correct.");
        }

    }

    private static double enterValueOfTemperatureCelsius() {
        double valueTemperature;
        while (true) {
            valueTemperature = READER.readDouble();
            if ((valueTemperature >= MIN_TEMPERATURE) && (valueTemperature <= MAX_TEMPERATURE)) {
                break;
            } else {
                System.out.println("Not correct value of temperature. Re-enter : ");
            }
        }
        return valueTemperature;
    }

}
