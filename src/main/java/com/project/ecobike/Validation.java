package com.project.ecobike;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author Budda
 */
public class Validation {

    private static Scanner scan = new Scanner(System.in);

    public static String validatorAvailable(String value) {
        validatorInteger(value);
        if (!value.matches("\\d+") || (Integer.parseInt(value) != 1 && Integer.parseInt(value) != 2)) {
            value = dispalyErrorMessage(value);
            validatorAvailable(value);
        } else if (Integer.parseInt(value) == 1) {
            return value = "true";
        } else if (Integer.parseInt(value) == 2) {
            return value = "false";
        }
        return value;
    }

    public static String validatorMenu(String value) {
        value = validatorInteger(value);
        if (!value.matches("\\d+") || Integer.parseInt(value) > 7 || Integer.parseInt(value) < 1) {
            value = dispalyErrorMessage(value);
            value = validatorMenu(value);
            return value;
        } else {
            return value;
        }
    }

    public static String validatorInteger(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            value = dispalyErrorMessage(value);
            value = validatorInteger(value);
        }
        return value;
    }

    public static String dispalyErrorMessage(String value) {
        System.out.println("Error: Wrong Input");
        scan.reset();
        value = scan.nextLine();
        return value;
    }

    public static Path validatorPath(Path value) {

        if (!Files.isRegularFile(value)) {
            pathErrorMessage();
            value = validatorPath(Paths.get(scan.nextLine()));
        }
        return value;
    }

    public static void pathErrorMessage() {
        System.out.println("Error: Wrong path to file, plese provide in format \"path/fileName.txt\"");
    }
}
