package com.temperatureControl.handler.units;

public class Celsius {

    /**
     * Convert Fahrenheit to Celsius
     *
     * @param degF degrees in Fahrenheit
     * @return degrees in celsius
     */
    public double ftoC(double degF) {
        return (degF - 32) / 1.8;
    }

    /**
     * Convert Kelvin to Celsius
     *
     * @param degK degrees in kelvin
     * @return degrees in celsius
     */
    public double ktoC(double degK) {
        return degK - 273.15;
    }
}
