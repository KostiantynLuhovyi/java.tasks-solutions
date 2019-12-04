package com.lugowoy.tasks.solutions.core.showIsoscelesTriangleFilledWithStars;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

/**
 * Show an isosceles triangle on the screen (the user enters the height).
 * Then do the same, but that the figure inside was empty (only the outline remains).
 * <p>
 * Created by Konstantin Lugowoy on 25.10.2017.
 */

public class Main {

    private static final Reader READER = new Reader(new ReadingConsole());

    public static void main(String[] args) {

        System.out.println("Enter height of isosceles triangle : ");
        int height = enterParam();

        System.out.println("Isosceles triangle filled with stars : ");
        int a = 0;
        int b = height - 1;
        int c = height + 1;

        for (int i = 0; i <= height; i++) {
            for (int j = 0; j <= height * 2; j++) {
                if (i == a && j > b && j < c) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            a++;
            b--;
            c++;
            System.out.println();
        }
        System.out.println();

        System.out.println("Isosceles triangle in which the stars are filled with only the boundary : ");
        a = 0;
        b = height;
        c = height;

        for (int i = 0; i <= height; i++) {
            for (int j = 0; j <= height * 2; j++) {

                if ((i == a && j == b) || (i == a && j == c) || (i == height && j <= height * 2)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            a++;
            b--;
            c++;
            System.out.println();
        }

    }

    private static int enterParam() {
        int param;
        while (true) {
            param = READER.readInt();
            if ((param >= 5) && (param <= 30)) {
                break;
            } else {
                System.out.println("Incorrect value of parameter. Must be integer number from 5 to 30.");
                System.out.println("Re-enter : ");
            }
        }
        return param;
    }

}
