package com.project.ecobike;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Bohdan Skrypnyk
 */
public class Search {

    private static FileReader fileReader = new FileReader();
    private static SearchThread searchThread = new SearchThread();
    private static Multithreading multithreading = new Multithreading();
    private static Validation validate = new Validation();

    public static boolean searchStarted;

    public static void fndItem() {
        String search = "Figatron";
        int search2 = 1055;
        searchStarted = true;
        List<Bikes> dataPointsCalledJohn = fileReader.arrBikes
                .stream()
                .filter(p -> p.getBrand().contains(search))
                .collect(Collectors.toList());
        dataPointsCalledJohn.stream().forEach(System.out::println);
        searchThread.stop();
        multithreading.searchActivity = searchThread.isAlive();
        validate.searchStatus();
    }
}
