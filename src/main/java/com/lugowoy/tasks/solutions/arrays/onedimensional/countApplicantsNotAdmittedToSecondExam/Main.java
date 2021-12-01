package com.lugowoy.tasks.solutions.arrays.onedimensional.countApplicantsNotAdmittedToSecondExam;

import java.util.Arrays;
import java.util.Random;

/**
 * On admission to university entrants who have received "two" in the first
 * exam, the second is not allowed. The array A[n] written assessment exams
 * obtained in the first test. Calculate how much a person is not admitted to
 * the second exam.
 *
 * <p>Created by Konstantin Lugowoy on 23-Feb-17.
 */
public class Main {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {

        Applicant[] applicantsArray = Arrays.stream(new Applicant[20]).map(
                applicant -> new Applicant(RANDOM.nextInt(5) - 1 + 1 + 1))
                                            .toArray(Applicant[]::new);

        System.out.println("Array of applicants : ");
        Arrays.stream(applicantsArray).forEachOrdered(System.out::println);
        System.out.println();

        System.out.print("The number of applicants not admitted to exam : ");
        System.out.println(Arrays.stream(applicantsArray)
                                 .filter(applicant -> applicant.getRating() == 1
                                                      || applicant.getRating() == 2).count());
    }

}
