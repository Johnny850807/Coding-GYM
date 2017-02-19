package client;

import java.util.*;
import built_in.*;
import client.command.Command;

public class MyMap {
	public final static int MAPSIZE = 10;
	private Map<String,MovingItem> itemMap = Collections.checkedMap( 
			new HashMap<String, MovingItem>() , String.class , MovingItem.class);

	public void doCommand(Command command){
		command.doCommand();
	}
	
	public void addNamedItem(String name , MovingItem item){
		itemMap.put(name,item);
	}
	
	public MovingItem getNamedItem(String name){
		return itemMap.get(name);
	}
	
	public void printMap(){
		for ( int i = 0 ; i < MAPSIZE ; i ++ )
		{
			for ( int j = 0 ; j < MAPSIZE ; j ++ )
				System.out.print(getSignInSpecificXY(j,i));
			System.out.println();
		}
	}
	
	public char getSignInSpecificXY(int x , int y){
		Iterator it = itemMap.entrySet().iterator();
		while(it.hasNext())
		{
			Map.Entry entry = (Map.Entry) it.next(); 
			MovingItem item = (MovingItem) entry.getValue();
			if ( item.getX() == x && item.getY() == y )
				return item.getSign();
		}
		return '-';
	}
	
}
