using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 多型
{
    class BothAI:AI
    {
        public BothAI()
        {
            name = "都猜AI";
        }
        public override int GuessReturn(int guessmin, int guessmax)
        {
            AIGuess = RandomGuess.Next(guessmin + 1, guessmax - 1);
            return AIGuess;
        }

    }
}
