package com.project.ecobike;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Bohdan Skrypnyk
 */
public class Search {

    public static FileReader fileReader = new FileReader();
    public static Speedelec speedelec = new Speedelec();

    public static void fndItem() {
        String search = "E-Scooter";
        List<Bikes> dataPointsCalledJohn = fileReader.arrBikes
                .stream()
                .filter(p -> p.getBrand().contains(search))
                .collect(Collectors.toList());
        dataPointsCalledJohn.stream().forEach(System.out::println);
    }
}
