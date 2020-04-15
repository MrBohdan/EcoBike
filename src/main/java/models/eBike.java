package models;

import java.util.Objects;

/**
 * @author Bohdan Skrypnyk
 */
public class eBike extends Bikes {

    public int speed;
    public int battery;

    public eBike() {
        super();
    }

    public eBike(String brand, int weight, int speed, String availability, int battery, String color, int price) {
        super(brand, weight, availability, color, price);
        this.speed = speed;
        this.battery = battery;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public int getSpeed() {
        return speed;
    }

    public int getBattery() {
        return battery;
    }


    @Override
    public String toString() {
        return brand + " has maximum speed " + speed + " km/h"
                + " the weight " + weight + " grams"
                + " and " + availability + ","
                + " with " + battery + " mAh battery"
                + " in " + color + " color. \n"
                + " Price: " + price + " euros.";
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final eBike other = (eBike) obj;
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
