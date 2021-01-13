package designlld.factorypattern.pizzas;

import designlld.factorypattern.ingredientsfactory.IngredientsFactory;

public class ChickenPizza extends Pizza {
    private IngredientsFactory ingredientsFactory;

    public ChickenPizza(IngredientsFactory ingredientsFactory) {
        this.ingredientsFactory = ingredientsFactory;
    }

    @Override
    public Pizza create() {
        name = "Chicken Pizza";
        sizeInches = 12.0f;
        pizzaBase = ingredientsFactory.getPizzaBase();
        chicken = ingredientsFactory.getChicken();
        veggies = ingredientsFactory.getVeggies();
        return this;
    }
}
