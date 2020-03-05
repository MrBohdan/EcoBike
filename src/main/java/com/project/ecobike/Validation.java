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
        validatorIfInteger(value);
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

    /**
     * Check, whatever user save new items to file or not
     *
     * @param value
     * @return corresponding message
     */
    public static String validatorifNotSaved(String value) {
        value = validatorIfInteger(value);
        if (!value.matches("\\d+") || Integer.parseInt(value) > 3 || Integer.parseInt(value) < 0) {
            value = dispalyErrorMessage(value);
            return validatorifNotSaved(value);
        } else {
            return value;
        }
    }

    /**
     * Validate, user input in main menu to avoid "exceptions"
     *
     * @param value
     * @return
     */
    public static String validatorMenu(String value) {
        value = validatorIfInteger(value);
        if (!value.matches("\\d+") || Integer.parseInt(value) > 7 || Integer.parseInt(value) < 1) {
            value = dispalyErrorMessage(value);
            return validatorMenu(value);
        } else {
            return value;
        }
    }

    /**
     * Check if user entered integer or not
     *
     * @param value
     * @return corresponding message
     */
    public static String validatorIfInteger(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            value = dispalyErrorMessage(value);
            value = validatorIfInteger(value);
        }
        if (Integer.parseInt(value) >= 0) {
            return value;
        } else {
            value = dispalyErrorMessage(value);
            value = validatorIfInteger(value);
        }
        return value;
    }

    public static String dispalyErrorMessage(String value) {
        System.out.println("Error: Wrong Input");
        return value = scan.nextLine();
    }

    /**
     * Check, if the file to which user give path exist if not display error
     * message
     *
     * @param value
     * @return
     */
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

    /**
     * If search thread is running. not allowing user to access to add new items
     * and display corresponding message
     */
    public static void checkSearchActivity() {
        if (multithreading.searchActivity == true) {
            System.out.println("\nError: Sorry, you are not allowed to add a new item. While the search is in the process");
            userInput.dispalyMenu();
        }
    }

    /**
     * Check when the search is running or completed
     */
    public static void searchStatus() {
        if (multithreading.searchActivity == true) {
            System.out.println("\nSearch is running");
        } else {
            System.out.println("\nSearch completed");
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

    /**
     * Check if user add new items to the system or not and not allow to save
     * empty list.
     */
    public static void validatorArrListAddedBikes() {
        if (addBikes.arrListAddedBikes.isEmpty()) {
            System.out.println("Nothing to save");
            userInput.dispalyMenu();
        }
    }
}
