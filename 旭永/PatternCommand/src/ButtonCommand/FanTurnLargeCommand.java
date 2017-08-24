package ButtonCommand;

import Furniture.Fan;

public class FanTurnLargeCommand implements Command
{
	private Fan fan;
	
	public FanTurnLargeCommand(Fan fan)
	{
		this.fan=fan;
	}

	@Override
	public void execute() 
	{
		fan.turnLarge();
	}

	@Override
	public void undo() {
		fan.turnSmall();
		
	}

}
