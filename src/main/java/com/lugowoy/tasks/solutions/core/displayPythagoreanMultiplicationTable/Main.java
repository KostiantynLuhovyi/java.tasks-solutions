package com.lugowoy.tasks.displayPythagoreanMultiplicationTable;

/**
 * Display the multiplication table (Pythagoras table).
 * <p>
 * Created by Konstantin Lugowoy on 25.10.2017.
 */

public class Main {

    public static void main(String[] args) {

        System.out.println("Pythagorean multiplication table : ");

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.printf("%4d", i * j);
            }
            System.out.println();
        }

    }

}
