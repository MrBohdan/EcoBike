package com.project.ecobike;

import static java.lang.System.exit;
import java.util.Scanner;

/**
 *
 * @author Bohdan Skrypnyk
 */
public class UserInput {

    private static Scanner scan = new Scanner(System.in);
    private static AddNewBikes addNewBikes = new AddNewBikes();

    public static void dispalyMenu() {
        System.out.println("Please make your choice:\n"
                + "1 - Show the entire EcoBike catalog\n"
                + "2 – Add a new folding bike\n"
                + "3 – Add a new speedelec\n"
                + "4 – Add a new e-bike\n"
                + "5 – Find the first item of a particular brand\n"
                + "6 – Write to file\n"
                + "7 – Stop the program");
        String valInput = validatorMenu(scan.nextLine());
        int input = Integer.parseInt(valInput);
        selector(input);
    }

    private static void selector(int input) {
        if (input == 1) {

            System.out.println(FileReader.arrСatalog.toString());
            dispalyMenu();
        } else if (input == 2) {
            foldingQuestions();
        } else if (input == 3) {
            speedelecQuestions();
        } else if (input == 4) {

        } else if (input == 5) {

        } else if (input == 6) {

        } else if (input == 7) {
            exit(0);
        }
    }

    public static void foldingQuestions() {
        String[] itemArr = {"What is the brand of the bike?",
            "What is the maximum speed?",
            "What is the size of the wheels, in inch?",
            "What is the number of gears?",
            "What is the weight of the bike in grams?",
            "There is available lights at front and back?\n Please make your choice:\n[1]Available\n[2]Not Available",
            "What is the colour of bike?",
            "What is the price?"};
        String[] answers = new String[8];
        for (int a = 0; a < 8; a++) {
            if (a == 5) {
                System.out.println(itemArr[a]);
                answers[a] = validatorAvailable(scan.nextLine());
            } else if ((a >= 1 && a <= 4) || a == 7) {
                System.out.println(itemArr[a]);
                answers[a] = validatorInteger(scan.nextLine());
            } else {
                System.out.println(itemArr[a]);
                answers[a] = scan.nextLine();
            }
        }
        addNewBikes.addFolding(answers);
    }

    public static void speedelecQuestions() {
        String[] itemArr = {"What is the brand of the bike?",
            "What is the maximum speed?",
            "What is the weight of the bike in grams?",
            "There is available lights at front and back?\n Please make your choice:\n[1]Available\n[2]Not Available",
            "What is the battery capacity, in mAh?",
            "What is the colour of bike?",
            "What is the price?"};
        String[] answers = new String[7];
        for (int a = 0; a < 7; a++) {
            if (a == 3) {
                System.out.println(itemArr[a]);
                answers[a] = validatorAvailable(scan.nextLine());
            } else if (a == 1 || a == 2 || a == 4 || a == 6) {
                System.out.println(itemArr[a]);
                answers[a] = validatorInteger(scan.nextLine());
            } else {
                System.out.println(itemArr[a]);
                answers[a] = scan.nextLine();
            }
        }
        addNewBikes.AddSpeedelec(answers);
    }

    public static void eBikeQuestions() {
        String[] itemArr = {"What is the brand of the bike?",
            "What is the maximum speed?",
            "What is the weight of the bike in grams?",
            "There is available lights at front and back?\n Please make your choice:\n[1]Available\n[2]Not Available",
            "What is the battery capacity, in mAh?",
            "What is the colour of bike?",
            "What is the price?"};
        String[] answers = new String[7];
        for (int a = 0; a < 7; a++) {
            if (a == 3) {
                System.out.println(itemArr[a]);
                answers[a] = validatorAvailable(scan.nextLine());
            } else if (a == 1 || a == 2 || a == 4 || a == 6) {
                System.out.println(itemArr[a]);
                answers[a] = validatorInteger(scan.nextLine());
            } else {
                System.out.println(itemArr[a]);
                answers[a] = scan.nextLine();
            }
        }
        addNewBikes.AddEbike(answers);
    }

    private static String validatorAvailable(String value) {
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

    private static String validatorMenu(String value) {
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

    private static String validatorInteger(String value) {
        String input;
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            input = dispalyErrorMessage(value);
            input = validatorInteger(input);
        }
        return value;
    }

    private static String dispalyErrorMessage(String value) {
        System.out.println("Error: Wrong Input");
        scan.reset();
        value = scan.nextLine();
        return value;
    }
}
