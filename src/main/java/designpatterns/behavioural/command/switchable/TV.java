package designpatterns.behavioural.command.switchable;

public class TV implements ISwitchable {
    @Override
    public void switchOn() {
        System.out.println("TV is turned on!");
    }

    @Override
    public void switchOff() {
        System.out.println("TV is turned off!");
    }
}
