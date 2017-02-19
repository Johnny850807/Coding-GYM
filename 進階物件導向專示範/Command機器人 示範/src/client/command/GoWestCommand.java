package client.command;

import built_in.MovingItem;
import built_in.Robot;

public class GoWestCommand extends Command {

	public GoWestCommand(MovingItem item) {
		super(item);
	}

	@Override
	public void commandMovingRobot() {
		item.walkWest();
	}


}
