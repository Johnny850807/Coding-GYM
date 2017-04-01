using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using PokerCards;

namespace PokerCardGame
{
    abstract class PokerGame
    {
        private int gameRound;
        protected PokerDeck deck = new PokerDeck();
        protected PokerDeck discards = new PokerDeck();
        protected List<Player> playerList = new List<Player>();
        protected Dictionary<Player, int> scoreBox = new Dictionary<Player, int>();

        public void setupGame()
        {
            gameRound = getGameRound();
            cardsConfig(ref deck , ref discards);
            playerConfig(ref playerList , getPlayerAmount(), getAIAmount());
            disorderPlayerList();
            printPlayerOrder();
            setupScorebox();
        }

        protected abstract int getGameRound();
        protected abstract int getPlayerAmount();
        protected abstract int getAIAmount();
        protected abstract void cardsConfig(ref PokerDeck deck , ref PokerDeck discards);
        protected abstract void playerConfig(ref List<Player> playerList , int playerAmount , int aiAmount);

        private void setupScorebox()
        {
            foreach (var p in playerList)
                scoreBox.Add(p, 0);
        }

        private void disorderPlayerList()
        {
            Random random = new Random();
            for ( int i = 0; i < playerList.Count; i ++ )
            {
                int rand = random.Next() % playerList.Count;

                var temp = playerList[rand];
                playerList[rand] = playerList[i];
                playerList[i] = temp;
            }
        }

        private void printPlayerOrder()
        {
            Console.WriteLine("The order is created as below : ");
            foreach (var p in playerList)
                Console.WriteLine(" =>  {0}  " , p.name );
        }

        public void startGame()
        {
            for (int i = 0; i < gameRound; i++)
            {
                oneGameRound(playerList);
            }

            onScoreRanking(scoreBox);
            onGameOver();
        }


        protected virtual void oneGameRound(List<Player> playerList)
        {
            foreach (var player in playerList)
                onOnePlayerTurn(player);
            onScoreCalculate(scoreBox);
        }

        protected abstract void onOnePlayerTurn(Player player);

        protected abstract void onScoreCalculate(Dictionary<Player, int> scoreBox);

        protected virtual void onScoreRanking(Dictionary<Player, int> scoreBox)
        {

            var rankPlayer = from pair in scoreBox
                             orderby pair.Value  // this will return a ascending rank
                             select new
                             {
                                 name = pair.Key.name
                             };

            int rank = 1;
            foreach (var player in rankPlayer.Reverse())  // reverse it because we need a descending Rank.
                Console.WriteLine("{0}st Player is ... {1} ", rank++ , player.name);
        }

        protected abstract void onGameOver();

    }
}
