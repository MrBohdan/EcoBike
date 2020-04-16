package models;

/**
 * @author Bohdan Skrypnyk
 */
public class FoldingBike extends Bikes {

    public int sizeWheels;
    public int gears;

    public FoldingBike() {
        super();
    }

    public FoldingBike(String brand, int sizeWheels, int gears, int weight, String availability, String color, int price) {
        super(brand, weight, availability, color, price);
        this.sizeWheels = sizeWheels;
        this.gears = gears;
    }

    public void setSizeWheels(int sizeWheels) {
        this.sizeWheels = sizeWheels;
    }

    public void setGears(int gears) {
        this.gears = gears;
    }

    public int getSizeWheels() {
        return sizeWheels;
    }

    public int getGears() {
        return gears;
    }


    @Override
    public String toString() {
        return brand + " with the size of the wheels " + sizeWheels + " inches,"
                + " with " + gears + " gear(s)"
                + " the weight " + weight + " grams"
                + " and " + availability + ","
                + " in " + color + " color. \n"
                + " Price: " + price + " euros.";
    }

}
