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

    private static AddBikes addBikes = new AddBikes();
    private static Validation validate = new Validation();
    private static Multithreading multithreading = new Multithreading();

    private static Scanner scan = new Scanner(System.in);
    private static FileProcessor fileReader = new FileProcessor();
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
        System.out.println("\nPlease make your choice:\n"
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
            fileReader.arrBikes.forEach((System.out::println));
            dispalyMenu();
        } else if (input == 2) {
            validate.checkSearchActivity();
            foldingQuestions();
            dispalyMenu();
        } else if (input == 3) {
            validate.checkSearchActivity();
            speedelecQuestions();
            dispalyMenu();
        } else if (input == 4) {
            validate.checkSearchActivity();
            eBikeQuestions();
            dispalyMenu();
        } else if (input == 5) {
            validate.checkSearchActivity();
            searchQuestions();
        } else if (input == 6) {
            validate.checkSearchActivity();
            fileReader.writeFile(url);
            dispalyMenu();
        } else if (input == 7) {
            ifNotSaved();
        }
    }

    public static String[] searchAnswers = new String[2];

    private static void searchQuestions() {
        String[] itemArr = {"What is the brand of the bike?",
            "What is the colour of bike?",};
        for (int a = 0; a < 2; a++) {
            System.out.println(itemArr[a]);
            if (a == 0) {
                searchAnswers[a] = validate.validatorSearchQuestions(scan.nextLine());
            } else {
                searchAnswers[a] = scan.nextLine();
            }
        }
        multithreading.runThreads();
        dispalyMenu();
    }

    private static void foldingQuestions() {
        String[] itemArr = {"What is the brand of the bike?",
            "What is the size of the wheels, in inch?",
            "What is the number of gears?",
            "What is the weight of the bike, in grams?",
            "There is available lights at front and back?"
            + "\n Please make your choice:"
            + "\n1 - Available"
            + "\n2 - Not Available",
            "What is the colour of bike?",
            "What is the price?"};
        String[] answers = new String[7];
        for (int a = 0; a < 7; a++) {
            if (a == 4) {
                System.out.println(itemArr[a]);
                answers[a] = validate.validatorAvailable(scan.nextLine());
            } else if (a == 1 || a == 2 || a == 3 || a == 6) {
                System.out.println(itemArr[a]);
                answers[a] = validate.validatorIfInteger(scan.nextLine());
            } else {
                System.out.println(itemArr[a]);
                answers[a] = scan.nextLine();
            }
        }
        addBikes.addFolding(answers);
    }

    private static void speedelecQuestions() {
        String[] itemArr = {"What is the brand of the bike?",
            "What is the maximum speed?",
            "What is the weight of the bike, in grams?",
            "There is available lights at front and back?"
            + "\n Please make your choice:"
            + "\n1 - Available"
            + "\n2 - Not Available",
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
                answers[a] = validate.validatorIfInteger(scan.nextLine());
            } else {
                System.out.println(itemArr[a]);
                answers[a] = scan.nextLine();
            }
        }
        addBikes.addSpeedelec(answers);
    }

    private static void eBikeQuestions() {
        String[] itemArr = {"What is the brand of the bike?",
            "What is the maximum speed?",
            "What is the weight of the bike, in grams?",
            "There is available lights at front and back?"
            + "\n Please make your choice:"
            + "\n1 - Available"
            + "\n2 - Not Available",
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
                answers[a] = validate.validatorIfInteger(scan.nextLine());
            } else {
                System.out.println(itemArr[a]);
                answers[a] = scan.nextLine();
            }
        }
        addBikes.addEbike(answers);
    }

    private static void ifNotSaved() {
        AddBikes addBikes = new AddBikes();
        if (addBikes.arrListAddedBikes.isEmpty()) {
            exit(0);
        } else {
            System.out.println("You didnt save new items! "
                    + "\n1 - Save and exit"
                    + "\n2 - Back to menu"
                    + "\n3 - Exit");
            String valInput = validate.validatorifNotSaved(scan.nextLine());
            int input = Integer.parseInt(valInput);
            if (input == 1) {
                validate.checkSearchActivity();
                fileReader.writeFile(url);
                exit(0);
            } else if (input == 2) {
                dispalyMenu();
            } else if (input == 3) {
                exit(0);
            } else {
                ifNotSaved();
            }
        }

    }
}
