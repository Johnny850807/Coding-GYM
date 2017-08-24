package RemoteControl;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import ButtonCommand.UndoCommand;
import ButtonCommand.Command;
import ButtonCommand.LightOffCommand;
import ButtonCommand.LightOnCommand;
import ButtonCommand.SwitchTvChannelCommand;
import ButtonCommand.FanTurnLargeCommand;
import ButtonCommand.FanTurnSmallCommand;
import Furniture.Fan;
import Furniture.Light;
import Furniture.Television;

public class RemoteControl 
{
	private Map<String,Command> entityButtonItem = new HashMap<>();
	private Stack<Command> backCommandStack = new Stack<>();
	
	private Light light;
	private Fan fan;
	private Television tv;
	
	private void initButtonItem()
	{
		entityButtonItem.put("1", new LightOnCommand(light));
		entityButtonItem.put("2", new LightOffCommand(light));
		entityButtonItem.put("3", new FanTurnLargeCommand(fan));
		entityButtonItem.put("4", new FanTurnSmallCommand(fan));
		entityButtonItem.put("5", new SwitchTvChannelCommand(tv));
		entityButtonItem.put("6", new UndoCommand(backCommandStack));
	}
	
	
	public RemoteControl(Light light, Fan fan, Television tv)
	{
		this.light = light;
		this.fan = fan;
		this.tv = tv;
		initButtonItem();
	}
	
	public void press(String number)
	{
		Command command = entityButtonItem.get(number);
		if(command !=null)
		{
			command.execute();
			if(!number.equals("6"))
				backCommandStack.push(command);
		}
		else
			throw new CommandException("¾Þ§@¿ù»~");
		
	}
}
