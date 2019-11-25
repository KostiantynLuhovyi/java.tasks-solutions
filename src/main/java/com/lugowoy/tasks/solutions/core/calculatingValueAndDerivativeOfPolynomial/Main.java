package com.lugowoy.tasks.calculatingValueAndDerivativeOfPolynomial;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomInteger;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.LengthReader;

/**
 * Calculating the value and derivative of a polynomial based on the elements of the array.
 * <p>
 * Created by Konstantin Lugowoy on 14.11.2017.
 */

public class Main {

    private static final int LENGTH_ARRAY = 5;
    private static final int START_BOUND = -5;
    private static final int END_BOUND = 5;

    public static void main(String[] args) {

        Array<Integer> polynomialCoefficients = new Array<>(new FillingArrayRandomInteger().fill(LENGTH_ARRAY, START_BOUND, END_BOUND));
        System.out.println(polynomialCoefficients);

        //todo Check why value LENGTH_ARRAY is "LENGTH_ARRAY - 1";
        Array<Integer> derivativeCoefficients = new Array<>(LENGTH_ARRAY - 1);

        double resultPolynomial = 0;
        double resultDerivative = 0;

        double argument = 2.0;
        double factor = 1;

        for (int i = 0; i < derivativeCoefficients.getLength(); i++) {
            resultPolynomial += polynomialCoefficients.get(i) * factor;
            derivativeCoefficients.set(i, (i + 1) * polynomialCoefficients.get(i + 1));
            resultDerivative += derivativeCoefficients.get(i) * factor;
            factor *= argument;
        }
        resultPolynomial += polynomialCoefficients.get(polynomialCoefficients.getLength() - 1) * factor;

        System.out.println();
        System.out.println("Result polynomial : " + resultPolynomial);
        System.out.println("Result derivative : " + resultDerivative);

        int resTest = LengthReader.readLength(Reader.getReader(new ReadingConsole()), 20);
        System.out.println(resTest);

    }

}

