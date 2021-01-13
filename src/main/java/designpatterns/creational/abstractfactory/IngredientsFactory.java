package designpatterns.creational.abstractfactory;

import designpatterns.creational.abstractfactory.abstractingredientfactories.CaliforniaPizzaIngredientFactory;
import designpatterns.creational.abstractfactory.abstractingredientfactories.IAbstractIngredientFactory;
import designpatterns.creational.abstractfactory.abstractingredientfactories.NewYorkPizzaIngredientFactory;

import static designpatterns.creational.abstractfactory.Constants.CALIFORNIA;
import static designpatterns.creational.abstractfactory.Constants.NEW_YORK;

/**
 * This is a factory design pattern
 */
public class IngredientsFactory {

    public static IAbstractIngredientFactory createIngredientFactory(String type) throws Exception {
        switch (type) {
            case CALIFORNIA:
                return new CaliforniaPizzaIngredientFactory();
            case NEW_YORK:
                return new NewYorkPizzaIngredientFactory();
        }
        throw new Exception(type + " ingredient factory not available!");
    }
}
