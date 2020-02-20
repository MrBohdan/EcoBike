package com.project.ecobike;

import static com.project.ecobike.FileReader.checkAvailability;
import java.util.Scanner;

/**
 *
 * @author Bohdan Skrypnyk
 */
public class AddNewBikes {

    public static Scanner scan = new Scanner(System.in);

    public static void addFolding(String[] itemArr) {
        FoldingBike foldingBike = new FoldingBike(itemArr[0],
                Integer.parseInt((itemArr[1]).strip()),
                Integer.parseInt((itemArr[2]).strip()),
                Integer.parseInt((itemArr[3]).strip()),
                checkAvailability(itemArr[4].strip()),
                itemArr[5].strip(),
                Integer.parseInt((itemArr[6]).strip()));
        // arrCatalogue.add(foldingBike.toString());
    }

    public static void AddSpeedelec(String[] itemArr) {
        Speedelec speedelec = new Speedelec(itemArr[0],
                Integer.parseInt((itemArr[1]).strip()),
                Integer.parseInt((itemArr[2]).strip()),
                checkAvailability(itemArr[3].strip()),
                Integer.parseInt((itemArr[4]).strip()),
                itemArr[5].strip(),
                Integer.parseInt((itemArr[6]).strip()));
        //  arrCatalogue.add(speedelec.toString());
    }

    public static void AddEbike(String[] itemArr) {
        eBike ebike = new eBike(itemArr[0],
                Integer.parseInt((itemArr[1]).strip()),
                Integer.parseInt((itemArr[2]).strip()),
                checkAvailability(itemArr[3].strip()),
                Integer.parseInt((itemArr[4]).strip()),
                itemArr[5].strip(),
                Integer.parseInt((itemArr[6]).strip()));
        //   arrCatalogue.add(ebike.toString());
    }
}
