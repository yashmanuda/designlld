package designpatterns.structural.decorator.models.topping;

import designpatterns.structural.decorator.models.pizza.Pizza;

public class Corn extends PizzaTopping {

    public Corn(Pizza pizza) {
        super(pizza);
    }

    @Override
    public int getCost() {
        return pizza.getCost() + 30;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Corn";
    }
}
