package com.lugowoy.tasks.calculationOfAmountOfPaintNeededToPaintRoom.models;

/**
 * Created by LugowoyKonstantin on 18-Feb-17.
 */

public enum TypeOfPaint {
    TYPE_WATERBASED(0.15, 0.16, 0.17, 0.20, 0.18),
    TYPE_ENAMEL(0.12, 0.12, 0.13, 0.16, 0.15),
    TYPE_OIL(0.18, 0.19, 0.20, 0.21, 0.20),
    TYPE_SILICONE(0.8, 0.9, 0.9, 0.11, 0.10),
    TYPE_PLASTIC(0.8, 0.9, 0.9, 0.11, 0.10),
    TYPE_ACRYLIC(0.8, 0.9, 0.9, 0.11, 0.10),
    TYPE_LATEX(0.10, 0.10, 0.11, 0.13, 0.12),
    TYPE_ALKYD(0.11, 0.11, 0.12, 0.13, 0.12);

    private double expenseForMetalSurface;
    private double expenseForSmoothSurface;
    private double expenseForWoodSurface;
    private double expenseForPlasterSurface;
    private double expenseForGypsumPlasterboardSurface;

    TypeOfPaint(double expenseForMetalSurface, double expenseForSmoothSurface,
                double expenseForWoodSurface, double expenseForPlasterSurface,
                double expenseForGypsumPlasterboardSurface) {
        this.expenseForMetalSurface = expenseForMetalSurface;
        this.expenseForSmoothSurface = expenseForSmoothSurface;
        this.expenseForWoodSurface = expenseForWoodSurface;
        this.expenseForPlasterSurface = expenseForPlasterSurface;
        this.expenseForGypsumPlasterboardSurface = expenseForGypsumPlasterboardSurface;
    }

    public double getExpenseForMetalSurface() {
        return expenseForMetalSurface;
    }

    public void setExpenseForMetalSurface(double expenseForMetalSurface) {
        this.expenseForMetalSurface = expenseForMetalSurface;
    }

    public double getExpenseForSmoothSurface() {
        return expenseForSmoothSurface;
    }

    public void setExpenseForSmoothSurface(double expenseForSmoothSurface) {
        this.expenseForSmoothSurface = expenseForSmoothSurface;
    }

    public double getExpenseForWoodSurface() {
        return expenseForWoodSurface;
    }

    public void setExpenseForWoodSurface(double expenseForWoodSurface) {
        this.expenseForWoodSurface = expenseForWoodSurface;
    }

    public double getExpenseForPlasterSurface() {
        return expenseForPlasterSurface;
    }

    public void setExpenseForPlasterSurface(double expenseForPlasterSurface) {
        this.expenseForPlasterSurface = expenseForPlasterSurface;
    }

    public double getExpenseForGypsumPlasterboardSurface() {
        return expenseForGypsumPlasterboardSurface;
    }

    public void setExpenseForGypsumPlasterboardSurface(double expenseForGypsumPlasterboardSurface) {
        this.expenseForGypsumPlasterboardSurface = expenseForGypsumPlasterboardSurface;
    }

}
