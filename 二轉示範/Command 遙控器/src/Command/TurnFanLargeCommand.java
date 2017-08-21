package Command;

import Furniture.Fan;
import Furniture.Fan.Status;

public class TurnFanLargeCommand implements Command{
	private Status status;
	private Fan fan;
	
	public TurnFanLargeCommand(Fan fan) {
		status = fan.getStatus();
		this.fan = fan;
	}

	@Override
	public void execute() {
		fan.turnLarge();
	}

	@Override
	public void undo() {
		if (status == Status.LARGE)
			fan.turnLarge();
		else
			fan.turnSmall();
	}

}
