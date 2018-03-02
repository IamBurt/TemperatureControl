package com.temperatureControl.handler;

import com.temperatureControl.handler.units.*;

import java.util.TreeMap;

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
     * @param toUnit      unit of measure to convert to
     * @param fromUnit    unit of measure to convert from
     * @param temperature value of unit to be converted
     * @return converted temperature
     */
    public double convert(int toUnit, int fromUnit, double temperature) {
        switch (toUnit) {
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

    /**
     * Sets up TreeMap for specified values
     *
     * @return the inputted values
     */
    public TreeMap<Integer, TreeMap<Integer, String>> myMap() {

        TreeMap<Integer, TreeMap<Integer, String>> treeMap = new TreeMap<Integer, TreeMap<Integer, String>>();

        TreeMap<Integer, String> celMap = new TreeMap<Integer, String>();
        TreeMap<Integer, String> kelMap = new TreeMap<Integer, String>();
        TreeMap<Integer, String> fahMap = new TreeMap<Integer, String>();

        celMap.put(1, KEL);
        celMap.put(2, FAH);

        kelMap.put(0, CEL);
        kelMap.put(2, FAH);

        fahMap.put(0, CEL);
        fahMap.put(1, KEL);

        treeMap.put(CELSIUS, celMap);
        treeMap.put(KELVIN, kelMap);
        treeMap.put(FAHRENHEIT, fahMap);

        return treeMap;
    }
}
