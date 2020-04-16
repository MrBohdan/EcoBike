package models;

/**
 * @author Bohdan Skrypnyk
 */
public class Speedelec extends Bikes {

    public int speed;
    public int battery;

    public Speedelec() {
        super();
    }

    public Speedelec(String brand, int speed, int weight, String availability, int battery, String color, int price) {
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


}
