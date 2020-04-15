package com.project.ecobike;

import models.*;

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
 * @author Bohdan Skrypnyk
 */
public class FileProcessor {

    public static BikesObj bikesObj = new BikesObj();
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
                    arrBikes.add(bikesObj.speedelecConstructor(itemArr));
                } else if (current.contains("E-BIKE")) {
                    arrBikes.add(bikesObj.ebikeConstructor(itemArr));
                } else if (current.contains("FOLDING")) {
                    arrBikes.add(bikesObj.foldingBikeConstructor(itemArr));
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
            Speedelec speedelec = new Speedelec();
            writer.write(speedelec.getBrand() + "; "
                    + speedelec.getSpeed() + "; "
                    + speedelec.getWeight() + "; "
                    + validation.checkAvailability(speedelec.getAvailability()) + "; "
                    + speedelec.getBattery() + "; "
                    + speedelec.getColor() + "; "
                    + speedelec.getPrice()
                    + System.lineSeparator());

            eBike ebike = new eBike();
            writer.write(ebike.getBrand() + "; "
                    + ebike.getSpeed() + "; "
                    + ebike.getWeight() + "; "
                    + validation.checkAvailability(ebike.getAvailability()) + "; "
                    + ebike.getBattery() + "; "
                    + ebike.getColor() + "; "
                    + ebike.getPrice()
                    + System.lineSeparator());

            FoldingBike foldingBike = new FoldingBike();
            writer.write(foldingBike.getBrand() + "; "
                    + foldingBike.getSizeWheels() + "; "
                    + foldingBike.getGears() + "; "
                    + foldingBike.getWeight() + "; "
                    + validation.checkAvailability(foldingBike.getAvailability()) + "; "
                    + foldingBike.getColor() + "; "
                    + foldingBike.getPrice()
                    + System.lineSeparator());
            addBikes.arrListAddedBikes.clear();
            writer.close();
        } catch (
                IOException ex) {
            Logger.getLogger(FileProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Records saved successfully");
    }

}
