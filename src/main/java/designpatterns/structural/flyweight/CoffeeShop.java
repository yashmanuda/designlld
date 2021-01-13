package designpatterns.structural.flyweight;

import java.util.ArrayList;

class CoffeeShop {
    private final ArrayList<Order> orders = new ArrayList<>();

    /**
     * @param flavour     current order coffee flavour
     * @param tableNumber current order table number
     */
    public void takeOrder(String flavour, int tableNumber) {
        orders.add(Order.of(flavour, tableNumber));
    }

    /**
     * Serve all the orders
     */
    public void service() {
        orders.forEach(Order::serve);
    }
}