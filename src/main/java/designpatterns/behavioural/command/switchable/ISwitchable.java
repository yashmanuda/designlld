package designpatterns.behavioural.command.switchable;

/**
 * This is the receiver that receives the action based on the command
 */
public interface ISwitchable {
    void switchOn();

    void switchOff();
}
