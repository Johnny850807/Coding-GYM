using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 多型
{
    public abstract class AI:player
    {
        public int AIGuess;
        public Random RandomGuess = new Random();
    }
}
