package designpatterns.creational.abstractfactory.abstractingredientfactories;

import designpatterns.creational.abstractfactory.ingredients.*;

/**
 * This is the abstract factory design pattern
 */
public interface IAbstractIngredientFactory {
    Veggie[] createVeggies();

    Sauce[] createSauces();

    Topping[] createToppings();

    Cheese createCheese();

    Base createBase();
}
