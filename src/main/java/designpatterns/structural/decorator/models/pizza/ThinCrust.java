package designpatterns.structural.decorator.models.pizza;

public class ThinCrust extends Pizza {
    public ThinCrust() {
        description = "Thin Crust Pizza";
    }

    @Override
    public int getCost() {
        return 100;
    }
}
