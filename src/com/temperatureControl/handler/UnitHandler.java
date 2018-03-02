package com.temperatureControl.handler;

import com.temperatureControl.handler.units.*;

import java.util.TreeMap;

public class UnitHandler {

    private final int CEL = 0;
    private final int KEL = 1;
    private final int FAH = 2;

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
            case CEL:
                Celsius celsius = new Celsius();
                return fromUnit == KEL ? celsius.ktoC(temperature) : celsius.ftoC(temperature);
            case KEL:
                Kelvin kelvin = new Kelvin();
                return fromUnit == FAH ? kelvin.ftoK(temperature) : kelvin.ctoK(temperature);
            case FAH:
                Fahrenheit fahrenheit = new Fahrenheit();
                return fromUnit == CEL ? fahrenheit.cToF(temperature) : fahrenheit.kToF(temperature);
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

        celMap.put(KEL, "Kelvin");
        celMap.put(FAH, "Fahrenheit");

        kelMap.put(CEL, "Celsius");
        kelMap.put(FAH, "Fahrenheit");

        fahMap.put(CEL, "Celsius");
        fahMap.put(KEL, "Kelvin");

        treeMap.put(CEL, celMap);
        treeMap.put(KEL, kelMap);
        treeMap.put(FAH, fahMap);

        return treeMap;
    }
}
