package ButtonCommand;

import java.util.Scanner;

import Furniture.Fan;
import Furniture.Television;

public class SwitchTvChannelCommand implements Command
{
	private Television tv;
	
	public SwitchTvChannelCommand(Television tv)
	{
		this.tv=tv;
	}

	@Override
	public void execute() 
	{
		System.out.println("½Ð¿ï¾ÜÀW¹D:");
		Scanner choose = new Scanner(System.in);
		tv.changeProgram(choose.nextInt());
	}

	@Override
	public void undo()
	{
		tv.changeProgram(tv.getProgramNumber());
	}

}
