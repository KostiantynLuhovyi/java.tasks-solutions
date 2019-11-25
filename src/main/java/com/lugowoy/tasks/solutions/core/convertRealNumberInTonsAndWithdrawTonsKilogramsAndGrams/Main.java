package com.lugowoy.tasks.convertRealNumberInTonsAndWithdrawTonsKilogramsAndGrams;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

/**
 * The user enters the mass in tons (real number) from the keyboard.
 * Output separately the number of tons, kilograms, gram (for example, enter 126.456789t - get and output 126t 456kg 789g).
 * <p>
 * Created by Konstantin Lugowoy on 26.03.2017.
 */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    private static final Converting CONVERTING = Converting::convertRealNumberInTonsAndWithdrawTonsKilogramsAndGrams;

    public static void main(String[] args) {

        System.out.println("Enter the real number of the number of tons : ");
        double enterNumberOfTons = READER.readDouble();

        CONVERTING.convert(enterNumberOfTons);

    }

}
