package com.lugowoy.tasks.determineWhichResistorToUseSoThatTotalResistanceOfCircuitIsMinimal;

/**
 * Created by Konstantin Lugowoy on 10.11.2017.
 */

@FunctionalInterface
public interface Determinant {

    boolean determineMethodOfConnection(double firstValueOfChainSection,
                                        double secondValueOfChainSection,
                                        double thirdValueOfChainSection);

    static boolean determineFirstVariantOfMethodConnection(double firstValueOfChainSection,
                                                           double secondValueOfChainSection,
                                                           double thirdValueOfChainSection) {
        return (firstValueOfChainSection <= secondValueOfChainSection) && (firstValueOfChainSection <= thirdValueOfChainSection);
    }

    static boolean determineSecondVariantOfMethodConnection(double firstValueOfChainSection,
                                                            double secondValueOfChainSection,
                                                            double thirdValueOfChainSection) {
        return (secondValueOfChainSection <= firstValueOfChainSection) && (secondValueOfChainSection <= thirdValueOfChainSection);
    }

}
