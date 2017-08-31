import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exception.GuessNumberInvalidException;
import guessgame.AnswerCore;
import guessgame.GuessGame;
import guessgame.GuessGame.Callback;
import guessgame.GuessGame.Result;

public class TestCase1{
	private AnswerCore answerCore;
	
	@Before
	public void setup(){
		answerCore = new AnswerCore("1234");
	}
	
	@Test(expected = RuntimeException.class)
	public void test1() {
		answerCore.guess("123");
	}
	
	@Test(expected = RuntimeException.class)
	public void test2() {
		answerCore.guess("43210");
	}
	
	@Test(expected = RuntimeException.class)
	public void test3() {
		answerCore.guess("4444");
	}
	
	@Test(expected = RuntimeException.class)
	public void test4() {
		answerCore.guess(null);
	}
	
}
