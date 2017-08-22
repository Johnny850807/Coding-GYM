package Button_pack;

import Furniture.Fan;

public class Button_4 extends Button
{
	private Fan f = new Fan();
	
	public Button_4()
	{
		btn_number = "4";		
	}

	@Override
	public void press() 
	{
		f.turnSmall();
	}

}