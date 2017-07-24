package ���J�P21�I�ܽd;

import java.util.Collections;
import java.util.Random;
import java.util.Stack;

//���ͤ����ƦW�l������
public class NameGenerator {
	private static NameGenerator instance;  //singleton
	private static String[] names = {"�B���@�@","���[","�M��","���Q","����","�Ѥ~��","�׺�","����"
			,"�C�Q","Ĭ����","���j","���}��"};
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
