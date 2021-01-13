package designlld.decoratorpattern;

/**
 * Beverage decorator has an instance of beverage that it's going to decorate
 * and the description of the beverage decorator itself.
 * BeverageDecorator is also a beverage. All beverage decorators will extend this class.
 */
abstract class BeverageDecorator extends Beverage {
    Beverage beverage;
    BeverageDescription beverageDescription;

    /**
     * @param beverage            the component that will be decorated
     * @param beverageDescription the description of the decorated
     */
    BeverageDecorator(Beverage beverage, BeverageDescription beverageDescription) {
        super(beverageDescription);
        this.beverage = beverage;
        this.beverageDescription = beverageDescription;
    }

    /**
     * All decorators must override this methodx
     *
     * @return Beverage description of the decorator with instance beverage
     */
    abstract BeverageDescription getDescription();
}
