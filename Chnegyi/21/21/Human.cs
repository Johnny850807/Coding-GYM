using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _21
{
    class Human:Player
    {
        public Human(string Name) {
            this.Name = Name;
        }

        public override bool PlayMethod(int NowScore)
        {
            string YorN;
            Console.WriteLine("目前分數為" + NowScore + "點");
            Console.WriteLine("是否要牌?(y/n)");
            while (true)
            {
                YorN = Console.ReadLine();
                if (YorN == "y")
                    return false;
                else
                {
                    if (YorN == "n")
                        return true;
                    else
                        Console.WriteLine("輸入無效從新輸入");
                }
            }
        }
    }
}
