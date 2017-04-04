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
	 	
		System.out.println("請輸入人類玩家總數");
		
		
		
		Scanner sc_playersnumber =new Scanner(System.in);
		int humancount=sc_playersnumber.nextInt();
		
		
		
		System.out.println("請輸入奇數電腦總數");
		int cardinalAIcount=sc_playersnumber.nextInt();
		
		
		
		System.out.println("請輸入偶數電腦總數");		
		int evenAIcount=sc_playersnumber.nextInt();
		
		player=new Player[humancount+cardinalAIcount+evenAIcount];
		 
		
		
		
			 for(int h=0;h<humancount;h++){
				 int Humannumber=h+1;
				 System.out.println("請輸入玩家"+Humannumber+"名稱");
				 Scanner sc_human_name =new Scanner(System.in);
				 String human_name=sc_playersnumber.next();
				 player[i]=new Human(human_name);
				 i++;
				 }
			 
			 for(int eAI=0;eAI<evenAIcount;eAI++){
				 int AInumber=eAI+1;
				 player[i]=new cardinalAI("偶數AI-"+AInumber+"號");
				 i++;
			 }
			 
			 for(int cAI=0;cAI<cardinalAIcount;cAI++){
				 int AInumber=cAI+1;
				 player[i]=new evenAI("奇數AI-"+AInumber+"號");
				 i++;
			 }
			 
		
			
		 
		 

		 
		 
		 
		 
		 //**洗牌法
	     int i, j;
	        Player player_Shuffle ;         //交換過程中臨時備份用
	        Random r = new Random();               
	        for (i = 0; i < player.length; i++) 
	        {
	            j = r.nextInt(player.length);        //隨機取
	            player_Shuffle = player[j];          //換位子
	            player[j] = player[i];
	            player[i] = player_Shuffle;
	        }
		 
		 
		 
		 
		 
	        
	        
		 System.out.println("總共玩家有"+player.length+"人 , 順序如下");
		 for(int a=0;a<player.length;a++){
		 System.out.print(player[a].name+" , ");
		 }
		 
			Random ran = new Random();
		    password=ran.nextInt(max)+min;
	}
	 	
	 	
	 	void gamestart(){
	 		
	 		System.out.println("\n----------------------------分隔線----------------------------");
	 		
	 		System.out.println("遊戲開始!!!"+min+"到"+max+"開始猜");
	 		
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
	        		
		        	System.out.println(player.name+"猜"+player.guessnumber+"  ,  "+player.guessnumber+"~"+max);
		        	
		        	min=player.guessnumber;
		        	
		        	
		        } else if(player.getguessnumber() >password){
	        		
	    
	        		player.guessnumber=player.getguessnumber();
		         	System.out.println(player.name+"猜"+player.guessnumber+"  ,  "+min+"~"+player.guessnumber);
		         	max=player.guessnumber;
		        }
	        	else if(player.getguessnumber() ==password){
	        		System.out.println(player.name+"猜"+player.getguessnumber());
		         	System.out.println(player.name+"猜到了!!! 密碼是"+player.guessnumber);
		         	
		        }
	        	
	        	
	        }
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	


}
