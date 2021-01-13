package designpatterns.behavioural.command.command;

import designpatterns.behavioural.command.switchable.ISwitchable;

public class SwitchOnCommand implements ICommand {
    private ISwitchable iSwitchable;

    public SwitchOnCommand(ISwitchable iSwitchable) {
        this.iSwitchable = iSwitchable;
    }

    @Override
    public void execute() {
        iSwitchable.switchOn();
    }
}
