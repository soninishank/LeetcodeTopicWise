package Coding.Amazon.LogicAndMaintainable.Pizza;

import java.util.List;

public class Deal {
    private String name;
    private double discount; // Percentage discount (e.g., 10% -> 0.10)
    private List<String> applicableItems;

    public Deal(String name, double discount, List<String> applicableItems) {
        this.name = name;
        this.discount = discount;
        this.applicableItems = applicableItems;
    }

    public double applyDeal(List<String> items, double totalPrice) {
        for (String item : applicableItems) {
            if (items.contains(item)) {
                return totalPrice * (1 - discount);
            }
        }
        return totalPrice;
    }

    public String getName() {
        return name;
    }
}
