package designlld.factorypattern.ingredientsfactory;

import designlld.factorypattern.ingredients.*;

public class CaliforniaPizzaIngredientFactory extends IngredientsFactory {
    @Override
    public Cheese getCheese() {
        return Cheese.PARMESAN;
    }

    @Override
    public PizzaBase getPizzaBase() {
        return PizzaBase.THIN_CRUST;
    }

    @Override
    public Sauce getSauce() {
        return Sauce.TOBASCO;
    }

    @Override
    public Veggies[] getVeggies() {
        return new Veggies[]{Veggies.CORN, Veggies.ONION};
    }

    @Override
    public Chicken getChicken() {
        return Chicken.BREAST;
    }
}
