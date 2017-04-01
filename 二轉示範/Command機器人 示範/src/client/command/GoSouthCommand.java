package client.command;

import built_in.MovingItem;
import built_in.Robot;

public class GoSouthCommand extends Command {

	public GoSouthCommand(MovingItem item) {
		super(item);
	}

	@Override
	public void commandMovingRobot() {
		item.walkSouth();
	}


}
