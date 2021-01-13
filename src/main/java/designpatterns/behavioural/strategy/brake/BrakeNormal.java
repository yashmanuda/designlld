package designpatterns.behavioural.strategy.brake;

public class BrakeNormal implements IBrakeBehaviour {

    @Override
    public void applyBreak() {
        System.out.println("Applying normal break!");
    }
}
