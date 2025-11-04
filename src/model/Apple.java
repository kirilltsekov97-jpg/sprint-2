package model;

public class Apple extends Food implements Discountable {
    private String colour;

    public Apple(int amount, double price, String colour) {
        super(amount, price, true);
        this.colour = colour;
    }

    @Override
    public double getDiscount() {
        if (this.colour.equals("red")) {
            return 60.0;
        }
        return 0.0;
    }
} //class apple