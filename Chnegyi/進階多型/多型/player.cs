using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 多型
{
    public abstract class player
    {
       public string name;
        public abstract int GuessReturn(int guessmin, int guessmax);
        public bool KeepGuess;

    }
}
