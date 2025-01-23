package Coding.Amazon.LogicAndMaintainable.Pizza;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private Base base;
    private Size size;
    private List<Topping> toppings;

    public Pizza(Base base, Size size) {
        this.base = base;
        this.size = size;
        this.toppings = new ArrayList<>();
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public double calculateTotalPrice() {
        double total = base.getPrice() + size.getPrice();
        for (Topping topping : toppings) {
            total += topping.getPrice();
        }
        return total;
    }

    public List<String> getItems() {
        List<String> items = new ArrayList<>();
        items.add(base.getName());
        items.add(size.getName());
        for (Topping topping : toppings) {
            items.add(topping.getName());
        }
        return items;
    }
}
