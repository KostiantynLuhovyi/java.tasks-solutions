package com.lugowoy.tasks.convertKilometersToMilesOfSeaAndLand;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

/**
 * Write a program that converts kilometers to miles of land and sea.
 * <p>
 * Created by Konstantin Lugowoy on 31-Dec-16.
 */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    public static void main(String[] args) {

        System.out.println("Enter the number of kilometers for conversion : ");
        Length length = new Length();
        length.setKilometers(READER.readDouble());

        System.out.println("Convert entered number of kilometers, ");
        System.out.println("In nautical miles, enter : \"1\" .");
        System.out.println("In the statute miles, enter : \"2\" .");
        System.out.println("Nothing to convert, enter : \"3\" .");

        int selection = READER.readInt();

        if ((selection > 0) && (selection <= 3)) {
            Converting<Length> lengthConverting;
            switch (selection) {
                case 1:
                    lengthConverting = new ConvertingKilometersToMilesOfSea();
                    lengthConverting.convert(length);
                    System.out.printf("The result of the conversion of kilometers to nautical miles is %f", length.getMilesOfSea());
                    break;
                case 2:
                    lengthConverting = new ConvertingKilometersToMilesOfLand();
                    lengthConverting.convert(length);
                    System.out.printf("The result of the conversion of kilometers to miles of land is %f", length.getMilesOfLand());
                    break;
                case 3:
                    System.out.println("EXIT");
            }
        } else {
            System.out.println("Error when entering the action selection");
        }

    }

}
