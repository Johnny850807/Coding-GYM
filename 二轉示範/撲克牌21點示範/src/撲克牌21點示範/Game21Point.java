package ���J�P21�I�ܽd;

import java.util.*;

import Player.Player;
import PokeCard.Card;
import PokeCard.DeckStack;

public class Game21Point {
	public final static int MAX_POINT = 21;
	private ArrayList<Player> playerList;
	private DeckStack deck;  //�P��
	private DeckStack discards;  //��P��
	private ConfigurationToGame config;  //�C���]�m
	
	public Game21Point(ConfigurationToGame config){
		this.config = config;
		resetGame();
	}
	
	//��C���]�m�i��I�s�H�Ψ��o�Ҧ��귽
	public void resetGame(){
		config.doAllSettingInput();
		playerList = config.getShuffledPlayerListAndPrintOrder();
		deck = config.getDeck();
		discards = config.getDiscards();
	}
	
	public void startGame(){
		runThreeRoundsGame();
	}
	
	public void runThreeRoundsGame(){
		for ( int i = 0 ; i < 3 ; i ++ )
		{
			System.out.printf("�� %d �^�X�}�l!! %n",i+1);
			oneRoundProcess();
		}

		printFinalRanks();  //�L�X���G
	}
	
	//�C�^�X21�I���J�P
	private void oneRoundProcess(){
		inTurnAllPlayersProcess();    //�C�Ӫ��a���y
		settleWinnerInRound();  //�M�w�ӽ��Ӫ̨üW�[����
		resetRoundPointOfAllPlayers();  //�M�z���b�o�����ƾ�
	}
	
	public void inTurnAllPlayersProcess(){
		for ( Player p : playerList)
			onePlayerAction(p);
	}
	
	//�@�Ӫ��a���^�X
	public void onePlayerAction(Player player){
		boolean choice;
		System.out.printf("���� %s �F !! %n",player);
		do
		{
			reShuffleIfDeckEmpty();  //�p�G�S�P�N���s�~�P
			getNextCard(player);  //���M�N��X�U�@�i�d�ño�����
			if ( player.isHandCardsOutOfBount() )  //�p�G�W�L�d��N���}
				break;
			choice = player.makeChoiceProcess();  //���M���M�w �O�_�A�n�@�i
		} while(choice);
		
		printRoundResult(player);  //�L�X���^�X���G
	}
	
	private void getNextCard(Player player){
		Card card = deck.pop();  //��P
		discards.add(card);  //��J��P��
		player.addHandCard(card);  //��i��P
		System.out.printf("½�}�F ....  %s%n",card);
		delay();
	}
	
	public void reShuffleIfDeckEmpty(){
		delay();
		if ( deck.empty() )
			reShuffle();
	}
	
	private void reShuffle(){
		System.out.println("========�~�P��========");
		discards.shuffleTenTimes();
		deck.addAll(discards);
		discards.clear();
		delay();
	}
	
	private void printRoundResult(Player player){
		delay();
		int point = player.isHandCardsOutOfBount() ? 0 : player.getHandCardsPoint();
		System.out.printf("%s �o��F .. %d��%n",player,point);
	}
	
	private void settleWinnerInRound(){
		Player winner = getRoundWinnter();	//�p��o�^�X���ӧQ��
		printAndRewardWinner(winner);  //�åB�L�X�H�μW�[�ӳӧQ�̤���
	}

	private Player getRoundWinnter(){
		int maxScore = -99;
		Player winner = null;
		for ( Player player : playerList )
		{
			int score = player.getHandCardsPoint();
			if ( score > maxScore )
			{
				maxScore = score;
				winner = player;
			}
		}
		return winner;
	}
	
	private void printAndRewardWinner(Player winner){
		System.out.printf("���^�X�� %s �o��@�� !! %n", winner);  
		winner.win();  //�ӧQ�î���
		delay();delay();
	}
	
	private void printFinalRanks(){
		Collections.sort(playerList, new FinalWinnerComparatorImp());  //�Φۻs�ƧǳW�h�Ƨ�Player��C�A�ϥL�ӵۤ��ư��C��
		System.out.println("�C������!!!!!!");
		for ( int i = 0 ; i < playerList.size() ; i ++ )
			System.out.printf("��%d�W -- %s%n", i+1 , playerList.get(i) );
	}

	//����
	private void delay(){
		try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
	}
	
	//�M�z�Ҧ���P
	private void resetRoundPointOfAllPlayers(){
		for ( Player p : playerList)
			p.clearHandCards();
	}
	
	//�t�d�w�q�ƧǳW�h�����O 
	private final class FinalWinnerComparatorImp implements Comparator<Player> {
		@Override
		public int compare(Player p1, Player p2) {  
			if ( p1.getScore() == p2.getScore() )  //���Ƥ@�˴N�^�� 0  �H�x ����
				return 0;
			if ( p1.getScore() > p2.getScore() )
				return -1;  
			return 1;
		}
	}
	
}
