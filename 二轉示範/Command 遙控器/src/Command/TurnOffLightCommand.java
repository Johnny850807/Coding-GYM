package Command;

import Furniture.Light;

public class TurnOffLightCommand implements Command{
	private boolean turnOn;
	private Light light;
	
	public TurnOffLightCommand(Light light) {
		turnOn = light.isTurnOn();
		this.light = light;
	}

	@Override
	public void execute() {
		light.turnOff();
	}

	@Override
	public void undo() {
		if (turnOn)
			light.turnOn();
		else
			light.turnOff();
	}

}
