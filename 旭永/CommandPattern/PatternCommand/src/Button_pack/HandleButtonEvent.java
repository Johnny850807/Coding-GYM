package Button_pack;

import java.util.List;
import java.util.Map;
import java.util.Stack;

public final class HandleButtonEvent 
{
	Button rcb;
	private static Stack<Button> backstack = new Stack<Button>();
	
	public HandleButtonEvent(Button button)
	{
		
		switch(button.btn_number)
		{
		
			case "1":
				rcb = new Button_1();
				break;
			
			case "2":
				rcb = new Button_2();
				break;
			
			case "3":
				rcb = new Button_3();
				break;
				
			case "4":
				rcb = new Button_4();
				break;
				
			case "5":
				rcb = new Button_5();
				break;
				
			case "6":
				if(!backstack.isEmpty())
				{
					rcb = new Button_6(backstack.pop());
				}
				else{
					System.out.println("無法還原了");
					rcb = new Button_Nothing();
				}
				break;
			
		}
		rcb.press();
		if(rcb.btn_number != "6")
		{
			backstack.push(rcb);
		}
	};
}
