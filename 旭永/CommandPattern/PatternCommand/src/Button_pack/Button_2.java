package Button_pack;

import Furniture.Light;

public class Button_2 extends Button 
{
	private Light l = new Light();
	
	
	public Button_2()
	{
		btn_number = "2";		
	}

	@Override
	public void press()
	{
		l.turnOff();
	}

}
