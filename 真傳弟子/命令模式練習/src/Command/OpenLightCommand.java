package Command;

import Furniture.Light;

public class OpenLightCommand implements Command {
    private Light light;

    public OpenLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void use() {
        light.turnOn();
    }

    @Override
    public void undo() {
        light.turnOff();
    }
}
