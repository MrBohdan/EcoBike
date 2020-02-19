package com.project.ecobike;

import static java.lang.System.exit;
import java.util.Scanner;

/**
 *
 * @author Bohdan Skrypnyk
 */
public class UserInput {

    public static Scanner scan = new Scanner(System.in);

    public static void dispalyMenu() {
        System.out.println("Please make your choice:\n"
                + "1 - Show the entire EcoBike catalog\n"
                + "2 – Add a new folding bike\n"
                + "3 – Add a new speedelec\n"
                + "4 – Add a new e-bike\n"
                + "5 – Find the first item of a particular brand\n"
                + "6 – Write to file\n"
                + "7 – Stop the program");
        String valInput = validator(scan.nextLine());
        int input = Integer.parseInt(valInput);
        selector(input);
    }

    public static void selector(int input) {
        if (input == 1) {

            System.out.println(FileReader.arrСatalog.toString());

        } else if (input == 2) {
            addFoldingBikeQuestions();
        } else if (input == 3) {

        } else if (input == 4) {

        } else if (input == 5) {

        } else if (input == 6) {

        } else if (input == 7) {
            exit(0);
        }
    }

    public static void addFoldingBikeQuestions() {
        String[] str = {"brand",
            "The maximum speed",
            "The weight of the e-bike (in grams)",
            "The availability of lights at front and back (TRUE/FALSE)",
            "The battery capacity (in mAh)",
            "A color",
            "The price",};
        for (int a = 0; a <= 7; a++) {
            System.out.println(str[a]);
            String ba = scan.nextLine();
        }
    }

    public static String validator(String value) {
        if (!value.matches("\\d+") || Integer.parseInt(value) > 7 || Integer.parseInt(value) < 1) {
            System.out.println("Error: Wrong Input");

            String input = scan.nextLine();
            validator(input);
        }
        return value;

    }
}
