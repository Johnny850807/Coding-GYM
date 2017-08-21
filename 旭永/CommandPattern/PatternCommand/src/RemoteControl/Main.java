package RemoteControl;

import java.util.Scanner;

import Furniture.Light;

public class Main 
{

	public static void main(String[] args) 
	{
		String command="";
		
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("請輸入指令(1~6)或End結束");
			command = sc.nextLine();
			if(command.equals("End"))
			{
				break;
			}
			else{
				new remoteControl().press(RemoteControlButtonItem.buttonList.get(command));
			}
		};
		System.out.println("結束");
	}

}
