package com.lugowoy.tasks.solutions.core.calculateHowManyMoviesWillFitOnUSBFlashDrive;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

/**
 * The user enters from the keyboard the volume of the USB flash drive in gigabytes.
 * Calculate how much it will fit the size of films entered by the user.
 * <p>
 * Created by Konstantin Lugowoy on 16.06.2017.
 */

public class Main {

    private static final Reader READER = new Reader(new ReadingConsole());

    private static final String NAME_MOVIE = "Terminator";

    public static void main(String[] args) {

        FlashDriveUSB driveUSB = new FlashDriveUSB(enterSizeFlashDriveUSB());

        Movie movie = new Movie(NAME_MOVIE, enterSizeMovie());

        System.out.println("Number movie on the flash drive USB : " + calculateNumberOfMovieOnFlashDriveUSB(driveUSB, movie));

    }

    private static int calculateNumberOfMovieOnFlashDriveUSB(FlashDriveUSB driveUSB, Movie movie) {
        return (int) (driveUSB.getSizeFlashDriveUSB() * 1024 / movie.getSizeMovie());
    }

    private static double enterSizeFlashDriveUSB() {
        double sizeFlashDriveUSB;
        System.out.println("Enter the size of the flash drive USB : ");
        while (true) {
            sizeFlashDriveUSB = READER.readDouble();
            if (sizeFlashDriveUSB > 0) {
                break;
            } else {
                System.out.println("The size of the usb flash drive USB must be a positive number.");
                System.out.println("Re-enter : ");
            }
        }
        return sizeFlashDriveUSB;
    }

    private static double enterSizeMovie() {
        double sizeMovie;
        System.out.println("Enter the size (Mb) of the movie : ");
        while (true) {
            sizeMovie = READER.readDouble();
            if (sizeMovie > 0) {
                break;
            } else {
                System.out.println("The size of the movie must be a positive number.");
                System.out.println("Re-enter : ");
            }
        }
        return sizeMovie;
    }

}
