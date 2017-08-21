package Factory;

import java.util.Stack;

import Command.ChangeTvProgramCommand;
import Command.Command;
import Command.NoCommand;
import Command.TurnFanLargeCommand;
import Command.TurnFanSmallCommand;
import Command.TurnOffLightCommand;
import Command.TurnOnLightCommand;
import Command.UndoCommand;
import Furniture.Fan;
import Furniture.Light;
import Furniture.Television;

public class CommandFactoryImp implements CommandFactory{
	private Stack<Command> commandStack = new Stack<Command>();
	private Light light;
	private Fan fan;
	private Television tv;
	
	public CommandFactoryImp(Light light, Fan fan, Television tv) {
		this.light = light;
		this.fan = fan;
		this.tv = tv;
	}

	@Override
	public Command createCommand(int number) {
		number -= 1; // 1-based
		Command command;
		switch(number)
		{
		case 0:
			command = new TurnOnLightCommand(light);
			break;
		case 1:
			command =  new TurnOffLightCommand(light);
			break;
		case 2:
			command =  new TurnFanLargeCommand(fan);
			break;
		case 3:
			command =  new TurnFanSmallCommand(fan);
			break;
		case 4:
			command =  new ChangeTvProgramCommand(tv);
			break;
		default:
			return new UndoCommand(popCommandFromHistory());
		}
		commandStack.add(command);
		return command;
	}
	
	private Command popCommandFromHistory(){
		if (commandStack.size() == 0)
			return new NoCommand();
		return commandStack.pop();
	}

}
