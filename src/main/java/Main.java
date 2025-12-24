import model.Apple;
import model.Food;
import model.Meat;
import model.constants.Colour;
import service.ShoppingCart;

public class Main {
    public static void main(String[] args) {
        Food[] foods = {
                new Meat(5, 100),
                new Apple(10, 50, Colour.RED),
                new Apple(8, 60, Colour.GREEN)
        };

        ShoppingCart cart = new ShoppingCart(foods);

        System.out.printf("Общая сумма товаров без скидки: %.1f%n", cart.getTotalPrice());
        System.out.printf("Общая сумма товаров со скидкой: %.1f%n", cart.getTotalPriceWithDiscount());
        System.out.printf("Сумма всех вегетарианских продуктов без скидки: %.1f%n", cart.getTotalPriceForVegetarian());

    }
}
