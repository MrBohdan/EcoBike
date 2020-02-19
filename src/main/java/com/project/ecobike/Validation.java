package com.project.ecobike;

import java.util.Scanner;

/**
 *
 * @author Budda
 */
public class Validation {

    private static Scanner scan = new Scanner(System.in);

    public static String validatorAvailable(String value) {
        String input;
        validatorInteger(value);
        if (!value.matches("\\d+") || (Integer.parseInt(value) != 1 && Integer.parseInt(value) != 2)) {
            input = dispalyErrorMessage(value);
            validatorAvailable(input);
        } else if (Integer.parseInt(value) == 1) {
            return value = "true";
        } else if (Integer.parseInt(value) == 2) {
            return value = "false";
        }
        return value;
    }

    public static String validatorMenu(String value) {
        String input;
        validatorInteger(value);
        if (!value.matches("\\d+") || Integer.parseInt(value) > 7 || Integer.parseInt(value) < 1) {
            input = dispalyErrorMessage(value);
            input = validatorMenu(input);
            return input;
        } else {
            return input = value;
        }
    }

    public static String validatorInteger(String value) {
        String input;
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            input = dispalyErrorMessage(value);
            input = validatorInteger(input);
        }
        return value;
    }

    public static String dispalyErrorMessage(String value) {
        System.out.println("Error: Wrong Input");
        scan.reset();
        value = scan.nextLine();
        return value;
    }
}
