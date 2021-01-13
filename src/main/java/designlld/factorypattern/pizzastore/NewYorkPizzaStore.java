package designlld.factorypattern.pizzastore;

import designlld.factorypattern.ingredientsfactory.IngredientsFactory;
import designlld.factorypattern.ingredientsfactory.NewYorkPizzaIngredientFactory;
import designlld.factorypattern.pizzas.CheesePizza;
import designlld.factorypattern.pizzas.ChickenPizza;
import designlld.factorypattern.pizzas.ClassicPizza;
import designlld.factorypattern.pizzas.Pizza;

public class NewYorkPizzaStore extends PizzaStore {
    private IngredientsFactory ingredientsFactory = new NewYorkPizzaIngredientFactory();

    @Override
    Pizza createPizza(String pizza) {
        Pizza pizzaToCreate;

        switch (pizza) {
            case "Classic Pizza":
                pizzaToCreate = new ClassicPizza(this.ingredientsFactory).create();
                pizzaToCreate.setName("New York Style Classic Pizza");
                return pizzaToCreate;

            case "Cheese Pizza":
                pizzaToCreate = new CheesePizza(this.ingredientsFactory).create();
                pizzaToCreate.setName("New York Style Cheese Pizza");
                return pizzaToCreate;

            case "Chicken Pizza":
                pizzaToCreate = new ChickenPizza(this.ingredientsFactory).create();
                pizzaToCreate.setName("New York Style Chicken Pizza");
                return pizzaToCreate;

            default:
                return null;
        }
    }
}
