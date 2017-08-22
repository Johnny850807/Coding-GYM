package Button_pack;

import java.util.Scanner;

import Furniture.Fan;
import Furniture.Television;

public class Button_5 extends Button
{
	private Television tv = new Television();
	
	public Button_5()
	{
		btn_number = "5";		
	}

	@Override
	public void press() 
	{
		System.out.println("½Ð¿é¤JÀW¹D");
		
		Scanner sc = new Scanner(System.in);
		tv.changeProgram(sc.nextInt());
		System.out.println(tv.getProgramNumber());
	}

}
