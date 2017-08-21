package Command;

import Exception.NoCommandException;

public class NoCommand implements Command{  //NullObject pattern

	@Override
	public void execute() {
		throw new NoCommandException("沒有指令");
	}

	@Override
	public void undo() {
		throw new NoCommandException("無法還原了");
	}

}
