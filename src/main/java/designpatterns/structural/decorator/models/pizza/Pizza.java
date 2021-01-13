package designpatterns.structural.decorator.models.pizza;

public abstract class Pizza {
    String description;

    public String getDescription() {
        return description;
    }

    public abstract int getCost();
}
