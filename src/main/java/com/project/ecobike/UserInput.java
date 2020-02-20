package com.project.ecobike;

import static java.lang.System.exit;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author Bohdan Skrypnyk
 */
public class UserInput {

    private static Scanner scan = new Scanner(System.in);
    private static AddNewBikes addNewBikes = new AddNewBikes();
    private static Validation validate = new Validation();
    private static FileReader fileReader = new FileReader();
    private static Path url;

    public static void pathQuestion() {
        try {
            System.out.println("Please, provide a Path to the file:");
            url = validate.validatorPath(Paths.get(scan.nextLine()));
            fileReader.readFile(url);
        } catch (InvalidPathException ex) {
            validate.pathErrorMessage();
            pathQuestion();
        }
    }

    public static void dispalyMenu() {
        System.out.println("Please make your choice:\n"
                + "1 - Show the entire EcoBike catalog\n"
                + "2 – Add a new folding bike\n"
                + "3 – Add a new speedelec\n"
                + "4 – Add a new e-bike\n"
                + "5 – Find the first item of a particular brand\n"
                + "6 – Write to file\n"
                + "7 – Stop the program");
        String valInput = validate.validatorMenu(scan.nextLine());
        int input = Integer.parseInt(valInput);
        selectorMenu(input);
    }

    private static void selectorMenu(int input) {
        if (input == 1) {
            for (Object objects : fileReader.arrCatalogue) {
                System.out.println(objects.toString());
            }
            dispalyMenu();
        } else if (input == 2) {
            foldingQuestions();
            dispalyMenu();
        } else if (input == 3) {
            speedelecQuestions();
            dispalyMenu();
        } else if (input == 4) {
            eBikeQuestions();
            dispalyMenu();
        } else if (input == 5) {

        } else if (input == 6) {

        } else if (input == 7) {
            exit(0);
        }
    }

    public static void foldingQuestions() {
        String[] itemArr = {"What is the brand of the bike?",
            "What is the size of the wheels, in inch?",
            "What is the number of gears?",
            "What is the weight of the bike in grams?",
            "There is available lights at front and back?\n Please make your choice:\n[1]Available\n[2]Not Available",
            "What is the colour of bike?",
            "What is the price?"};
        String[] answers = new String[7];
        for (int a = 0; a < 7; a++) {
            if (a == 4) {
                System.out.println(itemArr[a]);
                answers[a] = validate.validatorAvailable(scan.nextLine());
            } else if (a == 1 || a == 2 || a == 3 || a == 6) {
                System.out.println(itemArr[a]);
                answers[a] = validate.validatorInteger(scan.nextLine());
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
                answers[a] = validate.validatorAvailable(scan.nextLine());
            } else if (a == 1 || a == 2 || a == 4 || a == 6) {
                System.out.println(itemArr[a]);
                answers[a] = validate.validatorInteger(scan.nextLine());
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
                answers[a] = validate.validatorAvailable(scan.nextLine());
            } else if (a == 1 || a == 2 || a == 4 || a == 6) {
                System.out.println(itemArr[a]);
                answers[a] = validate.validatorInteger(scan.nextLine());
            } else {
                System.out.println(itemArr[a]);
                answers[a] = scan.nextLine();
            }
        }
        addNewBikes.AddEbike(answers);
    }
}
