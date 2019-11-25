package com.lugowoy.tasks.determineWhichResistorToUseSoThatTotalResistanceOfCircuitIsMinimal;

/**
 * Created by Konstantin Lugowoy on 10.11.2017.
 */

@FunctionalInterface
public interface Calculator {

    double calculate(Resistor mainResistor, Resistor firstResistor, Resistor secondResistor, Resistor thirdResistor);

    static double calculationOfResistanceOfCircuitForFirstConnectionMethods(Resistor mainResistor, Resistor firstResistor,
                                                                            Resistor secondResistor, Resistor thirdResistor) {
        return secondResistor.getResistance() * thirdResistor.getResistance()
                        / (secondResistor.getResistance() + thirdResistor.getResistance())
                +
                firstResistor.getResistance() * mainResistor.getResistance()
                        / (firstResistor.getResistance() + mainResistor.getResistance());
    }

    static double calculationOfResistanceOfCircuitForSecondConnectionMethods(Resistor mainResistor, Resistor firstResistor,
                                                                             Resistor secondResistor, Resistor thirdResistor) {
        return firstResistor.getResistance() * thirdResistor.getResistance()
                        / (firstResistor.getResistance() + thirdResistor.getResistance())
                +
                secondResistor.getResistance() * mainResistor.getResistance()
                        / (secondResistor.getResistance() + mainResistor.getResistance());
    }

    static double calculationOfResistanceOfCircuitForThirdConnectionMethods(Resistor mainResistor, Resistor firstResistor,
                                                                            Resistor secondResistor, Resistor thirdResistor) {
        return secondResistor.getResistance() * firstResistor.getResistance()
                        / (secondResistor.getResistance() + firstResistor.getResistance())
                +
                thirdResistor.getResistance() * mainResistor.getResistance()
                        / (thirdResistor.getResistance() + mainResistor.getResistance());
    }

}
