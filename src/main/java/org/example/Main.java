package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        var in = new Scanner(System.in);
        var input = in.nextLine();
        System.out.println(calc(input));
    }

    public static String[] romanNumbers = new String[] {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    public static String[] operations = new String[] {"+", "-", "*", "/"};

    public static String calc(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("Empty input");
        }
        try {
            var params = input.split(" ");
            if (params.length != 3) {
                throw new IllegalArgumentException("Input must contain three parameters");
            }

            var first = params[0];
            var second = params[2];
            var operation = params[1];

            if (!Arrays.asList(operations).contains(operation)) {
                throw new IllegalArgumentException("Invalid operation: " + operation);
            }

            if (Arrays.asList(romanNumbers).contains(first) || Arrays.asList(romanNumbers).contains(second)) {
                if (Arrays.asList(romanNumbers).contains(first) && Arrays.asList(romanNumbers).contains(second)) {
                    return Calculator.calcRoman(first, second, operation);
                }
                else {
                    throw new IllegalArgumentException("Values must be both arabic or roman");
                }
            }

            var firstArabic = Integer.parseInt(first);
            var secondArabic = Integer.parseInt(second);
            if (firstArabic < 1 || firstArabic > 10 || secondArabic < 1 || secondArabic > 10) {
                throw new IllegalArgumentException("Values must be between 1 and 10");
            }
            return String.valueOf(Calculator.calcArabic(firstArabic, secondArabic, operation));
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("Values must be integers");
        }
        catch (ArithmeticException | IllegalArgumentException e) {
            throw e;
        }
        catch (Exception e) {
            throw new IllegalArgumentException("Invalid input");
        }
    }
}