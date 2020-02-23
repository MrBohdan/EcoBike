package com.project.ecobike;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author Bohdan Skrypnyk
 */
public class Validation {

    private static Multithreading multithreading = new Multithreading();
    private static UserInput userInput = new UserInput();
    private static Scanner scan = new Scanner(System.in);
    private static AddBikes addBikes = new AddBikes();

    public static String validatorAvailable(String value) {
        validatorInteger(value);
        if (Integer.parseInt(value) != 1 && Integer.parseInt(value) != 2) {
            value = dispalyErrorMessage(value);
            value = validatorAvailable(value);
        } else if (Integer.parseInt(value) == 1) {
            return value = "true";
        } else if (Integer.parseInt(value) == 2) {
            return value = "false";
        }
        return value;
    }

    public static String validatorifNotSaved(String value) {
        value = validatorInteger(value);
        if (!value.matches("\\d+") || Integer.parseInt(value) > 3 || Integer.parseInt(value) < 0) {
            value = dispalyErrorMessage(value);
            return validatorifNotSaved(value);
        } else {
            return value;
        }
    }

    public static String validatorMenu(String value) {
        value = validatorInteger(value);
        if (!value.matches("\\d+") || Integer.parseInt(value) > 7 || Integer.parseInt(value) < 1) {
            value = dispalyErrorMessage(value);
            return validatorMenu(value);
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
        if (Integer.parseInt(value) >= 0) {
            return value;
        } else {
            value = dispalyErrorMessage(value);
            value = validatorInteger(value);
        }
        return value;
    }

    public static String dispalyErrorMessage(String value) {
        System.out.println("Error: Wrong Input");
        return value = scan.nextLine();
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

    public static String checkAvailability(String value) {
        if (value.equals("true")) {
            return value = "head/tail light";
        } else if (value.equals("false")) {
            return value = "no head/tail light";
        } else if (value.equals("head/tail light")) {
            return value = "true";
        } else if (value.equals("no head/tail light")) {
            return value = "false";
        }
        return null;
    }

    public static void checkSearchActivity() {
        if (multithreading.searchActivity == true) {
            System.out.println("\nError: Sorry you are not allowed to add new item. While search is in the process");
            userInput.dispalyMenu();
        }
    }

    public static void searchStatus() {
        if (multithreading.searchActivity == true) {
            System.out.println("\nSearch is running");
        } else {
            System.out.println("\nSearch complited");
        }
    }

    public static String validatorSearchQuestions(String value) {
        if (!value.isEmpty()) {
            return value;
        } else {
            System.out.println("Error : Brand cannot be empty");
            value = scan.nextLine();
            return value = validatorSearchQuestions(value);
        }
    }

    public static void validatorArrListAddedBikes() {
        if (addBikes.arrListAddedBikes.isEmpty()) {
            System.out.println("Nothing to save");
            userInput.dispalyMenu();
        }
    }
}
