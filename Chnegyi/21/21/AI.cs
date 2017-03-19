using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _21
{
    class AI:Player
    {
        
        private int LimitScore;
        public AI(string name)
        {
            this.Name = name;
            Random rd = new Random();
            LimitScore = 15 + rd.Next(5);

        }
        public override bool PlayMethod(int NowScore)
        {
            Console.WriteLine("目前分數為" + NowScore + "點");
            if (NowScore <= LimitScore)
            {
                Console.WriteLine(Name+"選擇Hit");
                return false;
            }
            else
            Console.WriteLine(Name + "選擇Stand");
            return true;
            
        }
    }
}
