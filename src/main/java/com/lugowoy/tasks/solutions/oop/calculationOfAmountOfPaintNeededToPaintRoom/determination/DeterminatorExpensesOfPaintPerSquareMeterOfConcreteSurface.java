package com.lugowoy.tasks.calculationOfAmountOfPaintNeededToPaintRoom.determination;

import com.lugowoy.tasks.calculationOfAmountOfPaintNeededToPaintRoom.models.TypeOfPaint;
import com.lugowoy.tasks.calculationOfAmountOfPaintNeededToPaintRoom.models.TypeOfSurface;

import java.math.BigDecimal;

/**
 * Created by LugowoyKonstantin on 20-Feb-17.
 */

public class DeterminatorExpensesOfPaintPerSquareMeterOfConcreteSurface {

    public static BigDecimal determineExpenseOfPaintPerSquareMeterOfConcreteSurface(TypeOfSurface typeOfSurface, TypeOfPaint typeOfPaint) {
        BigDecimal expense = null;
        switch (typeOfPaint) {
            case TYPE_WATERBASED:
                expense = getExpenseOfPaintPerSquareMeterOfTheConcreteSurface(typeOfSurface, typeOfPaint);
                break;
            case TYPE_SILICONE:
                expense = getExpenseOfPaintPerSquareMeterOfTheConcreteSurface(typeOfSurface, typeOfPaint);
                break;
            case TYPE_PLASTIC:
                expense = getExpenseOfPaintPerSquareMeterOfTheConcreteSurface(typeOfSurface, typeOfPaint);
                break;
            case TYPE_OIL:
                expense = getExpenseOfPaintPerSquareMeterOfTheConcreteSurface(typeOfSurface, typeOfPaint);
                break;
            case TYPE_LATEX:
                expense = getExpenseOfPaintPerSquareMeterOfTheConcreteSurface(typeOfSurface, typeOfPaint);
                break;
            case TYPE_ENAMEL:
                expense = getExpenseOfPaintPerSquareMeterOfTheConcreteSurface(typeOfSurface, typeOfPaint);
                break;
            case TYPE_ALKYD:
                expense = getExpenseOfPaintPerSquareMeterOfTheConcreteSurface(typeOfSurface, typeOfPaint);
                break;
            case TYPE_ACRYLIC:
                expense = getExpenseOfPaintPerSquareMeterOfTheConcreteSurface(typeOfSurface, typeOfPaint);
                break;
        }
        return expense;
    }

    private static BigDecimal getExpenseOfPaintPerSquareMeterOfTheConcreteSurface(TypeOfSurface typeOfSurface, TypeOfPaint typeOfPaint) {
        BigDecimal expense = null;
        switch (typeOfSurface) {
            case TYPE_METAL_SURFACE:
                expense = new BigDecimal(typeOfPaint.getExpenseForMetalSurface());
                break;
            case TYPE_SMOOTH_SURFACE:
                expense = new BigDecimal(typeOfPaint.getExpenseForSmoothSurface());
                break;
            case TYPE_WOOD_SURFACE:
                expense = new BigDecimal(typeOfPaint.getExpenseForWoodSurface());
                break;
            case TYPE_PLASTER_SURFACE:
                expense = new BigDecimal(typeOfPaint.getExpenseForPlasterSurface());
                break;
            case TYPE_GYPSUM_PLASTERBOARD_SURFACE:
                expense = new BigDecimal(typeOfPaint.getExpenseForGypsumPlasterboardSurface());
                break;
        }
        return expense;
    }

}
