package com.project.ecobike;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bohdan Skrypnyk
 */
public class AddNewBikes {

    public static BikesConstructors BikesConstructors = new BikesConstructors();
    private static FileProcessor fileProcessor = new FileProcessor();

    public static List<Bikes> arrListAddedBikes = new ArrayList<Bikes>();

    public static void addSpeedelec(String[] itemArr) {
        itemArr[0] = "SPEEDELEC " + itemArr[0];
        fileProcessor.arrBikes.add(BikesConstructors.speedelecConstructor(itemArr));
        arrListAddedBikes.add(BikesConstructors.speedelecConstructor(itemArr));
    }

    public static void addEbike(String[] itemArr) {
        itemArr[0] = "E-BIKE " + itemArr[0];
        fileProcessor.arrBikes.add(BikesConstructors.ebikeConstructor(itemArr));
        arrListAddedBikes.add(BikesConstructors.ebikeConstructor(itemArr));
    }

    public static void addFolding(String[] itemArr) {
        itemArr[0] = "FOLDING BIKE " + itemArr[0];
        fileProcessor.arrBikes.add(BikesConstructors.foldingBikeConstructor(itemArr));
        arrListAddedBikes.add(BikesConstructors.foldingBikeConstructor(itemArr));
    }
}
