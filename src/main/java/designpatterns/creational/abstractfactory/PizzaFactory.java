package designpatterns.creational.abstractfactory;

import designpatterns.creational.abstractfactory.abstractingredientfactories.IAbstractIngredientFactory;
import designpatterns.creational.abstractfactory.pizza.Pizza;

import static designpatterns.creational.abstractfactory.Constants.CALIFORNIA;
import static designpatterns.creational.abstractfactory.Constants.NEW_YORK;

/**
 * This is factory design pattern
 */
public class PizzaFactory {

    public static Pizza createDefaultPizza(final String type, final int size) throws Exception {
        final IAbstractIngredientFactory ingredientFactory = IngredientsFactory.createIngredientFactory(type);
        switch (type) {
            case CALIFORNIA:
                return Pizza.createPizza(type, size, ingredientFactory);
            case NEW_YORK:
                return Pizza.createPizza(type, size, ingredientFactory);
        }
        throw new Exception(type + " pizza not available!");
    }
}
