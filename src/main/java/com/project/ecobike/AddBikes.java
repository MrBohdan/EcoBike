package com.project.ecobike;

import models.Bikes;
import models.BikesObj;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bohdan Skrypnyk
 */
public class AddBikes {

    public static BikesObj bikesObj = new BikesObj();
    private static FileProcessor fileProcessor = new FileProcessor();

    public static List<Bikes> arrListAddedBikes = new ArrayList<>();

    public static void addSpeedelec(String[] itemArr) {
        itemArr[0] = "SPEEDELEC " + itemArr[0];
        fileProcessor.arrBikes.add(bikesObj.speedelecConstructor(itemArr));
        arrListAddedBikes.add(bikesObj.speedelecConstructor(itemArr));
    }

    public static void addEbike(String[] itemArr) {
        itemArr[0] = "E-BIKE " + itemArr[0];
        fileProcessor.arrBikes.add(bikesObj.ebikeConstructor(itemArr));
        arrListAddedBikes.add(bikesObj.ebikeConstructor(itemArr));
    }

    public static void addFolding(String[] itemArr) {
        itemArr[0] = "FOLDING BIKE " + itemArr[0];
        fileProcessor.arrBikes.add(bikesObj.foldingBikeConstructor(itemArr));
        arrListAddedBikes.add(bikesObj.foldingBikeConstructor(itemArr));
    }
}
