package Command;

import Furniture.Fan;

public class SetFanWindSpeedToLargeCommand implements Command {
    private Fan fan;

    public SetFanWindSpeedToLargeCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void use() {
        fan.turnLarge();
    }

    @Override
    public void undo() {
        fan.turnSmall();
    }
}
