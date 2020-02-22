package com.project.ecobike;

import java.util.Objects;

/**
 *
 * @author Bohdan Skrypnyk
 */
public class FoldingBike extends Bikes {

    public int sizeWheels;
    public int gears;

    @Override
    public String getBrand() {
        return brand;
    }

    public int getSizeWheels() {
        return sizeWheels;
    }

    public int getGears() {
        return gears;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public String getAvailability() {
        return availability;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setSizeWheels(int sizeWheels) {
        this.sizeWheels = sizeWheels;
    }

    public void setGears(int gears) {
        this.gears = gears;
    }

    @Override
    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
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
