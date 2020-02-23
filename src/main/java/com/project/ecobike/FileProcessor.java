package com.project.ecobike;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
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
public class FileProcessor {

    private static BikesConstructors bikesConstructors = new BikesConstructors();
    private static Validation validation = new Validation();

    public static List<Bikes> arrBikes = new ArrayList<Bikes>();
    public static AddBikes addBikes = new AddBikes();
    public static String[] itemArr;
    private static String current;

    /**
     * Read all items from the file and add them to List through constructions
     *
     * @param url
     */
    public static void readFile(Path url) {
        try {
            BufferedReader read = Files.newBufferedReader(Paths.get(url.toUri()));

            while ((current = read.readLine()) != null) {
                itemArr = current.split("\\;");
                if (current.contains("SPEEDELEC")) {
                    arrBikes.add(bikesConstructors.speedelecConstructor(itemArr));
                } else if (current.contains("E-BIKE")) {
                    arrBikes.add(bikesConstructors.ebikeConstructor(itemArr));
                } else if (current.contains("FOLDING")) {
                    arrBikes.add(bikesConstructors.foldingBikeConstructor(itemArr));
                }
            }
            read.close();
        } catch (IOException ex) {
            Logger.getLogger(FileProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * write new items to the file
     *
     * @param url
     */
    public static void writeFile(Path url) {
        validation.validatorArrListAddedBikes();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(Paths.get(url.toUri()).toString(), true));
            for (Bikes bike : addBikes.arrListAddedBikes) {
                if (bike instanceof Speedelec) {
                    Speedelec speedelec = (Speedelec) bike;
                    writer.write(speedelec.getBrand() + "; "
                            + speedelec.getSpeed() + "; "
                            + speedelec.getWeight() + "; "
                            + validation.checkAvailability(speedelec.getAvailability()) + "; "
                            + speedelec.getBattery() + "; "
                            + speedelec.getColor() + "; "
                            + speedelec.getPrice()
                            + System.lineSeparator());
                }
                if (bike instanceof eBike) {
                    eBike ebike = (eBike) bike;
                    writer.write(ebike.getBrand() + "; "
                            + ebike.getSpeed() + "; "
                            + ebike.getWeight() + "; "
                            + validation.checkAvailability(ebike.getAvailability()) + "; "
                            + ebike.getBattery() + "; "
                            + ebike.getColor() + "; "
                            + ebike.getPrice()
                            + System.lineSeparator());
                }
                if (bike instanceof FoldingBike) {
                    FoldingBike foldingBike = (FoldingBike) bike;
                    writer.write(foldingBike.getBrand() + "; "
                            + foldingBike.getSizeWheels() + "; "
                            + foldingBike.getGears() + "; "
                            + foldingBike.getWeight() + "; "
                            + validation.checkAvailability(foldingBike.getAvailability()) + "; "
                            + foldingBike.getColor() + "; "
                            + foldingBike.getPrice()
                            + System.lineSeparator());
                }
            }
            addBikes.arrListAddedBikes.clear();
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(FileProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Records saved successfully");
    }

}
