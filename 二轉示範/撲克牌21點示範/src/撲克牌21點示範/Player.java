package 撲克牌21點示範;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

public abstract class Player {
	protected String name = "";
	protected int priority = 0;
	protected int finalGameScore = 0;
	protected int roundScore = 0;
	protected ChoiceStrategy makeChoiceStrategy;
	public static int playerAmount = 0;
	private static String[] names = {"處鬼昇昇","遠坤","和昌","阿貴","李銓","天才潘","豐緒","祖鳳"
			,"遊利","蘇民楊","雄大","李開輝"};
	protected static Stack<String> participantNames;
	
	public Player(ChoiceStrategy makeChoiceStrategy){
		playerAmount++;
		this.makeChoiceStrategy = makeChoiceStrategy;
		if ( participantNames == null )
			prepareAllDefaultNames();
		createName();
	}
	
	private void prepareAllDefaultNames(){
		participantNames = new Stack<String>();
		shuffleDefaultNames();
		for ( String s : names )
			participantNames.push(s);
	}
	
	private void shuffleDefaultNames(){
		Random random = new Random();
		for ( int i = 0 ; i < names.length ; i ++ )
			swapTwoNamesByIndex( i , random.nextInt(names.length));
	}
	
	private void swapTwoNamesByIndex(int i , int j){
		String temp = names[j];
		names[j] = names[i];
		names[i] = temp;
	}
	
	public boolean makeChoiceProcess(){
		System.out.printf("請問  %s 要翻開下一張牌嗎(y/n)? %n",name);
		return makeChoiceToReceiveNextCardOrNot();
	}
	
	private boolean makeChoiceToReceiveNextCardOrNot(){
		return makeChoiceStrategy.makeChoiceToReceiveNextCardOrNot(this);
	}
	
	protected abstract void createName();
	
	@Override
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getFinalGameScore() {
		return finalGameScore;
	}

	public void setFinalGameScore(int finalGameScore) {
		this.finalGameScore = finalGameScore;
	}

	public int getRoundScore() {
		return roundScore;
	}

	public void setRoundScore(int roundScore) {
		this.roundScore = roundScore;
	}
	
	
	
}
