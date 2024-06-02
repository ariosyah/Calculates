package main.java.com.calculates;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("This program will calculate (a + b) / (c + d) based on provided inputs.");

        System.out.print("Value for a: ");
        double a = getValidInput(scanner);

        System.out.print("Value for b: ");
        double b = getValidInput(scanner);

        System.out.print("Value for c: ");
        double c = getValidInput(scanner);

        System.out.print("Value for d: ");
        double d = getValidInput(scanner);

        double result = calculate(a, b, c, d);
        printResult(a, b, c, d, result);
    }

    private static double getValidInput(Scanner scanner) {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid number: ");
            }
        }
    }

    public static double calculate(double a, double b, double c, double d) {
        if (c + d == 0) {
            return Double.NaN; // Handle division by zero
        }
        return (a + b) / (c + d);
    }

    private static void printResult(double a, double b, double c, double d, double result) {
        if (Double.isNaN(result)) {
            System.out.println("Result for (" + a + " + " + b + ") / (" + c + " + " + d + ") is undefined (division by zero).");
        } else {
            System.out.println("Result for (" + a + " + " + b + ") / (" + c + " + " + d + ") is: " + result);
        }
    }
}



