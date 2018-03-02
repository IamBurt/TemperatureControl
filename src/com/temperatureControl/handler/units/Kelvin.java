package com.temperatureControl.handler.units;

public class Kelvin {

    /**
     * Convert Fahrenheit to Kelvin
     *
     * @param degF degrees in fahrenheit
     * @return degrees in kelvin
     */
    public double ftoK(double degF){
        return ((degF - 32) / 1.80) + 273.15;
    }

    /**
     * Convert Celsius to Kelvin
     *
     * @param degC degrees in celsius
     * @return degrees in kelvin
     */
    public double ctoK(double degC){
        return degC + 273.15;
    }
}
