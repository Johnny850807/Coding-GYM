package 二十一點遊戲;
import java.util.Stack;
public class Deck implements Poker{
	private Stack<Card> cards;
	public Deck()
	{
		cards = new Stack<Card>();
		for(int suit=1,number=0;suit<=4;suit++)
		{
			for(int rank=1;rank<=13;rank++)
			{
				cards.push(new Card(suit,rank));
				number++;
			}
		}
	}
	public void Shuffle()
	{
		for(int j=0;j<10;j++)
		{
			for(int i=0;i<cards.size();i++)
			{
				int ran = (int)(Math.random()*cards.size());
				Card temp = cards.get(i);
				cards.set(i, cards.get(ran));
				cards.set(ran, temp);
			}
		}
	}
	public void sort()
	{
		for(int i=0;i<cards.size();i++)
		{
			for(int j=0;j<cards.size();j++)
			{
				if(cards.get(i).compare(cards.get(j)) == cards.get(j))
				{
					Card temp = cards.get(i);
					cards.set(i, cards.get(j));
					cards.set(j, temp);
				}
			}
		}
	}
	public Card pop()
	{
		return cards.pop();
	}
	public void push(Card card)
	{
		cards.push(card);
	}
	public boolean is_empty()
	{
		return cards.isEmpty();
	}
	@Override
	public String print()
	{
		String temp="";
		for(int number=0;number<cards.size();number++)
		{
			
			temp+= cards.elementAt(number).print() + "\n";
		}
		return temp;
	}
}
