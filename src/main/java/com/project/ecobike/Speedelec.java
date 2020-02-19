package com.project.ecobike;

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
        return "Speedelec{" + "brand=" + brand + ", speed=" + speed + ", weight=" + weight + ", availability=" + availability + ", battery=" + battery + ", color=" + color + ", price=" + price + '}';
    }

}
