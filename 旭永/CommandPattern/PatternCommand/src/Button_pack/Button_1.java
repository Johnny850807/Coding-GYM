package Button_pack;

import Furniture.Light;

public class Button_1 extends Button 
{
	public Button_1()
	{
		btn_number = "1";
	}
	
	private Light l = new Light() ; 
	
	@Override
	public void press() 
	{
		l.turnOn();		
	}
}
