package com.lugowoy.tasks.solutions.arrays.onedimensional.countingNumberOfPeopleWhoseAgeIsInGivenInterval;

import com.lugowoy.helper.utils.ReaderConsole;

import java.util.Arrays;
import java.util.Random;

/**
 * Write a program whose input is the age of n people.
 * The program counting the number of people whose age is in the specified interval.
 *
 * <p>Created by Konstantin Lugowoy on 14.05.2017.
 */
public class Main {

    private static final ReaderConsole READER_CONSOLE = new ReaderConsole();
    private static final Random RANDOM_AGE = new Random();

    public static void main(String[] args) {

        ArrayOfHumans humans = getArrayOfHumans();

        int startAgeInterval = enterStartAgeInterval();

        int finishAgeInterval = enterFinishAgeInterval();

        showHumans(humans);

        Counting counting = Counting::countNumberOfPeopleWithAgeInGivenInterval;
        counting.counting(humans, startAgeInterval, finishAgeInterval);

    }

    public static int enterFinishAgeInterval() {
        System.out.println("Enter finish age interval : ");
        int finishAgeInterval;
        while(true) {
            finishAgeInterval = READER_CONSOLE.readInt();
            if ((finishAgeInterval > 0) && (finishAgeInterval <= 150)) {
                break;
            } else {
                System.out.println("Not correct value of finish age interval. Re-enter : ");
            }
        }
        return finishAgeInterval;
    }

    public static int enterStartAgeInterval() {
        System.out.println("Enter start age interval : ");
        int startAgeInterval;
        while(true) {
            startAgeInterval = READER_CONSOLE.readInt();
            if ((startAgeInterval >= 0 ) && (startAgeInterval <= 140)) {
                break;
            } else {
                System.out.println("Not correct value of start age interval. Re-enter : ");
            }
        }
        return startAgeInterval;
    }

    public static ArrayOfHumans getArrayOfHumans() {
        ArrayOfHumans humans;
        System.out.println("Enter the number of people to count : ");
        while(true) {
            int numberOfPeople = READER_CONSOLE.readInt();
            if (numberOfPeople > 0) {
                humans = createArrayOfHumans(numberOfPeople);
                break;
            } else {
                System.out.println("The number of people for counting is less than or equal to zero. Re-enter : ");
            }
        }
        return humans;
    }

    private static ArrayOfHumans createArrayOfHumans(int quantityHumans) {
        ArrayOfHumans arrayOfHumans = new ArrayOfHumans();
        arrayOfHumans.setHumans(new Human[quantityHumans]);
        for (int i = 0; i < arrayOfHumans.getHumans().length; i++) {
            arrayOfHumans.getHumans()[i] = new Human();
            arrayOfHumans.getHumans()[i].setAge(RANDOM_AGE.nextInt(130));
        }
        return arrayOfHumans;
    }

    private static void showHumans(ArrayOfHumans arrayOfHumans) {
        System.out.println();
        Arrays.stream(arrayOfHumans.getHumans()).forEach(System.out::println);
        System.out.println();
    }

}
