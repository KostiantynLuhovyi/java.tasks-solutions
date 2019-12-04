package com.lugowoy.tasks.solutions.core.determineHowMuchTimeOnRoadWasMarathonRunner;

/**
 * Created by Konstantin Lugowoy on 23.03.2017.
 */

@FunctionalInterface
public interface Determinant<T, V> {

    T determine(V v);

    static Time determineHowMuchTimeOnTheRoadWasMarathonRunner(MarathonRunner marathonRunner) {
        double time = (marathonRunner.getDistance() * 1000) / marathonRunner.getSpeed();
        double hour = (int) time / 3600;
        double minutes = (int) (time / 60 - hour * 60);
        double second = time - (int) (hour * 3600 + minutes * 60);

        return new Time((int) hour, (int) minutes, (int) second);
    }

}
