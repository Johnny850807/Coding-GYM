package client.command;

import built_in.MovingItem;
import built_in.Robot;

public class GoEastCommand extends Command {

	public GoEastCommand(MovingItem item) {
		super(item);
	}

	@Override
	public void commandMovingRobot() {
		item.walkEast();
	}

}
