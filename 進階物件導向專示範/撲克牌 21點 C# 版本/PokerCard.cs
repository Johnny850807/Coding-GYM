using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PokerCards
{
    /**
     * The interface to provide services to access poker card info.
     * ***/
    public interface PokerCardItem
    {
        void push(PokerCardItem card);
        PokerCardItem pop();
        void createAndShuffle();
        void printSelf();
    }


    /** Poker card is a subset of PokerDeck , and it represents rank and suit**/
    public class PokerCard : PokerCardItem
    {
        public PokerCardRank rank { get; set; }
        public PokerCardSuit suit { get; set; }

        public PokerCard(PokerCardSuit suit ,PokerCardRank rank)
        {
            this.rank = rank;
            this.suit = suit;
        }

        private string rankToString()
        {
            /** We should get the substring of rank's and should start from one ,
            * because the first character is '_' define in PokerCardRank***/
            return rank.ToString().Substring(1);
        }

        private string suitToString()
        {
            switch (suit)
            {
                case PokerCardSuit.PLUM:
                    return "梅花";
                case PokerCardSuit.DIAMOND:
                    return "菱形";
                case PokerCardSuit.HEART:
                    return "愛心";
                case PokerCardSuit.SPADE:
                    return "黑桃";
            }
            return "None";
        }

        public override string ToString()
        {
            return suitToString() + rankToString();
        }

        public void printSelf()
        {
            Console.Write(this);
        }

        public void createAndShuffle()
        {
            /**shuffle lead to nothing because it's just a card**/
        }

        /**pop , push and shuffle shouldn't be used to the card***/
        public PokerCardItem pop()
        {
            throw new NotImplementedException();
        }

        public void push(PokerCardItem card)
        {
            throw new NotImplementedException();
        }
    }

    /* PokerDeck contains 52 PokerCards , 
     * the deck will be auto-shuffled at the time invoke the constructor
     * if you want to reshuffle the deck from discards deck , should invoke pushAllCards( discards )
     * ***/
    public class PokerDeck : PokerCardItem 
    {
        private Stack<PokerCardItem> cardStack = new Stack<PokerCardItem>();

        public PokerDeck()
        {
            createAndShuffle();
        }

        public PokerCardItem pop()
        {
            return cardStack.Pop();
        }

        public int getLength()
        {
            return cardStack.Count;
        }

        public bool isEmpty()
        {
            return cardStack.Count == 0;
        }

        public void printSelf()
        {
            for (int i = 0 ; i < cardStack.Count ; i ++)
            {
                if (i % 13 == 0)
                    Console.WriteLine();
                cardStack.ElementAt(i).printSelf();
                Console.Write(' ');
            }
        }

        public void push(PokerCardItem card)
        {
            cardStack.Push(card);
        }

        public void createAndShuffle()
        {
            cardStack.Clear();
            pushAllCards(createShuffledCardArray());
        }

        public void pushAllCards(PokerCardItem[] cardArray)
        {
            foreach (PokerCardItem c in cardArray)
                push(c);
        }

        public void pushAllCards(PokerDeck deck)
        {
            foreach (PokerCardItem c in deck)
                push(c);
        }

        public Stack<PokerCardItem>.Enumerator GetEnumerator()
        {
            return cardStack.GetEnumerator();
        }

        public void pushAllCards(PokerCard card)
        {
            push(card);
        }

        public void clear()
        {
            cardStack.Clear();
        }

        private PokerCardItem[] createShuffledCardArray()
        {
            PokerCardItem[] cardArray = new PokerCardItem[52];
            initializeOrderedCards(cardArray);
            shuffleCards(cardArray);
            return cardArray;
        }

        private void initializeOrderedCards(PokerCardItem[] cardArray)
        {
            for (int i = 0; i < 4; i++)
                for (int j = 0; j < 13; j++)
                    cardArray[i * 13 + j] = new PokerCard((PokerCardSuit)i, (PokerCardRank)j);
        }
        
        private void shuffleCards(PokerCardItem[] cardArray)
        {
            Random random = new Random();
            for ( int t = 0; t < 10; t ++ )
                for ( int i = 0; i < cardArray.Length; i ++ )
                     swapTwoCards(ref cardArray[i], ref cardArray[random.Next() % cardArray.Length]);
            }

        private void swapTwoCards(ref PokerCardItem cardA , ref PokerCardItem cardB)
        {
            PokerCardItem temp = cardA;
            cardA = cardB;
            cardB = temp;
        }
    }


    public enum PokerCardSuit
    {
        PLUM , DIAMOND , HEART , SPADE
    }

    public enum PokerCardRank
    {
        _A = 1 , _2, _3 , _4 , _5 , _6 , _7 , _8 , _9 , _10 , _J , _Q , _K
    }

   
}
