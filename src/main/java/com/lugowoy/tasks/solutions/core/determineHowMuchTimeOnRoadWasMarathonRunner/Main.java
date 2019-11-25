package com.lugowoy.tasks.determineHowMuchTimeOnRoadWasMarathonRunner;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

/**
 * The marathon runner has passed S kilometers with a speed of V meters per second (distance and speed are entered from the keyboard).
 * Determine how much time he was on the road (hours, minutes, seconds)?
 * <p>
 * Created by Konstantin Lugowoy on 23.03.2017.
 */

public class Main {

    private static final Reader reader = Reader.getReader(new ReadingConsole());

    private static final Determinant<Time, MarathonRunner> DETERMINANT =
                                                           Determinant::determineHowMuchTimeOnTheRoadWasMarathonRunner;

    public static void main(String[] args) {

        System.out.println("Input distance (kilometers) to marathon runner : ");
        double distance = reader.readDouble();

        System.out.println("Input speed (m/s) to marathon runner : ");
        double speed = reader.readDouble();

        MarathonRunner marathonRunner = new MarathonRunner(distance, speed);

        marathonRunner.setTime(DETERMINANT.determine(marathonRunner));

        System.out.printf("Time : %d hours, %d minutes, %d seconds .", marathonRunner.getTime().getHour(),
                                                                       marathonRunner.getTime().getMinutes(),
                                                                       marathonRunner.getTime().getSecond());

    }

}
