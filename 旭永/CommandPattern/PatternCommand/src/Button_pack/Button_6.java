package Button_pack;

import Furniture.Fan;

public class Button_6 extends Button
{
	Button b;
	
	public Button_6()
	{
		btn_number = "6";		
	}
	
	public Button_6(Button b)
	{
		this.b=b;
		btn_number = "6";		
	}

	@Override
	public void press() 
	{
		b.press();
	}

}
