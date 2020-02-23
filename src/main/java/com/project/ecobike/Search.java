package com.project.ecobike;

import java.util.Optional;

/**
 *
 * @author Bohdan Skrypnyk
 */
public class Search {

    private static FileProcessor fileReader = new FileProcessor();
    private static SearchThread searchThread = new SearchThread();
    private static Validation validate = new Validation();
    private static Multithreading multithreading = new Multithreading();

    public static boolean searchStarted;

    public static void fndItem(String[] search) {
        searchStarted = true;
        Optional<Bikes> dataPointsCalledJohn = fileReader.arrBikes
                .stream()
                .filter(p -> p.getBrand().contains(search[0]))
                .filter(p -> p != null && p.getColor().contains(search[1]))
                .findFirst();
        dataPointsCalledJohn.stream().forEach(System.out::println);
        searchThread.stop();
        multithreading.searchActivity = searchThread.isAlive();
        validate.searchStatus();
    }
}
