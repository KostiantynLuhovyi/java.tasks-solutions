package com.lugowoy.tasks.constructionOfComplexNumberToIntegerDegree;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

/**
 * Construction of a complex number to the integer degree.
 * <p>
 * Created by Konstantin Lugowoy on 07.11.2017.
 */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    public static void main(String[] args) {

        System.out.println("Enter the real part of the complex number : ");
        double x = READER.readDouble();

        System.out.println("Enter the imaginary part of the complex number : ");
        double y = READER.readDouble();

        System.out.println("Enter an integer degree : ");
        double degree = READER.readDouble();

        double r = Math.sqrt(x * x + y * y);
        double phi = Math.atan2(y, x);

        double Re = Math.pow(r, degree) * Math.cos(degree * phi);
        double Im = Math.pow(r, degree) * Math.sin(degree * phi);

        System.out.println("The real part of the complex number : " + Re);
        System.out.println("the imaginary part of the complex number : " + Im);

    }

}
