package Command;

import Furniture.Fan;
import Furniture.Fan.Status;

public class TurnFanSmallCommand implements Command{
	private Status status;
	private Fan fan;
	
	public TurnFanSmallCommand(Fan fan) {
		status = fan.getStatus();
		this.fan = fan;
	}

	@Override
	public void execute() {
		fan.turnSmall();
	}

	@Override
	public void undo() {
		if (status == Status.LARGE)
			fan.turnLarge();
		else
			fan.turnSmall();
	}

}
