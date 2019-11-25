package com.lugowoy.tasks.determineSuitabilityOfComponent;

/**
 * Created by LugowoyKonstantin on 07.03.2017.
 */

public class DeterminatorSuitabilityOfComponent {

    private final int firstInterval, secondInterval;

    public DeterminatorSuitabilityOfComponent(int firstInterval, int secondInterval) {
        this.firstInterval = firstInterval;
        this.secondInterval = secondInterval;
    }

    public void determineSuitabilityOfComponent(BatchOfComponents batchOfComponents) {
        int resultSuitabilityOfComponent = 0;
        int resultNotSuitabilityOfComponent = 0;

        for (Component component : batchOfComponents.getComponentsCollection()) {
            if ((component.getSize() > (this.firstInterval - this.secondInterval))
                    && (component.getSize() < (this.firstInterval + this.secondInterval))) {
                resultSuitabilityOfComponent++;
            } else {
                resultNotSuitabilityOfComponent++;
            }
        }
        System.out.printf("The number of suitable component : %d , not suitable : %d",
                                                         resultSuitabilityOfComponent, resultNotSuitabilityOfComponent);
    }

    public int getFirstInterval() {
        return firstInterval;
    }

    public int getSecondInterval() {
        return secondInterval;
    }

}
