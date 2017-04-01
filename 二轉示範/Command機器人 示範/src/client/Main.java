package client;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import built_in.*;
import client.command.*;

public class Main {
	static Scanner input = new Scanner(System.in);
	static Scanner parser;
	static MyMap myMap = new MyMap();
	public static void main(String[] args) {
		String text;
		do
		{
			text = input.nextLine();
			if(!text.equals("End"))
				parseItemAndName(text);
		}while(!text.equals("End"));
		do
		{
			text = input.nextLine();
			if(!text.equals("End"))
				parseCommand(text);
		}while(!text.equals("End"));
		
		myMap.printMap();
	}
	
	static void parseItemAndName(String command){
		parser = new Scanner(command);
		String sign = parser.next();
		String name = parser.next();
		myMap.addNamedItem(name, createItem(sign));
	}
	
	static MovingItem createItem(String sign){
		if (sign.charAt(0) == 'R')
			return new Robot(MyMap.MAPSIZE);
		return new Tank(MyMap.MAPSIZE);
	}

	static void parseCommand(String command){
		parser = new Scanner(command);
		String name = parser.next();
		char direction = parser.next().charAt(0);
		
		MovingItem item = myMap.getNamedItem(name);
		myMap.doCommand(createCommand(direction,item));
	}
	
	static Command createCommand(char direction , MovingItem item){
		direction = Character.toUpperCase(direction);
		switch(direction)
		{
		case 'N':
			return new GoNorthCommand(item);
		case 'S':
			return new GoSouthCommand(item);
		case 'E':
			return new GoEastCommand(item);
		case 'W':
			return new GoWestCommand(item);
		default:
			return null;
		}
	}

}
