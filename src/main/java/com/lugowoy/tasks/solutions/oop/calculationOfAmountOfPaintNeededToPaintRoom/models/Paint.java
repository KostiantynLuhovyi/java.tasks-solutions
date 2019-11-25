package com.lugowoy.tasks.calculationOfAmountOfPaintNeededToPaintRoom.models;

import com.rits.cloning.Cloner;

import java.awt.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by LugowoyKonstantin on 17-Feb-17.
 */

public class Paint implements Serializable, Cloneable {

    private BigDecimal pricePerLiter;

    private Color colorPaint;

    private TypeOfPaint typeOfPaint;
    private BigDecimal expenseOfPaintPerSquareMeter;

    public Paint() {
    }

    public Paint(BigDecimal pricePerLiter, TypeOfPaint typeOfPaint) {
        this.pricePerLiter = pricePerLiter;
        this.typeOfPaint = typeOfPaint;
    }

    public Paint(BigDecimal pricePerLiter, Color colorPaint, TypeOfPaint typeOfPaint) {
        this.pricePerLiter = pricePerLiter;
        this.colorPaint = colorPaint;
        this.typeOfPaint = typeOfPaint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Paint)) return false;

        Paint paint = (Paint) o;

        if (getPricePerLiter() != null ? !getPricePerLiter().equals(paint.getPricePerLiter()) : paint.getPricePerLiter() != null)
            return false;
        if (getColorPaint() != null ? !getColorPaint().equals(paint.getColorPaint()) : paint.getColorPaint() != null)
            return false;
        if (getTypeOfPaint() != paint.getTypeOfPaint()) return false;
        return getExpenseOfPaintPerSquareMeter() != null ? getExpenseOfPaintPerSquareMeter().equals(paint.getExpenseOfPaintPerSquareMeter()) : paint.getExpenseOfPaintPerSquareMeter() == null;

    }

    @Override
    public int hashCode() {
        int result = getPricePerLiter() != null ? getPricePerLiter().hashCode() : 0;
        result = 31 * result + (getColorPaint() != null ? getColorPaint().hashCode() : 0);
        result = 31 * result + (getTypeOfPaint() != null ? getTypeOfPaint().hashCode() : 0);
        result = 31 * result + (getExpenseOfPaintPerSquareMeter() != null ? getExpenseOfPaintPerSquareMeter().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Paint[" +
                "pricePerLiter=" + pricePerLiter +
                ", colorPaint=" + colorPaint +
                ", typeOfPaint=" + typeOfPaint +
                ", expenseOfPaintPerSquareMeter=" + expenseOfPaintPerSquareMeter +
                ']';
    }

    @Override
    public Paint clone() {
        Paint paint = new Paint();
        Cloner cloner = new Cloner();
        try {
            paint = (Paint) super.clone();
            paint.setPricePerLiter(cloner.deepClone(this.getPricePerLiter()));
            paint.setColorPaint(cloner.deepClone(this.getColorPaint()));
            paint.setTypeOfPaint(this.getTypeOfPaint());//Enum is a singleton, so refers to the same instance.
            paint.setExpenseOfPaintPerSquareMeter(cloner.deepClone(this.getExpenseOfPaintPerSquareMeter()));
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return paint;
    }

    public BigDecimal getPricePerLiter() {
        return pricePerLiter;
    }

    public void setPricePerLiter(BigDecimal pricePerLiter) {
        this.pricePerLiter = pricePerLiter;
    }

    public Color getColorPaint() {
        return colorPaint;
    }

    public void setColorPaint(Color colorPaint) {
        this.colorPaint = colorPaint;
    }

    public TypeOfPaint getTypeOfPaint() {
        return typeOfPaint;
    }

    public void setTypeOfPaint(TypeOfPaint typeOfPaint) {
        this.typeOfPaint = typeOfPaint;
    }

    public BigDecimal getExpenseOfPaintPerSquareMeter() {
        return expenseOfPaintPerSquareMeter;
    }

    public void setExpenseOfPaintPerSquareMeter(BigDecimal expenseOfPaintPerSquareMeter) {
        this.expenseOfPaintPerSquareMeter = expenseOfPaintPerSquareMeter;
    }

}
