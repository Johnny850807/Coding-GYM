using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using PokerCards;
using PokerCardGame;

namespace PokeCard21
{
    class Program
    {
        static void Main(string[] args)
        {
            PokerGame game = PokerCard21Game.getInstance();
            game.setupGame();
            game.startGame();

            Console.Read();
        }
    }
}
