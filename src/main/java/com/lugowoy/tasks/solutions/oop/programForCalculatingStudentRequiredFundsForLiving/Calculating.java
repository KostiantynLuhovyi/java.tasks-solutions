package com.lugowoy.tasks.programForCalculatingStudentRequiredFundsForLiving;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.lugowoy.tasks.programForCalculatingStudentRequiredFundsForLiving.PlaceOfResidence.PERCENTAGE_OF_MONTHLY_INCREASE_IN_COST_OF_LIVING;

/**
 * Created by LugowoyKonstantin on 02.11.2017.
 */

@FunctionalInterface
public interface Calculating {

    BigDecimal calculate(Student student, PlaceOfResidence placeOfResidence);

    static BigDecimal calculatingAmountOfMoneyThatIsNotEnoughToPayForLiving(Student student, PlaceOfResidence placeOfResidence) {
        BigDecimal result = new BigDecimal(0);
        if (student.getStipend().getAmountOfStipend().doubleValue() < placeOfResidence.getCostPlaceOfResidence().doubleValue()) {
            BigDecimal totalAmountOfMoneyForAllMonthsOfResidence = getSumOfPlaceOfResidenceFromPeriodLiving(placeOfResidence);
            BigDecimal totalAmountOfMoneyForAllMonthOfStipend = student.getStipend().getAmountOfStipend().multiply(new BigDecimal(placeOfResidence.getNumberOfMonthsToStay()));
            result = totalAmountOfMoneyForAllMonthsOfResidence.subtract(totalAmountOfMoneyForAllMonthOfStipend);
        }
        return result;

    }

    static BigDecimal getSumOfPlaceOfResidenceFromPeriodLiving(PlaceOfResidence placeOfResidence) {
        BigDecimal totalAmountOfMoneyForAllMonthsOfResidence = placeOfResidence.getCostPlaceOfResidence();
        BigDecimal percentageOfMonthlyIncreaseInCostOfLiving = PERCENTAGE_OF_MONTHLY_INCREASE_IN_COST_OF_LIVING;
        for (int i = 1; i <= 10; i++) {
            double differentPercentageOfAmount = placeOfResidence.getCostPlaceOfResidence().multiply(percentageOfMonthlyIncreaseInCostOfLiving)
                    .divide(new BigDecimal(100), RoundingMode.HALF_DOWN)
                    .doubleValue();
            totalAmountOfMoneyForAllMonthsOfResidence = totalAmountOfMoneyForAllMonthsOfResidence.add(placeOfResidence.getCostPlaceOfResidence()
                    .add(new BigDecimal(differentPercentageOfAmount)));
            percentageOfMonthlyIncreaseInCostOfLiving = percentageOfMonthlyIncreaseInCostOfLiving.add(new BigDecimal(3));
        }
        return totalAmountOfMoneyForAllMonthsOfResidence;
    }

}
