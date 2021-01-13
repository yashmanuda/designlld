package designpatterns.structural.decorator.models.topping;

import designpatterns.structural.decorator.models.pizza.Pizza;

public class Chicken extends PizzaTopping {
    public Chicken(Pizza pizza) {
        super(pizza);
    }

    @Override
    public int getCost() {
        return pizza.getCost() + 35;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Chicken";
    }
}
