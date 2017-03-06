using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 多型
{
    class guessgame
    {
        Random rd = new Random();
        public int PlayerAmount;
        private int guessnumber, MaxRange = 10000, MinRange = 0,Ans;
        
         player[] player;

        //開始游戲
        public void play(player[] inputplayer,int inputAmount) {
            Ans = rd.Next(MinRange, MaxRange);
            Console.WriteLine("範圍為0~10000開始遊戲!!");
            player = inputplayer;
            PlayerAmount = inputAmount;
            bool end = false;
            int trun = 0;
            while (!end)
            {
                
                Console.WriteLine("第" + (trun + 1) + "倫");
                //開始一輪
                for (int i = 0; i < PlayerAmount; i++) {
                    //告知範圍
                    Console.WriteLine("目前範圍為" + MinRange + "~" + MaxRange);

                    Console.WriteLine("輪到" + player[i].name + "猜數");
                    guessnumber = player[i].GuessReturn(MinRange, MaxRange);
                    Console.WriteLine(player[i].name + "猜了" + Convert.ToString(guessnumber));
                    if (guessnumber == Ans)
                    {
                        Console.WriteLine("猜中了!!恭喜" + player[i].name);
                        end = true;
                        break;
                    }
                    if (guessnumber < Ans && guessnumber > MinRange)
                        MinRange = guessnumber;
                    if (guessnumber > Ans && guessnumber < MaxRange)
                        MaxRange = guessnumber;                   
                        }
                trun++;
            }

        }


    }
}
