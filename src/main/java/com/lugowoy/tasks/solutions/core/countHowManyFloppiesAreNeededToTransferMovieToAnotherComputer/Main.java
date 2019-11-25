package com.lugowoy.tasks.countHowManyFloppiesAreNeededToTransferMovieToAnotherComputer;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

/**
 * The user enters from the keyboard the volume of one movie in gigabytes.
 * Count how many floppies are needed to transfer the movie to another computer (the size of the floppy disk is considered equal to 1.44 MB).
 * <p>
 * Created by Konstantin Lugowoy on 17.06.2017.
 */

public class Main {

    private static final Reader reader = Reader.getReader(new ReadingConsole());

    private static final double SIZE_OF_FLOPPY_DISK_IN_MB = 1.44;

    public static void main(String[] args) {

        double sizeMovieInTheGb = enterSizeMovieInTheGb();

        int numberOfFloppyNeedsToTransferMovie = (int) (sizeMovieInTheGb * 1024 / SIZE_OF_FLOPPY_DISK_IN_MB);

        System.out.printf("To transfer a movie to another computer, you need %d floppy disk.", numberOfFloppyNeedsToTransferMovie);

    }

    private static double enterSizeMovieInTheGb() {
        double sizeMovieInTheGb;
        System.out.println("Enter size movie in the gigabytes : ");
        sizeMovieInTheGb = reader.readDouble();
        while (true) {
            if (sizeMovieInTheGb > 0) {
                break;
            } else {
                System.out.println("Size movie must be a positive number.");
                System.out.println("Re-enter : ");
            }
        }
        return sizeMovieInTheGb;
    }

}
