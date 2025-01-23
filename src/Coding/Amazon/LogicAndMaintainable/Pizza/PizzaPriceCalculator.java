package Coding.Amazon.LogicAndMaintainable.Pizza;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PizzaPriceCalculator {
    public static void main(String[] args) {
        // Pricing configuration
        double wholeWheatPrice = 5.00;
        double glutenFreePrice = 6.50;
        double smallPrice = 8.00;
        double mediumPrice = 10.00;
        double largePrice = 12.00;
        double cheesePrice = 1.50;
        double onionPrice = 0.75;
        double olivePrice = 1.00;
        double cokePrice = 2.00;
        double waterPrice = 1.00;

        // Create pizza
        Base base = new Base("Whole Wheat", wholeWheatPrice);
        Size size = new Size("Medium", mediumPrice);
        Pizza pizza = new Pizza(base, size);
        pizza.addTopping(new Topping("Cheese", cheesePrice));
        pizza.addTopping(new Topping("Olive", olivePrice));

        // Add drinks
        List<Drink> drinks = new ArrayList<>();
        drinks.add(new Drink("Coke", cokePrice));
        drinks.add(new Drink("Water", waterPrice));

        // Add deals
        List<Deal> deals = new ArrayList<>();
        deals.add(new Deal("Pizza and Coke Combo", 0.10, Arrays.asList("Whole Wheat", "Medium", "Coke")));

        // Calculate total price
        double totalPrice = pizza.calculateTotalPrice();
        for (Drink drink : drinks) {
            totalPrice += drink.getPrice();
        }
        for (Deal deal : deals) {
            totalPrice = deal.applyDeal(pizza.getItems(), totalPrice);
        }

        // Print summary
        System.out.println("--- Order Summary ---");
        pizza.getItems().forEach(System.out::println);
        drinks.forEach(drink -> System.out.println(drink.getName() + " ($" + drink.getPrice() + ")"));
        System.out.printf("Total Price: $%.2f\n", totalPrice);
    }
}
