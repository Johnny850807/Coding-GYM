using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _21
{
    public abstract class Player
    {
       protected String Name;
        private int Score;
        private int Point=0;
        public abstract bool PlayMethod(int NowScore);
        public  void WriteScore(int NowScore)
        {
            this.Score = NowScore;
        }
        public string GetName() {
            return Name;
        }
        public  int GetPoint()
        {
            
            return Point;
        }
        public void AddPoint()
        {
            Point += 1;
        }
    }
    class CompareByScore : IComparer<Player>
    {
     
        public int Compare(Player a, Player b)
        {
            return b.GetPoint().CompareTo(a.GetPoint());
        }
    }
}
