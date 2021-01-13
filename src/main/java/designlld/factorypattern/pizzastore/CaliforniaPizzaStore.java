package designlld.factorypattern.pizzastore;

import designlld.factorypattern.ingredientsfactory.CaliforniaPizzaIngredientFactory;
import designlld.factorypattern.ingredientsfactory.IngredientsFactory;
import designlld.factorypattern.pizzas.ChickenPizza;
import designlld.factorypattern.pizzas.ClassicPizza;
import designlld.factorypattern.pizzas.Pizza;

public class CaliforniaPizzaStore extends PizzaStore {

    private IngredientsFactory ingredientsFactory = new CaliforniaPizzaIngredientFactory();


    @Override
    Pizza createPizza(String pizza) {
        Pizza pizzaToCreate;

        switch (pizza) {
            case "Classic Pizza":
                pizzaToCreate = new ClassicPizza(this.ingredientsFactory).create();
                pizzaToCreate.setName("California Style Classic Pizza");
                return pizzaToCreate;

            case "Chicken Pizza":
                pizzaToCreate = new ChickenPizza(this.ingredientsFactory).create();
                pizzaToCreate.setName("California Style Chicken Pizza");
                pizzaToCreate.setSizeInches(10.0f);
                return pizzaToCreate;

            default:
                return null;
        }
    }
}
