package Command;

import Furniture.Fan;

public class SetFanWindSpeedToSmallCommand implements Command {
    private Fan fan;

    public SetFanWindSpeedToSmallCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void use() {
        fan.turnSmall();
    }

    @Override
    public void undo() {
        fan.turnLarge();
    }
}
