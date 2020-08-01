package Command;

import Furniture.Light;

public class CloseLightCommand implements Command {
    private Light light;

    public CloseLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void use() {
        light.turnOff();
    }

    @Override
    public void undo() {
        light.turnOn();
    }
}
