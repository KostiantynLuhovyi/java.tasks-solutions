package com.lugowoy.tasks.writeProgramUsingBernoulliScheme;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

/**
 * Write a program using the Bernoulli scheme.
 * <p>
 * Created by Konstantin Lugowoy on 18.11.2017.
 */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    public static void main(String[] args) {

        System.out.println("Enter the number of tests : ");
        int numberOfTests = READER.readInt();

        System.out.println("Enter the value of success : ");
        double valueOfSuccess = READER.readDouble();

        SchemeBernoulli scheme = new SchemeBernoulli();
        scheme.setParamToScheme(numberOfTests, valueOfSuccess);
        scheme.testing();
        scheme.showResult();

    }

}
