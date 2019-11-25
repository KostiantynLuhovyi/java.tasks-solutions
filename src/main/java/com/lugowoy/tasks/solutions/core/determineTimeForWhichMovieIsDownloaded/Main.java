package com.lugowoy.tasks.determineTimeForWhichMovieIsDownloaded;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

/**
 * The user enters from the keyboard the size of one movie in gigabytes (real value) and the speed of the internet connection in bits per second.
 * Determine for what time (hours, minutes and seconds) the movie is downloaded.
 * <p>
 * Created by Konstantin Lugowoy on 16.06.2017.
 */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    private static final double BITS_IN_GB = 8590e+6;

    private static final String NAME_MOVIE = "Terminator";

    public static void main(String[] args) {

        Movie movie = new Movie(NAME_MOVIE, enterSizeFilmInGb());
        System.out.println(movie);

        double speedInternetConnection = enterSpeedInternetConnection();

        long secondsForCalculationTimeOfDownloadMovie = (long) (movie.getSizeMovieInGb() / speedInternetConnection * BITS_IN_GB);

        long hours = secondsForCalculationTimeOfDownloadMovie / 3600;
        long minutes = secondsForCalculationTimeOfDownloadMovie / 60 % 60;
        long seconds = secondsForCalculationTimeOfDownloadMovie % 60;

        System.out.printf("Downloading the movie will last : %d hours, %d minutes, %d seconds.", hours, minutes, seconds);

    }

    private static double enterSizeFilmInGb() {
        System.out.println("Enter size film in the Gb : ");
        double sizeFilm;
        while (true) {
            sizeFilm = READER.readDouble();
            if (sizeFilm > 0) {
                break;
            } else {
                System.out.println("Size film must be a positive real number.");
                System.out.println("Re-enter : ");
            }
        }
        return sizeFilm;
    }

    private static double enterSpeedInternetConnection() {
        System.out.println("Enter speed(bits/second) internet connection : ");
        double speedInternetConnection;
        while (true) {
            speedInternetConnection = READER.readDouble();
            if (speedInternetConnection > 0) {
                break;
            } else {
                System.out.println("Speed internet connection must be a positive real number : ");
                System.out.println("Re-enter : ");
            }
        }
        return speedInternetConnection;
    }

}
