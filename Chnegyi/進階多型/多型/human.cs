using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 多型
{
    class human:player
    {
        private int guessnum; 
      public human(string humanname)
        {
            name = humanname;
        }
        public override int GuessReturn(int guessmin, int guessmax)
        {
            KeepGuess = true;
            while (KeepGuess) {
                Console.WriteLine("請輸入猜數:(" + Convert.ToString(guessmin) + "~" + Convert.ToString(guessmax));
                guessnum = Convert.ToInt32(Console.ReadLine());
                if (guessnum < guessmin || guessnum > guessmax)
                    Console.WriteLine("範圍外請重新輸入");
                else
                    return guessnum;
            }
            return 0;

        }
    }
}
