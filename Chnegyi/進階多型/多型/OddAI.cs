using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 多型
{
    class OddAI:AI
    {
        public OddAI()
        {
            name = "奇數AI";
        }
        public override int GuessReturn(int guessmin, int guessmax)
        {

            KeepGuess = true;
            while (KeepGuess)
            {
                AIGuess = RandomGuess.Next(guessmin + 1, guessmax - 1);
                if (AIGuess % 2 == 1)
                    return AIGuess;
                if (guessmin + 2 == guessmax)
                    return guessmin + 1;
            }
            return 0;
        }
    }
}
