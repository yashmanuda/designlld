package designlld.factorypattern.ingredientsfactory;

import designlld.factorypattern.ingredients.*;

/**
 * There can be multiple sauces, veggies, cheeses & pizza base for one ingredient factory.
 * This is the abstract factory which gives option to create multiple types of objects.
 */
public abstract class IngredientsFactory {
    abstract public Cheese getCheese();

    abstract public PizzaBase getPizzaBase();

    abstract public Sauce getSauce();

    abstract public Veggies[] getVeggies();

    abstract public Chicken getChicken();
}
