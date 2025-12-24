package service;

import model.Discountable;
import model.Food;

public class ShoppingCart {
    private final Food[] items;

    public ShoppingCart(Food[] items) {
        this.items = items;
    }

    public double getTotalPrice() {
        double total = 0.0;
        for (Food item : items) {
            total += item.getAmount() * item.getPrice();
        }
        return total;
    }

    public double getTotalPriceWithDiscount() {
        double total = 0.0;
        for (Food item : items) {
            double discount = 0.0;

            if (item instanceof Discountable) {
                discount = ((Discountable) item).getDiscount();
            }

            double discountedPrice = item.getPrice() * (1 - discount / 100.0);
            total += item.getAmount() * discountedPrice;
        }
        return total;
    }

    public double getTotalPriceForVegetarian() {
        double total = 0.0;
        for (Food item : items) {
            if (item.isVegetarian()) {
                total += item.getAmount() * item.getPrice();
            }
        }
        return total;
    }
}
