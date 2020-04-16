package models;

/**
 * @author Bohdan Skrypnyk
 */
public class Bikes {

    public String brand;
    public int weight;
    public String availability;
    public String color;
    public int price;

    public Bikes() {
    }

    public Bikes(String brand, int weight, String availability, String color, int price) {
        this.brand = brand;
        this.weight = weight;
        this.availability = availability;
        this.color = color;
        this.price = price;
    }


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

}
