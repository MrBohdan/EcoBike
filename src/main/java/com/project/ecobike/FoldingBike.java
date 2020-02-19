package com.project.ecobike;

/**
 *
 * @author Bohdan Skrypnyk
 */
public class FoldingBike {

    public String brand;
    public int sizeWheels;
    public int gears;
    public int weight;
    public String availability;
    public String color;
    public int price;

    public FoldingBike(String brand, int sizeWheels, int gears, int weight, String availability, String color, int price) {
        this.brand = brand;
        this.sizeWheels = sizeWheels;
        this.gears = gears;
        this.weight = weight;
        this.availability = availability;
        this.color = color;
        this.price = price;
    }

    @Override
    public String toString() {
        return "FoldingBike{" + "brand=" + brand + ", sizeWheels=" + sizeWheels + ", gears=" + gears + ", weight=" + weight + ", availability=" + availability + ", color=" + color + ", price=" + price + '}';
    }
    
}
