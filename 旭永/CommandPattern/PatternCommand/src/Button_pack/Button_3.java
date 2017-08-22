package Button_pack;

import Furniture.Fan;

public class Button_3 extends Button
{
	private Fan f = new Fan();
	
	public Button_3()
	{
		btn_number = "3";		
	}

	@Override
	public void press() 
	{
		f.turnLarge();
	}

}
