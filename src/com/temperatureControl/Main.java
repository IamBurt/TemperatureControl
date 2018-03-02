package com.temperatureControl;

import com.temperatureControl.handler.UnitHandler;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);    //used to collect user input
    private static UnitHandler handler = new UnitHandler();     //object of handler class

    private static final String[] unit = {"Celsius", "Kelvin", "Fahrenheit"};

    private static double degrees;  //user inputted double value of degrees to convert

    public static void main(String[] args) {
        int firstUnitType = 0;  //is unit celsius, kelvin or fahrenheit?
        int secondUnitType;     //is unit celsius, kelvin or fahrenheit?
        int tmpNum;             //used to determine if secondUnitType == firstKey

        while (firstUnitType != -1) {
            //Starts conversation with user and asks for their input
            System.out.println("\nWhat unit of temperature will you be inputting?");
            System.out.print("0: Celsius 1: Kelvin 2: Fahrenheit(-1: Exit): ");
            firstUnitType = scanner.nextInt();  //Get user input
            //Validate input is not -1 and is between 0 and 2
            if (firstUnitType != -1 && firstUnitType >= 0 && firstUnitType <= 2) {
                int firstKey = handler.myMap().get(firstUnitType).firstKey();
                int lastKey = handler.myMap().get(firstUnitType).lastKey();
                //Asks user the second question and asks for their input
                System.out.println("\nWhat would you like to convert to?");
                System.out.print(firstKey + ": " + handler.myMap().get(firstUnitType).get(firstKey) + " "
                        + lastKey + ": " + handler.myMap().get(firstUnitType).get(lastKey) + ": ");
                secondUnitType = scanner.nextInt(); //Get user input
                //Check if user input is between 0 and 2
                if (secondUnitType >= 0 && secondUnitType <= 2) {
                    System.out.print("\nEnter the degrees in " + unit[firstUnitType] + ": ");
                    degrees = scanner.nextDouble(); //Get user input
                    tmpNum = secondUnitType == firstKey ? 0 : 1;    //Compares secondUnitType and firstKey
                    //convert double from either first or last 
                    //key of myMap()'s key of 'firstUnitType'
                    double converted = handler.convert(handler.myMap().get(firstUnitType)
                            .keySet().toArray()[tmpNum].hashCode(), firstUnitType, degrees);
                    //Get name of converted to unit
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
