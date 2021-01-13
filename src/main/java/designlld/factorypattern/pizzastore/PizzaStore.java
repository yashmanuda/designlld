package designlld.factorypattern.pizzastore;

import designlld.factorypattern.pizzas.Pizza;

public abstract class PizzaStore {
    /**
     * This is the factory method, subclasses will implement createPizza method.
     * Creation of objects has been abstracted out.
     *
     * @param pizza type of pizza that needs to be created
     * @return the required pizza
     */
    abstract Pizza createPizza(String pizza);

    public void orderPizza(String type) {
        Pizza pizza = createPizza(type);
        if (null == pizza) {
            System.out.println("Pizza cannot be ordered, it's unavailable!");
            return;
        }
        System.out.println("Pizza " + pizza.toString() + " ordered!");
    }
}
