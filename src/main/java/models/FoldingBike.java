package models;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FoldingBike other = (FoldingBike) obj;
        if (this.sizeWheels != other.sizeWheels) {
            return false;
        }
        if (this.gears != other.gears) {
            return false;
        }
        if (this.weight != other.weight) {
            return false;
        }
        if (this.price != other.price) {
            return false;
        }
        if (!Objects.equals(this.brand, other.brand)) {
            return false;
        }
        if (!Objects.equals(this.availability, other.availability)) {
            return false;
        }
        if (!Objects.equals(this.color, other.color)) {
            return false;
        }
        return true;
    }

}