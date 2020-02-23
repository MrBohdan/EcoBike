package com.project.ecobike;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bohdan Skrypnyk
 */
public class FileReader {

    private static BikesConstructors BikesConstructors = new BikesConstructors();

    public static List<Bikes> arrBikes = new ArrayList<Bikes>();
    public static String[] itemArr;
    private static String current;

    public static void readFile(Path url) {
        try {
            BufferedReader read = Files.newBufferedReader(Paths.get(url.toUri()));

            while ((current = read.readLine()) != null) {
                itemArr = current.split("\\;");
                if (current.contains("SPEEDELEC")) {
                    arrBikes.add(BikesConstructors.speedelecConstructor(itemArr));
                } else if (current.contains("E-BIKE")) {
                    arrBikes.add(BikesConstructors.ebikeConstructor(itemArr));
                } else if (current.contains("FOLDING")) {
                    arrBikes.add(BikesConstructors.foldingBikeConstructor(itemArr));
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
