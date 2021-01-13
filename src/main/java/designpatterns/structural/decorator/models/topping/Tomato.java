package designpatterns.structural.decorator.models.topping;

import designpatterns.structural.decorator.models.pizza.Pizza;

public class Tomato extends PizzaTopping {

    public Tomato(Pizza pizza) {
        super(pizza);
    }

    @Override
    public int getCost() {
        return pizza.getCost() + 20;
    }


    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Tomato";
    }
}
