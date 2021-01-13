package designlld.factorypattern.ingredientsfactory;

import designlld.factorypattern.ingredients.*;

public class NewYorkPizzaIngredientFactory extends IngredientsFactory {

    @Override
    public Cheese getCheese() {
        return Cheese.CHEDDAR;
    }

    @Override
    public PizzaBase getPizzaBase() {
        return PizzaBase.CHEESE_BURST;
    }

    @Override
    public Sauce getSauce() {
        return Sauce.BARBEQUE;
    }

    @Override
    public Veggies[] getVeggies() {
        return new Veggies[]{Veggies.BABYCORN, Veggies.CORN, Veggies.ONION};
    }

    @Override
    public Chicken getChicken() {
        return Chicken.SALAMI;
    }
}
