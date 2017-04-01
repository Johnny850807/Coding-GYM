using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PokerCardGame
{
    class AiPlayer : Player
    {
        private static Random random = new Random();
        private static string[] NAMES = { "Wang" , "ZongYEE" , "FongShu" , "DieFish" , "Waterball" , "APing" , "ZZHoe"
            , "JiaWei" , "LiveFish" , "PokerKing" , "LeeYuanKun" , "BingZhong"}; 

        protected override string getName()
        {
            return NAMES[random.Next() % NAMES.Length];
        }

        protected override bool chooseReceiveNextCardOrNot()
        {
            return random.Next() % 2 == 1;
        }
    }
}
