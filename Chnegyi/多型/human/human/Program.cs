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
                int next = 0;
                char iJudge;
                men menbehavior = new men();
                Female girlbehavior = new Female();
                


                while (next != GorB.Length)
                {
                    iJudge = GorB[next];
                    if (iJudge == 'B' || iJudge == 'b')
                        menbehavior.eattalk();
                    if (iJudge == 'g' || iJudge == 'G')
                        girlbehavior.eattalk();
                    next++;
                    
                }
                next = 0;

                while (next !=GorB.Length)
                {
                    iJudge = GorB[next];
                    if (iJudge == 'B' || iJudge == 'b')
                        menbehavior.sleeptalk();
                    if (iJudge == 'g' || iJudge == 'G')
                        girlbehavior.sleeptalk();
                    next++;
                }
                next = 0;

                Console.WriteLine("案任意見重複");
                Console.ReadKey();
            }
        }
    }
}
