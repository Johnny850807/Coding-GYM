package CardStack;

import java.util.ArrayList;
import java.util.Collections;

public class CardStack {

	private ArrayList<Card> cardStacks = new ArrayList<>();
	
	public ArrayList<Card> createStack() {
		for (int i = 0; i < 3; i++)
			cardStacks.add(new General());
		for (int i = 0; i < 5; i++)
			cardStacks.add(new Knight());
		for (int i = 0; i < 7; i++)
			cardStacks.add(new Infantry());
		for (int i = 0; i < 6; i++)
			cardStacks.add(new Solider());
	
		Collections.shuffle(cardStacks);
		
		return cardStacks;
	}
	
}
