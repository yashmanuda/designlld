package designlld.decoratorpattern;

class Mocha extends BeverageDecorator {
    Mocha(Beverage beverage, BeverageDescription beverageDescription) {
        super(beverage, beverageDescription);
    }

    @Override
    BeverageDescription getDescription() {
        String newDescription = this.beverage.getDescription().getName() + " with " + this.getClass().getSimpleName();
        float newCost = this.beverage.getDescription().getCost() + this.beverageDescription.getCost();
        return new BeverageDescription(newDescription, newCost);
    }
}
