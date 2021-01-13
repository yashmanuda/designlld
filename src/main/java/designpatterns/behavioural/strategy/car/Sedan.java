package designpatterns.behavioural.strategy.car;

import designpatterns.behavioural.strategy.brake.IBrakeBehaviour;

public class Sedan extends Car {
    public Sedan(IBrakeBehaviour iBrakeBehaviour) {
        super(iBrakeBehaviour);
    }
}
