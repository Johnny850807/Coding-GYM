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
			System.out.println("�п�J���O(1~6)��End����");
			command = sc.nextLine();
			if(command.equals("End"))
			{
				break;
			}
			else{
				new remoteControl().press(RemoteControlButtonItem.buttonList.get(command));
			}
		};
		System.out.println("����");
	}

}
