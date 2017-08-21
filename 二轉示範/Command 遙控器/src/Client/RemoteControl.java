package Client;

import Command.ChangeTvProgramCommand;
import Command.Command;
import Command.TurnFanLargeCommand;
import Command.TurnFanSmallCommand;
import Command.TurnOffLightCommand;
import Command.TurnOnLightCommand;
import Command.UndoCommand;
import Factory.CommandFactory;
import Factory.CommandFactoryImp;
import Furniture.Fan;
import Furniture.Light;
import Furniture.Television;

public class RemoteControl {
	private Light light;
	private Fan fan;
	private Television tv;
	private CommandFactory commandFactory;
	

	public RemoteControl(Light light, Fan fan, Television tv) {
		this.light = light;
		this.fan = fan;
		this.tv = tv;
		commandFactory = new CommandFactoryImp(light, fan, tv);
	}
	
	public void executeCommandNumber(int num){
		Command command = commandFactory.createCommand(num);
		command.execute();
	}
	
	public void printStatus(){
		String lightStatus = light.isTurnOn() ? "開啟" : "關閉";
		System.out.printf("電燈  %s%n電風扇  %s%n電視頻道: %d%n", lightStatus, fan.getStatusToString(), tv.getProgramNumber());
	}
}
