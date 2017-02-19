package client.command;

import built_in.MovingItem;
import built_in.Robot;

public abstract class Command {
	protected MovingItem item;
	
	public Command(MovingItem item){
		this.item = item;
	}
	
	public void doCommand(){
	//	System.out.printf("Command type : %s%n" , getClass().getName());
		//System.out.printf(" Before %s  (%d,%d) %n" , item , item.getX() , item.getY() );
		commandMovingRobot();
	//	System.out.printf(" After %s  (%d,%d) %n" , item , item.getX() , item.getY() );
	}
	
	protected abstract void commandMovingRobot();
	
}
