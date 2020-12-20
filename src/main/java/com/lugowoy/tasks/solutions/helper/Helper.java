package com.lugowoy.tasks.solutions.helper;

import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.utils.ReaderConsole;
import com.lugowoy.helper.utils.ReaderLengthArray;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

/**
 * <p>Created by Konstantin Lugowoy on 03.02.2020.
 *
 * @author Konstantin Lugowoy
 * @version 1.3
 */
//TODO write documentation
public class Helper {

    public static final String INPUT_LENGTH_ARRAY = "Enter length of the array : ";

    public static final String RESULT_MATRIX = "Result matrix : \n%s";
    public static final String RESULT_ARRAY = "Result array : \n%s";
    public static final String RESULT_SEQUENCE = "Result sequence : \n%s";

    public static final Reader CONSOLE_READER = new BufferedReader(
            new InputStreamReader(System.in));
    public static final Writer CONSOLE_WRITER = new BufferedWriter(
            new OutputStreamWriter(System.out));

    public static final Executor EXECUTOR = new Executor();

    public static int readConsoleArrayLength(final String msg,
                                             final int upperLength) {
        return ReaderLengthArray.read(new InputStreamReader(System.in),
                                      upperLength,
                                      new OutputStreamWriter(System.out), msg);
    }

    public static int readConsoleMatrixRows() {
        System.out.println("Enter rows count of the matrix : ");
        return new ReaderConsole().readInt();
    }

    public static int readConsoleMatrixColumns() {
        System.out.println("Enter columns count of the matrix : ");
        return new ReaderConsole().readInt();
    }

}
