package Polymorphic;
import java.util.ArrayList;
import java.util.Scanner;

public class Main_start {
	
	static Scanner sc;
	static ArrayList<Human>  humanlist;
	static int human_count;

	
	
	public static void main(String[] args) {
		humanlist=new ArrayList<>();
		
		sc=new Scanner(System.in);
		System.out.println("¿é¤J¦r¦ê:");
		 
		String string=sc.nextLine();
		human_count=string.length();
		 
		
		 for(int i=0;i<human_count;i++)
		 {
			 
			 if(string.charAt(i) == 'B' | string.charAt(i) == 'b')
			 {
				 humanlist.add(new Man());
				 
			 }
			 else if(string.charAt(i) == 'G' | string.charAt(i) == 'g')
			 {
				 humanlist.add(new Woman());
				 
			 }
			 
		 }
		 
	
		 dosomething(humanlist);

	}
	
	static void dosomething (ArrayList<Human> human){		

		 for(int i =0;i<human_count;i++)
		 {
//			 human.get(i).sleep();
			 human.get(i).eat();
		 } 
		 
		 for(int i =0;i<human_count;i++)
		 {
//			 human.get(i).eat();
			 human.get(i).sleep();
		 } 
	}

}
