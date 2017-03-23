using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PokerCardGame
{
    class HumanPlayer : Player
    {

        protected override string getName()
        {
            Console.WriteLine("Input your name : ");
            return Console.ReadLine().Trim();
        }

        protected override bool chooseReceiveNextCardOrNot()
        {
            Console.WriteLine("Would you like to get the next card ? (y/n)");
            bool result = char.ToUpper(Console.ReadKey().KeyChar) == 'Y';
            Console.WriteLine();
            return result;
        }

    }
}
