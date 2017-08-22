package RemoteControl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import Button_pack.Button;
import Button_pack.Button_1;
import Button_pack.HandleButtonEvent;


public class remoteControl {
	

	public remoteControl()
	{		
		new RemoteControlButtonItem();
	}
	
	public void press(Button button)
	{
		new HandleButtonEvent(button);
	}

}
