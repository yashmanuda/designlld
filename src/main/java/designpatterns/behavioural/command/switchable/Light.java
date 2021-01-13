package designpatterns.behavioural.command.switchable;

public class Light implements ISwitchable {
    @Override
    public void switchOn() {
        System.out.println("Light is turned on!");
    }

    @Override
    public void switchOff() {
        System.out.println("Light is turned off!");
    }
}
