package designpatterns.creational.abstractfactory.abstractingredientfactories;

import designpatterns.creational.abstractfactory.ingredients.*;

public class NewYorkPizzaIngredientFactory implements IAbstractIngredientFactory {
    @Override
    public Veggie[] createVeggies() {
        return new Veggie[]{Veggie.ONION, Veggie.CORN};
    }

    @Override
    public Sauce[] createSauces() {
        return new Sauce[]{Sauce.PESTO};
    }

    @Override
    public Topping[] createToppings() {
        return new Topping[]{Topping.PEPPERONI, Topping.GREEN_OLIVE};
    }

    @Override
    public Cheese createCheese() {
        return Cheese.PARMESAN;
    }

    @Override
    public Base createBase() {
        return Base.CHEESE_BURST;
    }
}
