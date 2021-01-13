package designpatterns.behavioural.command;

import designpatterns.behavioural.command.command.ICommand;

/**
 * This is the invoker class
 * It is unaware of what the commands hold
 * It can only turn on the switch or turn it off
 */
public class Switch {
    private ICommand switchOnCommand;
    private ICommand switchOffCommand;

    public Switch(ICommand switchOnCommand, ICommand switchOffCommand) {
        this.switchOnCommand = switchOnCommand;
        this.switchOffCommand = switchOffCommand;
    }

    public void turnOn() {
        switchOnCommand.execute();
    }

    public void turnOff() {
        switchOffCommand.execute();
    }


}
