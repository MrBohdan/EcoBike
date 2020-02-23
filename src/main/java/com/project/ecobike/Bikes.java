package com.project.ecobike;

import java.util.Objects;

/**
 *
 * @author Bohdan Skrypnyk
 */
public class Bikes {

    public String brand;
    public int weight;
    public String availability;
    public String color;
    public int price;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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
        final Bikes other = (Bikes) obj;
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

class BikesConstructors {

    public static Validation validation = new Validation();

    public static Speedelec speedelecConstructor(String[] itemArr) {
        Speedelec speedelec = new Speedelec();
        speedelec.setBrand(itemArr[0].strip());
        speedelec.setSpeed(Integer.parseInt(itemArr[1].strip()));
        speedelec.setWeight(Integer.parseInt(itemArr[2].strip()));
        speedelec.setAvailability(validation.checkAvailability(itemArr[3].strip()));
        speedelec.setBattery(Integer.parseInt(itemArr[4].strip()));
        speedelec.setColor(itemArr[5].strip());
        speedelec.setPrice(Integer.parseInt(itemArr[6].strip()));
        return speedelec;
    }

    public static eBike ebikeConstructor(String[] itemArr) {
        eBike ebike = new eBike();
        ebike.setBrand(itemArr[0].strip());
        ebike.setSpeed(Integer.parseInt(itemArr[1].strip()));
        ebike.setWeight(Integer.parseInt(itemArr[2].strip()));
        ebike.setAvailability(validation.checkAvailability(itemArr[3].strip()));
        ebike.setBattery(Integer.parseInt(itemArr[4].strip()));
        ebike.setColor(itemArr[5].strip());
        ebike.setPrice(Integer.parseInt(itemArr[6].strip()));
        return ebike;
    }

    public static FoldingBike foldingBikeConstructor(String[] itemArr) {
        FoldingBike foldingBike = new FoldingBike();
        foldingBike.setBrand(itemArr[0].strip());
        foldingBike.setSizeWheels(Integer.parseInt((itemArr[1]).strip()));
        foldingBike.setGears(Integer.parseInt((itemArr[2]).strip()));
        foldingBike.setWeight(Integer.parseInt((itemArr[3]).strip()));
        foldingBike.setAvailability(validation.checkAvailability(itemArr[4].strip()));
        foldingBike.setColor(itemArr[5].strip());
        foldingBike.setPrice(Integer.parseInt(itemArr[6].strip()));
        return foldingBike;
    }
}
