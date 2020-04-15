package com.project.ecobike;

import models.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bohdan Skrypnyk
 */
public class AddItem {

    public static BikesObj bikesObj = new BikesObj();
    private static FileProcessor fileProcessor = new FileProcessor();

    public static List<Speedelec> arrListAddSpeedelec = new ArrayList<>();
    public static List<eBike> arrListAddeBike = new ArrayList<>();
    public static List<FoldingBike> arrListAddFoldingBike= new ArrayList<>();

    public static void addSpeedelec(String[] itemArr) {
        itemArr[0] = "SPEEDELEC " + itemArr[0];
        fileProcessor.arrBikes.add(bikesObj.speedelecConstructor(itemArr));
        arrListAddSpeedelec.add(bikesObj.speedelecConstructor(itemArr));
    }

    public static void addEbike(String[] itemArr) {
        itemArr[0] = "E-BIKE " + itemArr[0];
        fileProcessor.arrBikes.add(bikesObj.ebikeConstructor(itemArr));
        arrListAddeBike.add(bikesObj.ebikeConstructor(itemArr));
    }

    public static void addFolding(String[] itemArr) {
        itemArr[0] = "FOLDING BIKE " + itemArr[0];
        fileProcessor.arrBikes.add(bikesObj.foldingBikeConstructor(itemArr));
        arrListAddFoldingBike.add(bikesObj.foldingBikeConstructor(itemArr));
    }
}
