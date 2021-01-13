package designlld.decoratorpattern;

abstract class Beverage extends Component<BeverageDescription> {
    private BeverageDescription beverageDescription;

    Beverage(BeverageDescription beverageDescription) {
        this.beverageDescription = beverageDescription;
    }

    BeverageDescription getDescription() {
        return this.beverageDescription;
    }
}
