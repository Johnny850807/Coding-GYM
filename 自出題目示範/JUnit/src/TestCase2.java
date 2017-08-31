import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import guessgame.AnswerCore;
import junit.framework.TestCase;

@RunWith(Parameterized.class)
public class TestCase2{
	private AnswerCore answerCore;
	private String guess;
	private String result;
	
	public TestCase2(String guess, String result) {
		this.guess = guess;
		this.result = result;
	}

	@Before
	public void setUp() throws Exception {
		answerCore = new AnswerCore("1234");
	}
	
	@Test
	public void test(){
		assertEquals(result, answerCore.guess(guess).toString());
	}
	
	@Parameterized.Parameters
	public static Collection primeNumbers() {
		return Arrays.asList(new Object[][] 
			{ { "1234", "4A0B" }, 
			{ "5678", "0A0B" }, 
			{ "4321", "0A4B" }, 
			{ "1243", "2A2B" }, 
			{ "1563", "1A1B" },
			{ "0915", "0A1B" }});
	}
	
}
