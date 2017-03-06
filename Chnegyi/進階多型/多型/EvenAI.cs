using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 多型
{
    class EvenAI:AI
    {
        public EvenAI()
        {
            name = "偶數AI";
        }


        public override int GuessReturn(int guessmin, int guessmax)
        {            
            KeepGuess = true;
            while (KeepGuess)
            {
                AIGuess = RandomGuess.Next(guessmin + 1, guessmax - 1);
                if (AIGuess % 2 == 0)
                    return AIGuess;
                if (guessmin + 2 == guessmax)
                    return guessmin + 1;
            }
            return 0;
        }

    }
}
