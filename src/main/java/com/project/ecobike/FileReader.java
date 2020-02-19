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

    public static ArrayList<String> arrList = new ArrayList<>();
    public static String[] strArr;
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
                strArr = read.readLine().split("\\;");
                if (current.contains("SPEEDELEC")) {
                    Speedelec speedelec = new Speedelec(strArr[0],
                            Integer.parseInt((strArr[1]).strip()),
                            Integer.parseInt((strArr[2]).strip()),
                            strArr[3].strip(),
                            Integer.parseInt((strArr[4]).strip()),
                            strArr[5].strip(),
                            Integer.parseInt((strArr[6]).strip()));
                    arrList.add(speedelec.toString());
                } else if (current.contains("E-BIKE")) {
                    eBike ebike = new eBike(strArr[0],
                            Integer.parseInt((strArr[1]).strip()),
                            Integer.parseInt((strArr[2]).strip()),
                            strArr[3].strip(),
                            Integer.parseInt((strArr[4]).strip()),
                            strArr[5].strip(),
                            Integer.parseInt((strArr[6]).strip()));
                    arrList.add(ebike.toString());
                } else if (current.contains("FOLDING")) {
                    FoldingBike foldingBike = new FoldingBike(strArr[0],
                            Integer.parseInt((strArr[1]).strip()),
                            Integer.parseInt((strArr[2]).strip()),
                            Integer.parseInt((strArr[3]).strip()),
                            strArr[4].strip(),
                            strArr[5].strip(),
                            Integer.parseInt((strArr[6]).strip()));
                    arrList.add(foldingBike.toString());
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
