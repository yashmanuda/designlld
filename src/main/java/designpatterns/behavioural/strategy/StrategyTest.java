package designpatterns.behavioural.strategy;

import designpatterns.behavioural.strategy.brake.BrakeABS;
import designpatterns.behavioural.strategy.brake.BrakeNormal;
import designpatterns.behavioural.strategy.brake.IBrakeBehaviour;
import designpatterns.behavioural.strategy.car.Car;
import designpatterns.behavioural.strategy.car.Sedan;

public class StrategyTest {
    public static void main(String[] args) {
        IBrakeBehaviour iBrakeBehaviour1 = new BrakeABS();
        IBrakeBehaviour iBrakeBehaviour2 = new BrakeNormal();

        Car car1 = new Sedan(iBrakeBehaviour1);
        car1.useBreak();

        car1.setiBrakeBehaviour(iBrakeBehaviour2);
        car1.useBreak();
    }
}
