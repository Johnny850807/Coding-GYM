package Command;

import Furniture.Light;

public class TurnOnLightCommand implements Command{
	private boolean turnOn;
	private Light light;
	
	public TurnOnLightCommand(Light light) {
		turnOn = light.isTurnOn();
		this.light = light;
	}

	@Override
	public void execute() {
		light.turnOn();
	}

	@Override
	public void undo() {
		if (turnOn)
			light.turnOn();
		else
			light.turnOff();
	}

}
