package com.lugowoy.tasks.convertingDegreesTemperatures;

/**
 * Created by Konstantin Lugowoy on 11-Jan-17.
 */

public class ConvertingCelsiusTemperaturesToOther implements Converting<Temperature> {

    @Override
    public Temperature convert(final Temperature temperature, final TemperatureScale temperatureScale) {
        Temperature resultTemperature = null;
        if (temperature.getScale().equals(TemperatureScale.Celsius)) {
            switch (temperatureScale) {
                case Fahrenheit:
                    resultTemperature = new Temperature();
                    resultTemperature.setDegreesTemperatures((temperature.getDegreesTemperatures() * 9 / 5) + 32);
                    resultTemperature.setScale(TemperatureScale.Fahrenheit);
                    break;
                case Kelvin:
                    resultTemperature = new Temperature();
                    resultTemperature.setDegreesTemperatures(temperature.getDegreesTemperatures() + 273.15);
                    resultTemperature.setScale(TemperatureScale.Kelvin);
                    break;
                case Reaumur:
                    resultTemperature = new Temperature();
                    resultTemperature.setDegreesTemperatures(temperature.getDegreesTemperatures() * 4 / 5);
                    resultTemperature.setScale(TemperatureScale.Reaumur);
                    break;
                case Delisle:
                    resultTemperature = new Temperature();
                    resultTemperature.setDegreesTemperatures((100 - temperature.getDegreesTemperatures()) * 3 / 2);
                    resultTemperature.setScale(TemperatureScale.Delisle);
                    break;
            }
        }
        return resultTemperature;
    }

}
