package ButtonCommand;

import Furniture.Light;

public class LightOnCommand implements Command
{
	private Light light;
	
	public LightOnCommand(Light light)
	{
		this.light=light;
	}
	
	@Override
	public void execute() 
	{
		light.turnOn();
	}

	@Override
	public void undo() 
	{
		light.turnOff();
	}
}
