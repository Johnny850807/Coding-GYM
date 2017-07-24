package ���J�P21�I�ܽd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import Player.AI_Player;
import Player.HumanPlayer;
import Player.Player;
import PokeCard.DeckStack;
import Strategy.RandomChoice;

public class ConfigurationToGame {
	//�C���]�m�L�{�ʸ˦b�o�����O�A�C���u�ݭn��o�����O�����һݸ귽�Y�i�C
	private static Scanner scanner = new Scanner(System.in);
	private int createPlayerAmount = 1;
	private int createAIAmount = 3;
	private ArrayList<Player> playerList = new ArrayList<Player>();

	//�o�쥴�ö��Ǫ����a��C�H�ΦL�X����
	public ArrayList<Player> getShuffledPlayerListAndPrintOrder(){
		addHumanPlayer();  //���W�[�H�����a
		addAiPlayer();  //�A�W�[AI
		Collections.shuffle(playerList);  //�~�P
		printPlayerListOrder();  //�L�X����
		return playerList;  
	}
	
	private void addHumanPlayer(){
		for ( int i = 0 ; i < createPlayerAmount ; i ++ )
			playerList.add(new HumanPlayer());
	}
	
	private void addAiPlayer(){
		for ( int i = 0 ; i < createAIAmount ; i ++ )
			playerList.add( new AI_Player( new RandomChoice())); //�H���M������AI
	}
	
	private void printPlayerListOrder(){
		System.out.println("���� : ");
		for ( Player p : playerList )
			System.out.print(p+" -> ");
		System.out.println();
	}
	
	public DeckStack getDeck(){
		DeckStack deck = new DeckStack();
		deck.createAndShuffle();
		return deck;
	}
	
	public DeckStack getDiscards(){
		return new DeckStack();
	}
	
	//�I�s�o�Ө�Ƥ~�|�}�l�i���J�]�m�����`��
	public void doAllSettingInput(){
		 inputPlayerAmount();
		 inputAIAmount();
	}
	
	private void inputPlayerAmount(){
		do
		{
			System.out.println("�]�m���a�ƶq(0~10): ");
			createPlayerAmount = scanner.nextInt();
		} while ( createPlayerAmount < 0 || createPlayerAmount > 10 );
		
	}
	
	private void inputAIAmount(){
		int baseBound = 2 - createPlayerAmount < 0 ? 0 : 2 - createPlayerAmount  ;
		int upperBound = 10 - createPlayerAmount;
		do
		{
			System.out.printf("�]�m�q���ƶq(%d~%d): ", baseBound , upperBound);
			createAIAmount = scanner.nextInt();
		} while ( createAIAmount < baseBound || createAIAmount > upperBound );
		
	}
	
	
}
