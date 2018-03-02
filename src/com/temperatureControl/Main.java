package com.temperatureControl;

import com.temperatureControl.handler.UnitHandler;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static UnitHandler handler = new UnitHandler();

    private static final String[] unit = {"Celsius", "Kelvin", "Fahrenheit"};

    private static double degrees;

    public static void main(String[] args) {
        int type = 0, tmpNum;
        char var2;

        while (type != -1) {
            //Starts conversation with user and asks for their input
            System.out.println("\nWhat unit of temperature will you be inputting?");
            System.out.print("0: Celsius 1: Kelvin 2: Fahrenheit(-1: Exit): ");
            type = scanner.nextInt();
            //Check if user input is between specified values
            if (type != -1 && type >= 0 && type <= 2) {
                //Asks user the second question and asks for their input
                System.out.println("\nWhat would you like to convert to?");
                System.out.print(handler.toString(type)[0] + " " + handler.toString(type)[1] + ": ");
                var2 = scanner.next().charAt(0);
                //Check if user input is between specified value
                if( var2 == '0' || var2 == '1' || var2 == '2') {
                    System.out.print("\nEnter the degrees in " + unit[type] + ": ");
                    degrees = scanner.nextDouble();
                    tmpNum = var2 == handler.toString(type)[0].charAt(0) ? 0 : 1;
                    System.out.printf(degrees + " " + unit[type] + " is: %.2f "
                            + handler.toString(type)[tmpNum].substring(3),
                            handler.convert(Integer.parseInt(String.valueOf(
                                    handler.toString(type)[tmpNum].charAt(0))), type, degrees));
                }
            } else {
                System.out.println("\nInvalid input, please enter a different number.");
            }
        }
    }
}
