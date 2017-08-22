package RemoteControl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Button_pack.Button;
import Button_pack.Button_1;
import Button_pack.Button_2;
import Button_pack.Button_3;
import Button_pack.Button_4;
import Button_pack.Button_5;
import Button_pack.Button_6;

public class RemoteControlButtonItem
{
	public static Map<String,Button> buttonList = new HashMap<>();
	
	public RemoteControlButtonItem()
	{
		buttonList.put("1",new Button_1());
		buttonList.put("2",new Button_2());
		buttonList.put("3",new Button_3());
		buttonList.put("4",new Button_4());
		buttonList.put("5",new Button_5());
		buttonList.put("6",new Button_6());
	}

}
