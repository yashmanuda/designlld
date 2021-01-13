package designpatterns.behavioural.strategy.car;

import designpatterns.behavioural.strategy.brake.IBrakeBehaviour;

public abstract class Car {
    private IBrakeBehaviour iBrakeBehaviour;

    Car(IBrakeBehaviour iBrakeBehaviour) {
        this.iBrakeBehaviour = iBrakeBehaviour;
    }

    public void useBreak() {
        iBrakeBehaviour.applyBreak();
    }

    public void setiBrakeBehaviour(IBrakeBehaviour iBrakeBehaviour) {
        this.iBrakeBehaviour = iBrakeBehaviour;
    }
}
