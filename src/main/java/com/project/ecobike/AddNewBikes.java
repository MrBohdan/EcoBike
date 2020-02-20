package com.project.ecobike;

import static com.project.ecobike.FileReader.checkAvailability;
import java.util.Scanner;

/**
 *
 * @author Bohdan Skrypnyk
 */
public class AddNewBikes {

    public static Scanner scan = new Scanner(System.in);
    private static FileReader fileReader = new FileReader();

    /**
     * eBike & Speedelec / FoldingBike
     *
     * @strArr[0] brand
     * @strArr[1] speed / sizeWheels
     * @strArr[2] weight / gears
     * @strArr[3] availability / weight
     * @strArr[4] battery / availability
     * @strArr[5] color
     * @strArr[6] price
     */
    public static void AddSpeedelec(String[] itemArr) {
        Speedelec speedelec = new Speedelec("SPEEDELEC " + itemArr[0],
                Integer.parseInt((itemArr[1]).strip()),
                Integer.parseInt((itemArr[2]).strip()),
                checkAvailability(itemArr[3].strip()),
                Integer.parseInt((itemArr[4]).strip()),
                itemArr[5].strip(),
                Integer.parseInt((itemArr[6]).strip()));
        fileReader.arrCatalogue.add(speedelec.toString());
    }

    public static void AddEbike(String[] itemArr) {
        eBike ebike = new eBike("E-BIKE " + itemArr[0],
                Integer.parseInt((itemArr[1]).strip()),
                Integer.parseInt((itemArr[2]).strip()),
                checkAvailability(itemArr[3].strip()),
                Integer.parseInt((itemArr[4]).strip()),
                itemArr[5].strip(),
                Integer.parseInt((itemArr[6]).strip()));
        fileReader.arrCatalogue.add(ebike.toString());
    }

    public static void addFolding(String[] itemArr) {
        FoldingBike foldingBike = new FoldingBike("FOLDING " + itemArr[0],
                Integer.parseInt((itemArr[1]).strip()),
                Integer.parseInt((itemArr[2]).strip()),
                Integer.parseInt((itemArr[3]).strip()),
                checkAvailability(itemArr[4].strip()),
                itemArr[5].strip(),
                Integer.parseInt((itemArr[6]).strip()));
        fileReader.arrCatalogue.add(foldingBike.toString());
    }

}
