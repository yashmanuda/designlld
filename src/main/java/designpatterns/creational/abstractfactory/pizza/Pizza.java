package designpatterns.creational.abstractfactory.pizza;

import designpatterns.creational.abstractfactory.abstractingredientfactories.IAbstractIngredientFactory;
import designpatterns.creational.abstractfactory.ingredients.*;
import lombok.Getter;

import java.util.Arrays;

@Getter
public class Pizza {
    private String name;
    private int size;
    private Veggie[] veggies;
    private Sauce[] sauces;
    private Base base;
    private Cheese cheese;
    private Topping[] toppings;

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", veggies=" + Arrays.toString(veggies) +
                ", sauces=" + Arrays.toString(sauces) +
                ", base=" + base +
                ", cheese=" + cheese +
                ", toppings=" + Arrays.toString(toppings) +
                '}';
    }

    private Pizza(String name, int size) {
        this.name = name;
        this.size = size;
    }

    private void setVeggies(Veggie[] veggies) {
        this.veggies = veggies;
    }

    private void setSauces(Sauce[] sauces) {
        this.sauces = sauces;
    }

    private void setBase(Base base) {
        this.base = base;
    }

    private void setCheese(Cheese cheese) {
        this.cheese = cheese;
    }

    private void setToppings(Topping[] toppings) {
        this.toppings = toppings;
    }

    public static Pizza createPizza(String name, int size, IAbstractIngredientFactory ingredientFactory) {
        System.out.println(name + " pizza creation started!");
        Pizza pizza = new Pizza(name, size);
        pizza.setBase(ingredientFactory.createBase());
        pizza.setVeggies(ingredientFactory.createVeggies());
        pizza.setCheese(ingredientFactory.createCheese());
        pizza.setToppings(ingredientFactory.createToppings());
        pizza.setSauces(ingredientFactory.createSauces());
        System.out.println(name + " pizza creation completed!");
        return pizza;
    }
}
