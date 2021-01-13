package designlld.factorypattern.pizzas;

import designlld.factorypattern.ingredients.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The product that the PizzaStore factory produces
 */
@ToString
@Getter
@Setter
public abstract class Pizza {
    String name;
    float sizeInches;
    PizzaBase pizzaBase;
    Cheese cheese;
    Sauce sauce;
    Veggies[] veggies;
    Chicken chicken;

    abstract Pizza create();

    protected void cut() {
        System.out.println(name + " pizza is cut.");
    }

    protected void pack() {
        System.out.println(name + " pizza is packed.");
    }

    protected void process() {
        System.out.println(this.toString());
    }

    protected void bake() {
        System.out.println(name + " pizza is baked.");
    }
}
