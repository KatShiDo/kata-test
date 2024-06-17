package org.example;

import java.util.Arrays;

class Calculator {

    public static String[] romanNumbers = new String[] {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

    public static int calcArabic(int first, int second, String operation) {
        return switch (operation) {
            case "+" -> first + second;
            case "-" -> first - second;
            case "*" -> first * second;
            case "/" -> first / second;
            default -> throw new IllegalArgumentException("Unknown operation: " + operation);
        };
    }

    public static String calcRoman(String first, String second, String operation) {
        int firstInt = Arrays.asList(romanNumbers).indexOf(first) + 1;
        int secondInt = Arrays.asList(romanNumbers).indexOf(second) + 1;

        int result = calcArabic(firstInt, secondInt, operation);
        if (result < 1) {
            throw new ArithmeticException("Roman calculation failed: result is not positive");
        }
        return intToRoman(result);
    }

    public static String intToRoman(int value) {
        if (value < 1 || value > 3999)
            throw new IllegalArgumentException("Illegal roman value");
        StringBuilder s = new StringBuilder();
        while (value >= 1000) {
            s.append("M");
            value -= 1000;        }
        while (value >= 900) {
            s.append("CM");
            value -= 900;
        }
        while (value >= 500) {
            s.append("D");
            value -= 500;
        }
        while (value >= 400) {
            s.append("CD");
            value -= 400;
        }
        while (value >= 100) {
            s.append("C");
            value -= 100;
        }
        while (value >= 90) {
            s.append("XC");
            value -= 90;
        }
        while (value >= 50) {
            s.append("L");
            value -= 50;
        }
        while (value >= 40) {
            s.append("XL");
            value -= 40;
        }
        while (value >= 10) {
            s.append("X");
            value -= 10;
        }
        while (value >= 9) {
            s.append("IX");
            value -= 9;
        }
        while (value >= 5) {
            s.append("V");
            value -= 5;
        }
        while (value >= 4) {
            s.append("IV");
            value -= 4;
        }
        while (value >= 1) {
            s.append("I");
            value -= 1;
        }
        return s.toString();
    }
}
