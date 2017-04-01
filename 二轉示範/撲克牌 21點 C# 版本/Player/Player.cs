using PokerCards;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace PokerCardGame
{
    abstract class Player
    {
        public const int OUT_OF_BOUND = -1000;
        public string name { get; set; }
        private List<PokerCard> cards = new List<PokerCard>();

        public Player()
        {
            this.name = getName();
        }

        protected abstract string getName();

        public bool makeChoice()
        {
            Console.WriteLine("Player {0} has {1} point , ", name , getScore() );
            Thread.Sleep(700);
            bool result = chooseReceiveNextCardOrNot();
            Thread.Sleep(600);
            Console.WriteLine("Player {0} choose .. {1} ", name , result);
            Thread.Sleep(400);
            return result;
        }

        protected abstract bool chooseReceiveNextCardOrNot();  // make a choice for a response of whether to receive a next card or not.

        public int getScore()
        {
            int sum = 0;
            foreach (var card in cards)
            {
                sum += (int)card.rank;
                if (sum > 21)
                    return OUT_OF_BOUND;
            }
            return sum;
        }

        public void clearCard()
        {
            cards.Clear();
        }

        public void receiveCard(PokerCard card)
        {
            cards.Add(card);
        }

    }
}
