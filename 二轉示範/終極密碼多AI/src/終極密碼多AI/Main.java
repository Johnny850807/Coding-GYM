package �׷��K�X�hAI;

import java.util.*;

public class Main {

	private static Scanner scanner;

	public static void main(String[] args) {
		List<Player> players = new ArrayList<Player>();
		scanner = new Scanner(System.in);
		GuessGame game = GuessGame.getInstance();
		int playerAmount;
		int aiOddAmount;
		int aiEvenAmount;
		
		System.out.println("��J�X�쪱�a: ");
		playerAmount = scanner.nextInt();scanner.nextLine();
		System.out.println("��J�X��_�ƫ��q�����a: ");
		aiOddAmount = scanner.nextInt();scanner.nextLine();
		System.out.println("��J�X�참�ƫ��q�����a: ");
		aiEvenAmount = scanner.nextInt();scanner.nextLine();
		
		for ( int i = 0 ; i < playerAmount ; i ++ )  // adding three kinds of Player
		{
			System.out.println("��J���a"+(i+1)+"�W�١G");
			String name = scanner.nextLine();
			players.add(new HumanPlayer(name));
		}
		
		for ( int i = 0 ; i < aiOddAmount ; i ++ )
			players.add(new AI_Odd());
		for ( int i = 0 ; i < aiEvenAmount ; i ++ )
			players.add(new AI_Even());
		
		for ( int time = 0 ; time < 10 ; time ++ ) //�~�P10��
			for ( int i = 0 ; i < players.size() ; i ++ )  // �~�P�t��k
			{
				int index = new Random().nextInt(players.size());
				Player temp = players.get(i);  //swap
				players.set(i,players.get(index));
				players.set(index,temp);
			}
		
		System.out.println("���Ǭ� : ");
		for ( Player p : players )
			System.out.print(p + "\n");
		System.out.println();
		do  // game starts
		{
			boolean available;
			for ( int i = 0 ; i < players.size() && !game.isOver() ; i ++ )
			{
				//����1��
				try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
				do{
					System.out.println(game.getStateMessage());  //�L�X�d�򪬪p
					available = game.doGuessingAction(players.get(i));  //�N�C���̶ǤJ�C�����i��q�Ʀr�A�^�ǸӼƦr�O�_�i��
					if (!available)
						System.out.println("��J���~�A�п�J�b�d�򤺡C");
				}while (!available);  //���b
			}
		}while( !game.isOver());

	}

}
