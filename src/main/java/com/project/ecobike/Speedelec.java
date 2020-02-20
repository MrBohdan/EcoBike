package com.project.ecobike;

import java.util.Objects;

/**
 *
 * @author Bohdan Skrypnyk
 */
public class Speedelec {

    public String brand;
    public int speed;
    public int weight;
    public String availability;
    public int battery;
    public String color;
    public int price;

    public Speedelec(String brand, int speed, int weight, String availability, int battery, String color, int price) {
        this.brand = brand;
        this.speed = speed;
        this.weight = weight;
        this.availability = availability;
        this.battery = battery;
        this.color = color;
        this.price = price;
    }

    @Override
    public String toString() {
        return brand + ", speed=" + speed
                 + " the weight " + weight + " grams"
                + " and " + availability
                + " with " + battery + " mAh battery"
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
        final Speedelec other = (Speedelec) obj;
        if (this.speed != other.speed) {
            return false;
        }
        if (this.weight != other.weight) {
            return false;
        }
        if (this.battery != other.battery) {
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
