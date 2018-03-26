package com.temperatureControl;

import com.temperatureControl.handler.UnitHandler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);    //used to collect user input
    private static UnitHandler handler = new UnitHandler();     //object of handler class

    private static final String[] unit = {"Celsius", "Kelvin", "Fahrenheit"};

    private static double degreesDouble;  //user inputted double value of degrees to convert

    public static void main(String[] args) {
        int firstUnitType = 0;  //is unit celsius, kelvin or fahrenheit?
        int secondUnitType;     //is unit celsius, kelvin or fahrenheit?
        int tmpNum;             //used to determine if secondUnitType == firstKey
        DecimalFormat df = new DecimalFormat("0.00");   //Formats the final decimals

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
                    if (secondUnitType == firstKey || secondUnitType == lastKey) {
                        System.out.print("\nEnter the degrees in " + unit[firstUnitType] + ": ");
                        degreesDouble = scanner.nextDouble(); //Get user input
                        tmpNum = secondUnitType == firstKey ? 0 : 1;    //Compares secondUnitType and firstKey
                        //convert double from either first or last
                        //key of myMap()'s key of 'firstUnitType'
                        double convertedUnit = handler.convert(handler.myMap().get(firstUnitType)
                                .keySet().toArray()[tmpNum].hashCode(), firstUnitType, degreesDouble);
                        //Get name of converted to unit
                        Object convertedName = handler.myMap().get(firstUnitType).values().toArray()[tmpNum];
                        //Build string for display
                        String outputString = df.format(degreesDouble) + " " + unit[firstUnitType] + " \t\t is: \t "
                                + df.format(convertedUnit) + " " + convertedName;
                        output(outputString); //write to console and output.txt
                    }
            } else if(firstUnitType != -1) {
                System.out.println("\nInvalid input, please enter a different number.");
            }
        }
    }

    /**
     * Write 'outputString' to console and output file
     *
     * @param outputString String which gets written to console and output file
     */
    private static void output(String outputString){
        try {
            //sets 'output.text' as the file destination in the workspace folder
            final Path path = Paths.get("output.txt");
            //Append 'string' to existing document
            Files.write(path, Arrays.asList(outputString + "\n"), StandardCharsets.UTF_8,
                    Files.exists(path) ? StandardOpenOption.APPEND : StandardOpenOption.CREATE);
            System.out.print(outputString + "\n");
        } catch (final FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
