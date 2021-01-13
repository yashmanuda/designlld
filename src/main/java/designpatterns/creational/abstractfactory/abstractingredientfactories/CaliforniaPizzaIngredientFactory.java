package designpatterns.creational.abstractfactory.abstractingredientfactories;

import designpatterns.creational.abstractfactory.ingredients.*;

public class CaliforniaPizzaIngredientFactory implements IAbstractIngredientFactory {
    @Override
    public Veggie[] createVeggies() {
        return new Veggie[]{Veggie.CAPSICUM, Veggie.ONION, Veggie.TOMATO};
    }

    @Override
    public Sauce[] createSauces() {
        return new Sauce[]{Sauce.BARBECUE};
    }

    @Override
    public Topping[] createToppings() {
        return new Topping[]{Topping.BLACK_OLIVE, Topping.CHICKEN};
    }

    @Override
    public Cheese createCheese() {
        return Cheese.CHEDDAR;
    }

    @Override
    public Base createBase() {
        return Base.PAN_TOSSED;
    }
}
