package Factory;

import Command.Command;

public interface CommandFactory {
	public Command createCommand(int number);
}
