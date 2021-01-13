package designpatterns.structural.decorator.models.topping;

import designpatterns.structural.decorator.models.pizza.Pizza;

public abstract class PizzaTopping extends Pizza {
    protected Pizza pizza;

    PizzaTopping(Pizza pizza) {
        this.pizza = pizza;
    }
}
