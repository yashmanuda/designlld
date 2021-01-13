package designpatterns.structural.decorator;

import designpatterns.structural.decorator.models.pizza.CheeseBurst;
import designpatterns.structural.decorator.models.pizza.Pizza;
import designpatterns.structural.decorator.models.pizza.ThinCrust;
import designpatterns.structural.decorator.models.topping.Chicken;
import designpatterns.structural.decorator.models.topping.Corn;
import designpatterns.structural.decorator.models.topping.Tomato;

public class DecoratorTest {
    public static void main(String[] args) {
        Pizza pizza1 = new Corn(new Chicken(new ThinCrust()));
        Pizza pizza2 = new Tomato(new Corn(new CheeseBurst()));

        System.out.println("Pizza: " + pizza1.getDescription());
        System.out.println("Cost: " + pizza1.getCost());
        System.out.println("\n");
        System.out.println("Pizza: " + pizza2.getDescription());
        System.out.println("Cost: " + pizza2.getCost());

    }
}
