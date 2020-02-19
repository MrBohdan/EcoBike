package com.project.ecobike;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bohdan Skrypnyk
 */
public class FileReader {

    public static ArrayList<String> arrСatalog = new ArrayList<>();
    public static String[] itemArr;
    public static String current;

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
    public static void readFile() {
        try {
            BufferedReader read = Files.newBufferedReader(Paths.get("C:\\Users\\mrbud\\Downloads\\Quality Unit Ukraine\\ecobike.txt"));

            while ((current = read.readLine()) != null) {
                itemArr = current.split("\\;");
                if (current.contains("SPEEDELEC")) {
                    Speedelec speedelec = new Speedelec(itemArr[0],
                            Integer.parseInt((itemArr[1]).strip()),
                            Integer.parseInt((itemArr[2]).strip()),
                            checkAvailability(itemArr[3].strip()),
                            Integer.parseInt((itemArr[4]).strip()),
                            itemArr[5].strip(),
                            Integer.parseInt((itemArr[6]).strip()));
                    arrСatalog.add(speedelec.toString());
                } else if (current.contains("E-BIKE")) {
                    eBike ebike = new eBike(itemArr[0],
                            Integer.parseInt((itemArr[1]).strip()),
                            Integer.parseInt((itemArr[2]).strip()),
                            checkAvailability(itemArr[3].strip()),
                            Integer.parseInt((itemArr[4]).strip()),
                            itemArr[5].strip(),
                            Integer.parseInt((itemArr[6]).strip()));
                    arrСatalog.add(ebike.toString());
                } else if (current.contains("FOLDING")) {
                    FoldingBike foldingBike = new FoldingBike(itemArr[0],
                            Integer.parseInt((itemArr[1]).strip()),
                            Integer.parseInt((itemArr[2]).strip()),
                            Integer.parseInt((itemArr[3]).strip()),
                            checkAvailability(itemArr[4].strip()),
                            itemArr[5].strip(),
                            Integer.parseInt((itemArr[6]).strip()));
                    arrСatalog.add(foldingBike.toString());
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String checkAvailability(String value) {
        if (Boolean.parseBoolean(value) == true) {
            return value = "head/tail light";

        } else {
            return value = "no head/tail light";
        }
    }

}
