package client.command;

import built_in.MovingItem;
import built_in.Robot;

public class GoNorthCommand extends Command {

	public GoNorthCommand(MovingItem item) {
		super(item);
	}

	@Override
	public void commandMovingRobot() {
		item.walkNorth();
	}


}
