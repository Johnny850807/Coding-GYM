package ButtonCommand;

import Furniture.Fan;

public class FanTurnSmallCommand implements Command
{
	private Fan fan;
	
	public FanTurnSmallCommand(Fan fan)
	{
		this.fan=fan;
	}

	@Override
	public void execute() 
	{
		fan.turnSmall();
	}

}
