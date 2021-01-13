package designpatterns.structural.flyweight;

@FunctionalInterface
interface Order {
    void serve();

    static Order of(String flavourName, int tableNumber) {
        CoffeeFlavour flavour = CoffeeFlavour.getFlavour(flavourName);
        return () -> System.out.println("Serving " + flavour + " to table " + tableNumber);
    }
}