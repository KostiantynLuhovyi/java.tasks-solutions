package com.lugowoy.tasks.calculationOfVariousDataAboutPlanetsOfSolarSystem.model;

import com.rits.cloning.Cloner;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created by LugowoyKonstantin on 07.03.2017.
 */

public class Planet implements Serializable, Cloneable {

    private String namePlanet;

    private BigDecimal massPlanet;

    public Planet() {
    }

    public Planet(String namePlanet, BigDecimal massPlanet) {
        this.namePlanet = namePlanet;
        this.massPlanet = massPlanet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Planet)) return false;
        Planet planet = (Planet) o;
        return Objects.equals(getNamePlanet(), planet.getNamePlanet()) &&
                Objects.equals(getMassPlanet(), planet.getMassPlanet());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNamePlanet(), getMassPlanet());
    }

    @Override
    public String toString() {
        return "Planet[" +
                "namePlanet='" + namePlanet + '\'' +
                ", massPlanet=" + massPlanet +
                ']';
    }

    @Override
    public Planet clone() {
        Planet planet = new Planet();
        Cloner cloner = new Cloner();
        try {
            planet = (Planet) super.clone();
            planet.setNamePlanet(cloner.deepClone(this.getNamePlanet()));
            planet.setMassPlanet(cloner.deepClone(this.getMassPlanet()));
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return planet;
    }

    public String getNamePlanet() {
        return namePlanet;
    }

    public void setNamePlanet(String namePlanet) {
        this.namePlanet = namePlanet;
    }

    public BigDecimal getMassPlanet() {
        return massPlanet;
    }

    public void setMassPlanet(BigDecimal massPlanet) {
        this.massPlanet = massPlanet;
    }

}
