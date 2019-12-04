package com.lugowoy.tasks.solutions.core.determineTimeForPersonToRetire;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

/**
 * Enter the keyboard sex and age of the person. Determine whether it's time for him to retire.
 * <p>
 * Created by Konstantin Lugowoy on 02.10.2017.
 */

public class Main {

    private static final Reader READER = new Reader(new ReadingConsole());

    private static final int AGE_MEN_FOR_RETIREMENT = 60;
    private static final int AGE_WOMAN_FOR_RETIREMENT = 55;

    public static void main(String[] args) {

        Person person = new Person(enterValueOfAgePerson(), enterValueOfGenderPerson());

        if (person.getGender() == Gender.MEN) {
            checkManRetire(person);
        } else if (person.getGender() == Gender.WOMAN) {
            checkWomanRetire(person);
        }

    }

    private static void checkWomanRetire(Person person) {
        if (person.getAge() == AGE_WOMAN_FOR_RETIREMENT) {
            System.out.println("It's time for a woman to retire.");
        } else if (person.getAge() < AGE_WOMAN_FOR_RETIREMENT) {
            int yearsBeforeRetirement = AGE_WOMAN_FOR_RETIREMENT - person.getAge();
            if (yearsBeforeRetirement == 1) {
                System.out.printf("Woman on retirement through %d year.", yearsBeforeRetirement);
            } else if (yearsBeforeRetirement > 1) {
                System.out.printf("Woman on retirement through %d years.", yearsBeforeRetirement);
            }
        }
    }

    private static void checkManRetire(Person person) {
        if (person.getAge() == AGE_MEN_FOR_RETIREMENT) {
            System.out.println("It's time for a man to retire.");
        } else if (person.getAge() < AGE_MEN_FOR_RETIREMENT) {
            int yearsBeforeRetirement = AGE_MEN_FOR_RETIREMENT - person.getAge();
            if (yearsBeforeRetirement == 1) {
                System.out.printf("Man on retirement through %d year.", yearsBeforeRetirement);
            } else if (yearsBeforeRetirement > 1) {
                System.out.printf("Man on retirement through %d years.", yearsBeforeRetirement);
            }
        }
    }

    private static Gender enterValueOfGenderPerson() {
        System.out.println("Select a person's gender.");
        System.out.println("Man : 0 ;");
        System.out.println("Woman : 1 ;");
        System.out.println("Select : ");
        Gender gender;
        while (true) {
            int valueSex = READER.readInt();
            if (valueSex == 0) {
                gender = Gender.MEN;
                break;
            } else if (valueSex == 1) {
                gender = Gender.WOMAN;
                break;
            } else {
                System.out.println("Incorrectly entered the value for choosing a person's gender.");
                System.out.println("Re-enter : ");
            }
        }
        return gender;
    }

    private static int enterValueOfAgePerson() {
        System.out.println("Enter the person's age : ");
        int age = READER.readInt();
        if (age > 60) {
            System.out.println("The man is already retired.");
            System.exit(0);
        }
        return age;
    }

}
