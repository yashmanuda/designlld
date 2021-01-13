package designpatterns.behavioural.strategy.car;

import designpatterns.behavioural.strategy.brake.IBrakeBehaviour;

public class SUV extends Car {
    SUV(IBrakeBehaviour iBrakeBehaviour) {
        super(iBrakeBehaviour);
    }
}
