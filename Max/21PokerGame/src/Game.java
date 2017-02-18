import java.util.*;

public class Game {
	private CardPile cardpile;
	private RankBoard rankboard = new RankBoard();
	private int humanAmout;
	private int aiAmout;
	private String name;
	private ArrayList<Player> players = new ArrayList<Player>();
	
	public Game(){
		setGame();
		startGame();
	}
	public void initial(){
		cardpile = new CardPile();
	}
	public void setGame(){
		Scanner scanner = new Scanner(System.in); 
		System.out.println("�]�m���a�ƶq (��ĳ 1�H) :");
		humanAmout = scanner.nextInt();
		System.out.println("�]�m�q���ƶq(��ĳ5�H) :");
		aiAmout = scanner.nextInt();
		for (int i = 0 ; i < humanAmout; i++){
			System.out.println("��J���a" + (i+1) +"���W�r  :");
			name = scanner.next();
			players.add(new Human(name));
		}
		for (int i = 0 ; i < aiAmout; i++){
			players.add(new AI("��"+Integer.toString(i)+"��"));
		}
		 
		 randomPlayer();
		 for (Player player: players){
	        	System.out.println("��  " + players.indexOf(player) + " �쪱�a�� : " +player.getName());
	        }
	}
	private void randomPlayer(){
		for ( int time = 0 ; time < 10 ; time ++ ) 
			for ( int i = 0 ; i < players.size() ; i ++ )  
			{
				int index = new Random().nextInt(players.size());
				Player temp = players.get(i);  
				players.set(i,players.get(index));
				players.set(index,temp);
			}
	}
	public void startGame(){
		boolean stop = false;
		Card cardtemp;
		int totpoint;
		for (int i =0 ; i < 3; i++){
			initial();
			System.out.println("�� " + Integer.toString(i+1) + " �^�X�}�l");
			for(Player player:players){
				System.out.println("���� " + player.getName() +" �F!!");
				totpoint = 0;
				do{
					try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
					cardtemp = cardpile.getCard();
					System.out.println("½�}�F ------- " + cardtemp.getCardType() +
							cardtemp.getCardPoint() );
					stop = player.playGame(cardtemp);
					if(player.getTotPoint() > 21){
						System.out.println("�z�F��!!!!!!!!!!!!");
						stop = true;
					if(cardpile.checkHasCard() == false){
						System.out.println("�S�P�F��~~~�����o�^�X");
						stop = true;
					}
					}
				}while(!stop);
				totpoint = player.getTotPoint();
				System.out.println(player.getName() + "�o�� " + totpoint + "��");
				rankboard.addOnRankBoard(player.getName(), player.getTotPoint());
				
				player.initial();
			}
			rankboard.selectWinner();
			rankboard.sortRank();
		}
		
	}
}
