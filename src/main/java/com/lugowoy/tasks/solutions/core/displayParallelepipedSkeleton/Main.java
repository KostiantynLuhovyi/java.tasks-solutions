package com.lugowoy.tasks.displayParallelepipedSkeleton;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

/**
 * Display the frame of a parallelepiped with the dimension AxBxC.
 * <p>
 * Created by Konstantin Lugowoy on 31.10.2017.
 */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    public static void main(String[] args) {

        System.out.println("Enter number A : ");
        int A = READER.readInt();

        System.out.println("Enter number B : ");
        int B = READER.readInt();

        System.out.println("Enter number C : ");
        int C = READER.readInt();

        displayParallelepipedSkeleton(A, B, C);

    }

    private static void displayParallelepipedSkeleton(int A, int B, int C) {
        for (int i = 0; i <= A; i++) {
            for (int j = 0; j <= B; j++) {
                if (i >= C && j == 0 || i == C && j <= B - C || i >= C
                        && j == B - C || i == A && j <= B - C) {
                    System.out.print("*");
                } else if (i <= A - C && j == C || i == 0 && j >= C || i <= A - C
                        && j == B || i == A - C && j >= C) {
                    System.out.print("*");
                } else if (i == A - j && j == A - i && i >= A - C) {
                    System.out.print("*");
                } else if (i == A - j - A - C && j == A - i - A - C) {
                    System.out.print("*");
                } else if (i == B - j + A - C && j == B - i + A - C) {
                    System.out.print("*");
                } else if (i == B - j && j == B - i && i <= A - C) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

}
