using PokerCardGame;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using PokerCards;

namespace PokerCardGame
{
    class PokerCard21Game : PokerGame
    {
        private static PokerCard21Game instance;

        private PokerCard21Game(){}

        public static PokerCard21Game getInstance()  //singleton pattern
        {
            if ( instance == null )
                instance = new PokerCard21Game();
            return instance;
        }


        protected override int getAIAmount()
        {
            Console.WriteLine("Input AI amount : ");
            return int.Parse(Console.ReadLine());
        }

        protected override int getGameRound()
        {
            return 3;
        }

        protected override int getPlayerAmount()
        {
            Console.WriteLine("Input HumanPlayer amount : ");
            return int.Parse(Console.ReadLine());
        }

        protected override void cardsConfig(ref PokerDeck deck, ref PokerDeck discards)
        {
            deck.createAndShuffle();
        }

        protected override void playerConfig(ref List<Player> playerList, int playerAmount, int aiAmount)
        {
            for (int i = 0; i < playerAmount; i++)
                playerList.Add(new HumanPlayer());
            for (int i = 0; i < aiAmount; i++)
                playerList.Add(new AiPlayer());
        }

        protected override void onOnePlayerTurn(Player player)
        {
            do
            {
                poppingDeck(player);
            } while ( player.getScore() != Player.OUT_OF_BOUND && player.makeChoice() ) ;

            if ( player.getScore() == Player.OUT_OF_BOUND )
                Console.WriteLine("Player {0} Boooooooom !!! ", player.name);
        }

        private void poppingDeck(Player player)
        {
            reshuffleDeckIfEmpty();

            var card = deck.pop();
            discards.push(card);
            Console.WriteLine("Player {0} received a card : {1} .", player.name , card);
            player.receiveCard(card as PokerCard);
        }

        private void reshuffleDeckIfEmpty()
        {
            if (deck.isEmpty())
            {
                Console.WriteLine("Deck is empty ... reshuffling ... !! ");
                deck.pushAllCards(discards);
                discards.clear();
            }
        }

        protected override void onScoreCalculate(Dictionary<Player, int> scoreBox)
        {
            int maxScore = playerList.Max(c => c.getScore());
            Player winner = playerList.First(c => c.getScore() == maxScore);
            Console.WriteLine("\nPlayer {0} get the highest score {1} this round !! ", winner.name, maxScore);
            scoreBox[winner] ++ ;
            foreach (var p in playerList)
                p.clearCard();                  
        }

        protected override void onGameOver()
        {
            Console.WriteLine("Game over.");
        }
    }
}
