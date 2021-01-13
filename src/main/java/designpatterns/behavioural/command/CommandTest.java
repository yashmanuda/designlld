package designpatterns.behavioural.command;

import designpatterns.behavioural.command.command.ICommand;
import designpatterns.behavioural.command.command.SwitchOffCommand;
import designpatterns.behavioural.command.command.SwitchOnCommand;
import designpatterns.behavioural.command.switchable.ISwitchable;
import designpatterns.behavioural.command.switchable.Light;
import designpatterns.behavioural.command.switchable.TV;

public class CommandTest {
    public static void main(String[] args) {
        ISwitchable tv = new TV();
        ISwitchable light = new Light();
        Switch switchButton;

        ICommand switchOffCommand = new SwitchOffCommand(tv);
        ICommand switchOnCommand = new SwitchOnCommand(tv);

        switchButton = new Switch(switchOnCommand, switchOffCommand);
        // turning on the tv
        switchButton.turnOn();

        // turning off the tv
        switchButton.turnOff();

        // changing the button function for light
        switchOffCommand = new SwitchOffCommand(light);
        switchOnCommand = new SwitchOnCommand(light);

        switchButton = new Switch(switchOnCommand, switchOffCommand);

        // turning on the light
        switchButton.turnOn();

        // turning off the light
        switchButton.turnOff();

    }
}
