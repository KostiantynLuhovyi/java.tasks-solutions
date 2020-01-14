package com.lugowoy.tasks.solutions.arrays.onedimensional.locateSnailOnTreeAfterThirtyDays;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.tasks.solutions.arrays.onedimensional.locateSnailOnTreeAfterThirtyDays.entity.Snail;
import com.lugowoy.tasks.solutions.arrays.onedimensional.locateSnailOnTreeAfterThirtyDays.entity.Tree;
import com.lugowoy.tasks.solutions.arrays.onedimensional.locateSnailOnTreeAfterThirtyDays.entity.Weather;
import com.lugowoy.tasks.solutions.arrays.onedimensional.locateSnailOnTreeAfterThirtyDays.entity.WeatherArray;

import java.util.Arrays;
import java.util.Random;

/**
 * Every sunny day, a snail sitting on a tree climbs up 2 cm, and each cloudy day drops down by 1 cm.
 * At the beginning of observation, the snail is A cm from the ground on a B-meter tree.
 * There is a 30-element array containing information about whether the corresponding observation day was cloudy or sunny.
 * Write a program that determines the location of the cochlea at the end of the 30th day of observation.
 * <p> Created by Konstantin Lugowoy on 11.05.2017.
 */
public class Main {

    private static final Reader READER = new Reader(new ReadingConsole());

    public static void main(String[] args) {

        System.out.println("Enter the height of the tree : ");
        Tree tree = new Tree(READER.readInt());

        System.out.println("Enter the starting location of a snail on the tree : ");
        Snail snail = new Snail(READER.readInt());

        tree.setSnail(snail);

        System.out.println("Enter the number of days of observation : ");
        WeatherArray weatherArray = new WeatherArray(READER.readInt());

        weatherArray.setWeathers(Arrays.stream(new Weather[weatherArray.getNumberOfDaysOfWeatherObservation()])
                                       .map(weather -> weather = new Weather())
                                       .toArray(Weather[]::new));

        fillWeatherCloudinessInTheWeatherArray(weatherArray);

        Determinant<Tree, WeatherArray> determinant = Determinant::determineSnailLocationOnTree;
        determinant.determine(tree, weatherArray);

    }

    private static void fillWeatherCloudinessInTheWeatherArray(WeatherArray weatherArray) {
        Random random = new Random();

        Arrays.stream(weatherArray.getWeathers()).forEachOrdered(weather -> {
            int tmp = random.nextInt();
            if (tmp > 0) {
                weather.setCloudiness(true);
            }
        });

    }

}
