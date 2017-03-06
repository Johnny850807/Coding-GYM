using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 多型
{
    class Program
    {
        static void Main(string[] args)
        {
            while(true)
            {
                player[] player;
                int OddAmount, EvenAmount, BothAmount, PlayerAmount, HumanAmount;
                guessgame startgame= new guessgame();

            //輸入資料
            Console.WriteLine("輸入人類玩家數量:");
            HumanAmount = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("輸入奇數AI數量:");
            OddAmount = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("輸入偶數AI數量:");
            EvenAmount = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("輸入都猜AI數量:");
            BothAmount = Convert.ToInt32(Console.ReadLine());
            PlayerAmount = OddAmount + EvenAmount + HumanAmount + BothAmount;
            player = new player[PlayerAmount];
            int i = 0;
            //填入陣列
            for (; i < HumanAmount; i++)
            {

                Console.WriteLine("輸入玩家姓名:");
                player[i] = new human(Console.ReadLine());
            }
            for (; (i - HumanAmount) < OddAmount; i++)
                player[i] = new OddAI();
            for (; ((i - HumanAmount) - OddAmount) < BothAmount; i++)
                player[i] = new BothAI();
            for (; (((i - HumanAmount) - OddAmount) - BothAmount) < EvenAmount; i++)
                player[i] = new EvenAI();
            //洗牌
            player temp;
            Random rd = new Random();
            int index;
            for (int wash = 0; wash < 20; wash++)
            {
                for (i = 0; i < PlayerAmount; i++)
                {
                    index = rd.Next(0, PlayerAmount - 1);
                    if (index != i)
                    {
                        temp = player[i];
                        player[i] = player[index];
                        player[index] = temp;
                    }
                }
            }
            //列出順序
            Console.WriteLine("順序為:");
            
            for (i = 0; i < PlayerAmount; i++)
                Console.WriteLine(player[i].name);
           //開始遊戲               
                startgame.play(player,PlayerAmount);
           //遊戲結束
            Console.WriteLine("案任意鍵重新");
            Console.ReadKey();
        }

        }
    }
}
