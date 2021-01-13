package designpatterns.structural.flyweight;

public class FlyweightTest {
    public static void main(String[] args) {
        CoffeeShop shop = new CoffeeShop();
        shop.takeOrder("Cappuccino", 2);
        shop.takeOrder("Frappe", 1);
        shop.takeOrder("Espresso", 1);
        shop.takeOrder("Frappe", 2);
        shop.takeOrder("Cappuccino", 3);
        shop.takeOrder("Frappe", 4);
        shop.takeOrder("Espresso", 3);
        shop.takeOrder("Cappuccino", 5);
        shop.takeOrder("Espresso", 6);
        shop.service();

        // cache will contain only three objects because only three coffee flavours have been created
        System.out.println("CoffeeFlavor objects in cache: " + CoffeeFlavour.flavoursInCache());
    }
}
