package com.temperatureControl.handler;

import com.temperatureControl.handler.units.*;

public class UnitHandler {
    private final int CELSIUS = 0;
    private final int KELVIN = 1;
    private final int FAHRENHEIT = 2;

    private final String CEL = "Celsius";
    private final String KEL = "Kelvin";
    private final String FAH = "Fahrenheit";

    /**
     * Converts specified unit to specified unit
     *
     * @param toUnit unit of measure to convert to
     * @param fromUnit unit of measure to convert from
     * @param temperature value of unit to be converted
     * @return converted temperature
     */
    public double convert(int toUnit, int fromUnit, double temperature){
        switch(toUnit){
            case CELSIUS:
                Celsius celsius = new Celsius();
                return fromUnit == KELVIN ? celsius.ktoC(temperature) : celsius.ftoC(temperature);
            case KELVIN:
                Kelvin kelvin = new Kelvin();
                return fromUnit == FAHRENHEIT ? kelvin.ftoK(temperature) : kelvin.ctoK(temperature);
            case FAHRENHEIT:
                Fahrenheit fahrenheit = new Fahrenheit();
                return fromUnit == CELSIUS ? fahrenheit.cToF(temperature) : fahrenheit.kToF(temperature);
        }
        return 0.0;
    }

    public String[] toString(int toUnit){
        if (toUnit == CELSIUS) {
            return new String[]{"1: " + KEL, "2: " + FAH};
        }
        if (toUnit == KELVIN) {
            return new String[]{"0: " + CEL, "2: " + FAH};
        }
        if (toUnit == FAHRENHEIT) {
            return new String[]{"0: " + CEL, "1: " + KEL};
        }
        return new String[]{"ERROR"};
    }
}
