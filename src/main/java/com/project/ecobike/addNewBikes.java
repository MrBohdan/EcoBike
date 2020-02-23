package com.project.ecobike;

/**
 *
 * @author Bohdan Skrypnyk
 */
public class addNewBikes {

    public static BikesConstructors BikesConstructors = new BikesConstructors();
    private static FileReader fileReader = new FileReader();
    
    public static void addSpeedelec(String[] itemArr) {
        itemArr[0] = "SPEEDELEC " + itemArr[0];
        fileReader.arrBikes.add(BikesConstructors.speedelecConstructor(itemArr));
    }

    public static void addEbike(String[] itemArr) {
        itemArr[0] = "E-BIKE " + itemArr[0];
        fileReader.arrBikes.add(BikesConstructors.ebikeConstructor(itemArr));
    }

    public static void addFolding(String[] itemArr) {
        itemArr[0] = "FOLDING BIKE " + itemArr[0];
        fileReader.arrBikes.add(BikesConstructors.foldingBikeConstructor(itemArr));
    }

}
