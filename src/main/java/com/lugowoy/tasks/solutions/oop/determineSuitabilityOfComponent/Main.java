package com.lugowoy.tasks.determineSuitabilityOfComponent;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.other.GeneratorRandomNumber;

import java.util.ArrayList;
import java.util.Collection;

/**
 * The suitability of the component is estimated by the size B, which must correspond to the interval (A - N, A + N).
 * Calculate the number of suitable and unusable components.
 * <p>
 * Created by Konstantin Lugowoy on 07.03.2017.
 */

public class Main {

    private static final Reader reader = Reader.getReader(new ReadingConsole());

    private static final int CAPACITY = 30;

    public static void main(String[] args) {

        System.out.println("Batch of component : ");
        BatchOfComponents batchOfComponents = new BatchOfComponents(fillBatchOfComponent());
        batchOfComponents.getComponentsCollection().forEach(System.out::println);

        System.out.println("Enter first interval :");
        int firstInterval = reader.readInt();
        System.out.println("Enter second interval : ");
        int secondInterval = reader.readInt();


        DeterminatorSuitabilityOfComponent determinatorSuitabilityOfComponent =
                                                  new DeterminatorSuitabilityOfComponent(firstInterval, secondInterval);

        determinatorSuitabilityOfComponent.determineSuitabilityOfComponent(batchOfComponents);

    }

    private static Collection<Component> fillBatchOfComponent() {
        ArrayList<Component> componentArrayList = new ArrayList<>(CAPACITY);
        for (int i = 0; i < 30; i++) {
            componentArrayList.add(new Component(GeneratorRandomNumber.generateInt()));
        }
        return componentArrayList;
    }

}
