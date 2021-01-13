package designpatterns.creational.abstractfactory;

import designpatterns.creational.abstractfactory.pizza.Pizza;

public class AbstractFactoryTest {
    public static void main(String[] args) throws Exception {
        Pizza newYorkPizza = PizzaFactory.createDefaultPizza("New York", 10);
        Pizza californiaPizza = PizzaFactory.createDefaultPizza("California", 18);

        System.out.println(newYorkPizza);
        System.out.println(californiaPizza);
    }
}
