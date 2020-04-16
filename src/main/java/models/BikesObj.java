package models;

import com.project.ecobike.Validation;

/**
 * BikesObj to assign correct variables to corresponding setters It
 * makes easier to retrieve needed variables and manipulate with them
 */

public class BikesObj {

    private static Validation validation = new Validation();
    private static Speedelec speedelec = new Speedelec();
    private static eBike ebike = new eBike();
    private static FoldingBike foldingBike = new FoldingBike();

    public static Speedelec speedelecObj(String[] itemArr) {
        speedelec = new Speedelec(itemArr[0].strip(),
                Integer.parseInt(itemArr[1].strip()),
                Integer.parseInt(itemArr[2].strip()),
                validation.checkAvailability(itemArr[3].strip()),
                Integer.parseInt(itemArr[4].strip()),
                itemArr[5].strip(),
                Integer.parseInt(itemArr[6].strip()));

        //System.out.println("Oops, something went wrong. Please, check file");
        //userInput.pathQuestion();
        //userInput.dispalyMenu();

        return speedelec;
    }

    public static eBike ebikeObj(String[] itemArr) {
        ebike = new eBike(itemArr[0].strip(),
                Integer.parseInt(itemArr[1].strip()),
                Integer.parseInt(itemArr[2].strip()),
                validation.checkAvailability(itemArr[3].strip()),
                Integer.parseInt(itemArr[4].strip()),
                itemArr[5].strip(),
                Integer.parseInt(itemArr[6].strip()));

        //System.out.println("Oops, something went wrong. Please, check file");
        //userInput.pathQuestion();
        //userInput.dispalyMenu();
        return ebike;
    }

    public static FoldingBike foldingBikeObj(String[] itemArr) {
        foldingBike = new FoldingBike(itemArr[0].strip(),
                Integer.parseInt((itemArr[1]).strip()),
                Integer.parseInt((itemArr[2]).strip()),
                Integer.parseInt((itemArr[3]).strip()),
                validation.checkAvailability(itemArr[4].strip()),
                itemArr[5].strip(),
                Integer.parseInt(itemArr[6].strip()));

        //System.out.println("Oops, something went wrong. Please, check file");
        //userInput.pathQuestion();
        //userInput.dispalyMenu();
        return foldingBike;
    }
}
