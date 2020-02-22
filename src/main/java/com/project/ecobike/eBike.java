package com.project.ecobike;

import java.util.Objects;

/**
 *
 * @author Bohdan Skrypnyk
 */
public class eBike extends Bikes{

    public int speed;
    public int battery;
    

    @Override
    public String getBrand() {
        return brand;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public String getAvailability() {
        return availability;
    }

    public int getBattery() {
        return battery;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public int getPrice() {
        return price;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
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
