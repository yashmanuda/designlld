package designlld.decoratorpattern;

public class Main {
    public static void main(String[] args) {
        // creating two beverages
        Tea tea = new Tea(new BeverageDescription("Tea", 50f));
        Coffee coffee = new Coffee(new BeverageDescription("Coffee", 70f));


        // creating three decorators
        Beverage chocolate = new Chocolate(tea, new BeverageDescription("Chocolate", 5f));
        Beverage mocha = new Mocha(coffee, new BeverageDescription("mocha", 7f));
        Beverage whippedCream = new WhippedCream(mocha, new BeverageDescription("mocha", 7f));


        // decorated once
        System.out.println(chocolate.getDescription().toString());

        // decorated two times
        System.out.println(whippedCream.getDescription().toString());

        // decorated three times
        whippedCream = new Mocha(whippedCream, new BeverageDescription("mocha", 7f));
        System.out.println(whippedCream.getDescription().toString());

    }
}
