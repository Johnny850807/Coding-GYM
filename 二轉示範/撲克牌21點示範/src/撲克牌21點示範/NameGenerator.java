package 撲克牌21點示範;

import java.util.Collections;
import java.util.Random;
import java.util.Stack;

//產生不重複名子的機器
public class NameGenerator {
	private static NameGenerator instance;  //singleton
	private static String[] names = {"處鬼昇昇","遠坤","和昌","阿貴","李銓","天才潘","豐緒","祖鳳"
			,"遊利","蘇民楊","雄大","李開輝"};
	protected static Stack<String> participantNames;
	
	private NameGenerator(){
		prepareAllDefaultNames();
	}
	
	public static NameGenerator getInstance(){
		if (instance == null)
			instance = new NameGenerator();
		return instance;
	}
	
	public String nextName(){
		return participantNames.pop();
	}
	
	private void prepareAllDefaultNames(){
		participantNames = new Stack<String>();
		for ( String s : names )
			participantNames.push(s);
		Collections.shuffle(participantNames);
	}
	
}
