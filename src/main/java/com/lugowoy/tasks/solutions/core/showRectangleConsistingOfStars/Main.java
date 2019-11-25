package com.lugowoy.tasks.showRectangleConsistingOfStars;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

/**
 * Show on the screen a rectangle with the size MxN, consisting of stars.
 * Then do the same, but that the figure inside was empty (only the frame remains).
 * <p>
 * Created by Konstantin Lugowoy on 25.10.2017.
 */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    public static void main(String[] args) {

        System.out.println("Enter parameter M for rectangle : ");
        int M = enterParam();

        System.out.println("Enter parameter N for rectangle : ");
        int N = enterParam();

        System.out.println("Rectangle filled with stars : ");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println("Rectangle in which the stars are filled with only the boundary : ");
        for (int i = 0; i <= M; i++) {
            for (int j = 0; j <= N; j++) {
                if ((j == 0 && i <= M) || (i == 0 && j <= N)
                        || (i <= M && j == N) || (i == M && j <= N)) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

    }

    private static int enterParam() {
        int param;
        while (true) {
            param = READER.readInt();
            if ((param >= 10) && (param <= 40)) {
                break;
            } else {
                System.out.println("Incorrect value of parameter. Must be integer number from 10 to 40.");
                System.out.println("Re-enter : ");
            }
        }
        return param;
    }

}
