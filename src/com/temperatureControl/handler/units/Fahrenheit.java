package com.temperatureControl.handler.units;

public class Fahrenheit {

    /**
     * Convert Celsius to Fahrenheit
     *
     * @param degC degrees in celsius
     * @return degrees in fahrenheit
     */
    public double cToF(double degC) {
        return 32 + (1.8 * degC);
    }

    /**
     * Convert Kelvin to Fahrenheit
     *
     * @param degK degrees in kelvin
     * @return degrees in fahrenheit
     */
    public double kToF(double degK) {
        return (degK * (9 / 5)) - 459.67;
    }
}
