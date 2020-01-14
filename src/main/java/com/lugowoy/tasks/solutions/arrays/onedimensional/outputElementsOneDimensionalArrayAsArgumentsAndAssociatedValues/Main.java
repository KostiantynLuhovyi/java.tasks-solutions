package com.lugowoy.tasks.solutions.arrays.onedimensional.outputElementsOneDimensionalArrayAsArgumentsAndAssociatedValues;

import java.util.Arrays;
import java.util.Random;

/**
 * In the one-dimensional array are placed: in the first elements of the value of the argument,
 * in the following - the corresponding values of the function.
 * Print the elements of array n parallel columns (argument and function value).
 * <p> Created by Konstantin Lugowoy on 23-Feb-17.
 */
public class Main {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {

        String[] strings = Arrays.stream(new String[20])
                .map(s -> s = "Arg")
                .toArray(String[]::new);

        Integer[] integers = Arrays.stream(new Integer[20])
                .mapToInt(value -> RANDOM.nextInt(50))
                .boxed()
                .toArray(Integer[]::new);

        Object[] objects = new Object[strings.length + integers.length];
        System.arraycopy(strings, 0, objects, 0, strings.length);
        System.arraycopy(integers, 0, objects, strings.length, integers.length);

        Outputting<String, Integer> outputting = associativeArray -> {
            int j = associativeArray.getAssociativeArray().length / 2;
            for (int i = 0; i < associativeArray.getAssociativeArray().length / 2; i++) {
                for (; j < associativeArray.getAssociativeArray().length; j++) {
                    System.out.println(associativeArray.getAssociativeArray()[i] + " : "
                            + associativeArray.getAssociativeArray()[j]);
                }
            }
        };

        outputting.output(new AssociativeArray<>(objects));

    }
}
