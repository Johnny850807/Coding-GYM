package polymorphism_test;

import java.util.Random;
import java.util.Scanner;

public class StartGame {
	
	private Player[] player;
	
	
	private int humancount,evenAIcount,cardinalAIcount;
	
	private static int i=0;
	
	 static int password;

     static int max=1000;
     static int min=1;
     
     static int guessnumber=0;
     
	
	 	void init(){
	 	
		System.out.println("�п�J�H�����a�`��");
		
		
		
		Scanner sc_playersnumber =new Scanner(System.in);
		int humancount=sc_playersnumber.nextInt();
		
		
		
		System.out.println("�п�J�_�ƹq���`��");
		int cardinalAIcount=sc_playersnumber.nextInt();
		
		
		
		System.out.println("�п�J���ƹq���`��");		
		int evenAIcount=sc_playersnumber.nextInt();
		
		player=new Player[humancount+cardinalAIcount+evenAIcount];
		 
		
		
		
			 for(int h=0;h<humancount;h++){
				 int Humannumber=h+1;
				 System.out.println("�п�J���a"+Humannumber+"�W��");
				 Scanner sc_human_name =new Scanner(System.in);
				 String human_name=sc_playersnumber.next();
				 player[i]=new Human(human_name);
				 i++;
				 }
			 
			 for(int eAI=0;eAI<evenAIcount;eAI++){
				 int AInumber=eAI+1;
				 player[i]=new cardinalAI("����AI-"+AInumber+"��");
				 i++;
			 }
			 
			 for(int cAI=0;cAI<cardinalAIcount;cAI++){
				 int AInumber=cAI+1;
				 player[i]=new evenAI("�_��AI-"+AInumber+"��");
				 i++;
			 }
			 
		
			
		 
		 

		 
		 
		 
		 
		 //**�~�P�k
	     int i, j;
	        Player player_Shuffle ;         //�洫�L�{���{�ɳƥ���
	        Random r = new Random();               
	        for (i = 0; i < player.length; i++) 
	        {
	            j = r.nextInt(player.length);        //�H����
	            player_Shuffle = player[j];          //����l
	            player[j] = player[i];
	            player[i] = player_Shuffle;
	        }
		 
		 
		 
		 
		 
	        
	        
		 System.out.println("�`�@���a��"+player.length+"�H , ���Ǧp�U");
		 for(int a=0;a<player.length;a++){
		 System.out.print(player[a].name+" , ");
		 }
		 
			Random ran = new Random();
		    password=ran.nextInt(max)+min;
	}
	 	
	 	
	 	void gamestart(){
	 		
	 		System.out.println("\n----------------------------���j�u----------------------------");
	 		
	 		System.out.println("�C���}�l!!!"+min+"��"+max+"�}�l�q");
	 		
	 		int a=0;
	 		
	 		while(password!= guessnumber){
	 			if(a>=player.length){
	 				a=0;
	 			}
	 			
	 			guesstart(player[a]);
	 			
	 			if(player[a].getguessnumber()==password){
	 				break;
	 			}
	 			a++;
	 
	 		}
	 		
	 	}
	 	
	 	
	 	
	 	
	 	
	 	
	 	void guesstart(Player player){
	 		
	        	player.guess();
	        	
       
	        	if(player.getguessnumber()<password){
	        		
	        		
	        		
	        			        			        		
	        		player.guessnumber=player.getguessnumber();
	        		
		        	System.out.println(player.name+"�q"+player.guessnumber+"  ,  "+player.guessnumber+"~"+max);
		        	
		        	min=player.guessnumber;
		        	
		        	
		        } else if(player.getguessnumber() >password){
	        		
	    
	        		player.guessnumber=player.getguessnumber();
		         	System.out.println(player.name+"�q"+player.guessnumber+"  ,  "+min+"~"+player.guessnumber);
		         	max=player.guessnumber;
		        }
	        	else if(player.getguessnumber() ==password){
	        		System.out.println(player.name+"�q"+player.getguessnumber());
		         	System.out.println(player.name+"�q��F!!! �K�X�O"+player.guessnumber);
		         	
		        }
	        	
	        	
	        }
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	


}
