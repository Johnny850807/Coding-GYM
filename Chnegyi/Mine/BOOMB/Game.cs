using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BOOMB
{
    class Game
    {
        private int MineAmount,MapSize;
        Map Map = new Map();
        public Game()
        {
            
            Console.WriteLine("輸入範圍:");
            MapSize = Convert.ToInt32(Console.ReadLine());
            Map.SetMap(MapSize);
            Console.WriteLine("輸入數量:");
            MineAmount = (Convert.ToInt32(Console.ReadLine()));
            while (MineAmount > MapSize * MapSize)
            {
                Console.WriteLine("數量超過範圍請重新輸入:");
                MineAmount = (Convert.ToInt32(Console.ReadLine()));

            }

            Map.SetMine(MineAmount);
        }
        public void StartGame()
        {
            int NotMine = MapSize * MapSize - MineAmount;
            Console.WriteLine("Start Game!!");

            while (NotMine != 0)
            {
                Map.printMap();

                Console.WriteLine("輸入座標:x:");
                int x = Convert.ToInt32(Console.ReadLine());
                Console.WriteLine("輸入座標:y:");
                int y = Convert.ToInt32(Console.ReadLine());
                if (x > MapSize || y > MapSize)
                    Console.WriteLine("範圍外");
                else
                {
                    NotMine=Map.GroundCheck(x, y, NotMine);
                }
            }
            Map.printAns();
     

        }
    }
}
