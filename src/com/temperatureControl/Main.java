package com.temperatureControl;

import com.temperatureControl.handler.UnitHandler;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static UnitHandler handler = new UnitHandler();

    private static final String[] unit = {"Celsius", "Kelvin", "Fahrenheit"};

    private static double degrees;

    public static void main(String[] args) {
        int firstUnitType = 0, secondUnitType, tmpNum;

        while (firstUnitType != -1) {
            //Starts conversation with user and asks for their input
            System.out.println("\nWhat unit of temperature will you be inputting?");
            System.out.print("0: Celsius 1: Kelvin 2: Fahrenheit(-1: Exit): ");
            firstUnitType = scanner.nextInt();
            //Check if user input is between specified values
            if (firstUnitType != -1 && firstUnitType >= 0 && firstUnitType <= 2) {
                int firstKey = handler.myMap().get(firstUnitType).firstKey();
                int lastKey = handler.myMap().get(firstUnitType).lastKey();
                //Asks user the second question and asks for their input
                System.out.println("\nWhat would you like to convert to?");
                System.out.print(firstKey + ": " + handler.myMap().get(firstUnitType).get(firstKey) + " "
                        + lastKey + ": " + handler.myMap().get(firstUnitType).get(lastKey) + ": ");
                secondUnitType = scanner.nextInt();
                //Check if user input is between specified value
                System.out.print("\nEnter the degrees in " + unit[firstUnitType] + ": ");
                if (secondUnitType >= 1 && secondUnitType <= 3) {
                    degrees = scanner.nextDouble();
                    tmpNum = secondUnitType == firstKey ? 0 : 1;
                    double converted = handler.convert(handler.myMap()
                            .get(firstUnitType).keySet().toArray()[1].hashCode(), firstUnitType, degrees);
                    Object convertedName = handler.myMap().get(firstUnitType).values().toArray()[tmpNum];
                    System.out.printf(degrees + " " + unit[firstUnitType] + " is: %.2f "
                            + convertedName + "\n", converted);
                }
            } else {
                System.out.println("\nInvalid input, please enter a different number.");
            }
        }
    }
}
