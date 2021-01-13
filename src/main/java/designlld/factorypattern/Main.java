package designlld.factorypattern;

import designlld.factorypattern.pizzastore.CaliforniaPizzaStore;
import designlld.factorypattern.pizzastore.NewYorkPizzaStore;
import designlld.factorypattern.pizzastore.PizzaStore;

public class Main {
    public static void main(String[] args) {
        PizzaStore newYorkPizzaStore = new NewYorkPizzaStore();
        PizzaStore californiaPizzaStore = new CaliforniaPizzaStore();

        // ordering new york style classic pizza
        newYorkPizzaStore.orderPizza("Classic Pizza");

        // ordering new york style cheese pizza
        newYorkPizzaStore.orderPizza("Cheese Pizza");

        // ordering california style chicken pizza
        californiaPizzaStore.orderPizza("Chicken Pizza");

        // ordering california style classic pizza
        californiaPizzaStore.orderPizza("Classic Pizza");

        // ordering incorrect type pizza
        newYorkPizzaStore.orderPizza("Paneer Tikka Pizza");
    }
}
