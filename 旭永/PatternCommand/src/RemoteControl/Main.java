package RemoteControl;

import java.util.EmptyStackException;
import java.util.Scanner;

import Furniture.Fan;
import Furniture.Light;
import Furniture.Television;

public class Main 
{
	public static void main(String[] args) 
	{
		RemoteControl remotecontrol = new RemoteControl(new Light(),new Fan(),new Television());
		Scanner input = new Scanner(System.in);
		String choose;
		boolean isend;
		
		do{
			System.out.println("�п�J���O(1~6)��End����");
			choose = input.nextLine();
			isend = choose.equals("end");
				if(!isend)
				{
					try{
						remotecontrol.press(choose);
					} catch(CommandException ex) {
						System.out.println(ex.getMessage());
					}
				}
		}
		while(!isend);
		
		System.out.println("����");
	}

}
