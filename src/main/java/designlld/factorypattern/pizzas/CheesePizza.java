package designlld.factorypattern.pizzas;

import designlld.factorypattern.ingredientsfactory.IngredientsFactory;

public class CheesePizza extends Pizza {
    private IngredientsFactory ingredientsFactory;

    public CheesePizza(IngredientsFactory ingredientsFactory) {
        this.ingredientsFactory = ingredientsFactory;
    }

    @Override
    public Pizza create() {
        name = "Cheese Pizza";
        sizeInches = 10.0f;
        pizzaBase = ingredientsFactory.getPizzaBase();
        cheese = ingredientsFactory.getCheese();
        veggies = ingredientsFactory.getVeggies();
        return this;
    }
}
