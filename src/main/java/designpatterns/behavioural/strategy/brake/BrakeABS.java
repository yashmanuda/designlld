package designpatterns.behavioural.strategy.brake;

public class BrakeABS implements IBrakeBehaviour {
    @Override
    public void applyBreak() {
        System.out.println("Applying ABS break!");
    }
}
