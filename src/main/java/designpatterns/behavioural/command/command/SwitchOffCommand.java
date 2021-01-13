package designpatterns.behavioural.command.command;

import designpatterns.behavioural.command.switchable.ISwitchable;

public class SwitchOffCommand implements ICommand {
    private ISwitchable iSwitchable;

    public SwitchOffCommand(ISwitchable iSwitchable) {
        this.iSwitchable = iSwitchable;
    }

    @Override
    public void execute() {
        iSwitchable.switchOff();
    }
}
