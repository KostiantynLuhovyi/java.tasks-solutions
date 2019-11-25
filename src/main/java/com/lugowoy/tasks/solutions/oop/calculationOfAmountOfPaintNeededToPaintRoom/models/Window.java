package com.lugowoy.tasks.calculationOfAmountOfPaintNeededToPaintRoom.models;

import com.rits.cloning.Cloner;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by LugowoyKonstantin on 17-Feb-17.
 */

public class Window implements Serializable, Cloneable {

    private BigDecimal widthWindow;
    private BigDecimal heightWindow;

    private BigDecimal areaWindow;

    public Window() {
    }

    public Window(BigDecimal widthWindow, BigDecimal heightWindow) {
        this.widthWindow = widthWindow;
        this.heightWindow = heightWindow;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Window)) return false;

        Window window = (Window) o;

        if (getWidthWindow() != null ? !getWidthWindow().equals(window.getWidthWindow()) : window.getWidthWindow() != null)
            return false;
        if (getHeightWindow() != null ? !getHeightWindow().equals(window.getHeightWindow()) : window.getHeightWindow() != null)
            return false;
        return getAreaWindow() != null ? getAreaWindow().equals(window.getAreaWindow()) : window.getAreaWindow() == null;

    }

    @Override
    public int hashCode() {
        int result = getWidthWindow() != null ? getWidthWindow().hashCode() : 0;
        result = 31 * result + (getHeightWindow() != null ? getHeightWindow().hashCode() : 0);
        result = 31 * result + (getAreaWindow() != null ? getAreaWindow().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Window[" +
                "widthWindow=" + widthWindow +
                ", heightWindow=" + heightWindow +
                ", areaWindow=" + areaWindow +
                ']';
    }

    @Override
    public Window clone() {
        Window window = new Window();
        Cloner cloner = new Cloner();
        try {
            window = (Window) super.clone();
            window.setWidthWindow(cloner.deepClone(this.getWidthWindow()));
            window.setHeightWindow(cloner.deepClone(this.getHeightWindow()));
            window.setAreaWindow(cloner.deepClone(this.getAreaWindow()));
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return window;
    }

    public BigDecimal getWidthWindow() {
        return widthWindow;
    }

    public void setWidthWindow(BigDecimal widthWindow) {
        this.widthWindow = widthWindow;
    }

    public BigDecimal getHeightWindow() {
        return heightWindow;
    }

    public void setHeightWindow(BigDecimal heightWindow) {
        this.heightWindow = heightWindow;
    }

    public BigDecimal getAreaWindow() {
        return areaWindow;
    }

    public void setAreaWindow(BigDecimal areaWindow) {
        this.areaWindow = areaWindow;
    }

}
