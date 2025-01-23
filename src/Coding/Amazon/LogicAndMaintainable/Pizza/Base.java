package Coding.Amazon.LogicAndMaintainable.Pizza;

public class Base {
    private String name;
    private double price;

    public Base(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
