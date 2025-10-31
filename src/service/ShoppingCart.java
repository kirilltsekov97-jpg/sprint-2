package service;
import model.Food;
import model.Discountable;
public class ShoppingCart {
    private Food[] items;

    public ShoppingCart(Food[] items) {
        this.items = items;

    }

    public double getTotalPrice() {
        double total = 0;
        for (int i = 0; i < items.length; i++) {
            total += items[i].getAmount() * items[i].getPrice();
        }
        return total;
    }

    public double getTotalPriceWithDiscount() {
        double total = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] instanceof Discountable) {

                double discount = ((Discountable) items[i]).getDiscount();
                double discountedPrice = items[i].getPrice() * (1 - discount / 100);
                total += items[i].getAmount() * discountedPrice;
            } else {

                total += items[i].getAmount() * items[i].getPrice();
            }
        }
        return total;
    }

    public double getTotalPriceForVegetarian() {
        double total = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i].isVegetarian()) {
                total += items[i].getAmount() * items[i].getPrice();
            }
        }
        return total;
    }

    }
