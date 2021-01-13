package designlld.factorypattern.pizzas;

import designlld.factorypattern.ingredientsfactory.IngredientsFactory;

public class ClassicPizza extends Pizza {

    private IngredientsFactory ingredientsFactory;

    public ClassicPizza(IngredientsFactory ingredientsFactory) {
        this.ingredientsFactory = ingredientsFactory;
    }

    @Override
    public Pizza create() {
        name = "Classic Pizza";
        sizeInches = 12.0f;
        pizzaBase = ingredientsFactory.getPizzaBase();
        sauce = ingredientsFactory.getSauce();
        veggies = ingredientsFactory.getVeggies();
        return this;
    }
}
