using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace human
{
    class Program
    {
        static void Main(string[] args)
        {
            bool restart = true;
            while (restart)
            {
                
                Console.WriteLine("輸入男女順序:");
                string GorB = Console.ReadLine();
                
               
                human[] behavior = new  human[GorB.Length];
                


               for(int i = 0; i < GorB.Length; i++)
                {
                    if (GorB[i] == 'B' || GorB[i] == 'b')
                        behavior[i] = new men();
                    else
                        if (GorB[i] == 'G' || GorB[i] == 'g')
                        behavior[i] = new Female();

                }
                for (int talkone = 0; talkone < GorB.Length; talkone++)
                    behavior[talkone].eattalk();
                for (int talktwo = 0; talktwo < GorB.Length; talktwo++)
                    behavior[talktwo].sleeptalk();



                Console.WriteLine("案任意見重複");
                Console.ReadKey();
            }
        }
    }
}
