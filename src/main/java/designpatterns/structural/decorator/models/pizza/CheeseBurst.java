package designpatterns.structural.decorator.models.pizza;

public class CheeseBurst extends Pizza {
    public CheeseBurst() {
        description = "Cheese Burst Pizza";
    }

    @Override
    public int getCost() {
        return 150;
    }
}
