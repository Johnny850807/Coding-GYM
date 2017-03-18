using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BOOMB
{
    class Ground
    {
        private Boolean Mine=false;
        private Boolean Checked;
        private int AroundMine=0;

        
        public int SetMine(int MineAmount)
        {
            if (Mine == false)
            {
                Mine = true;
                MineAmount--;
            }
            return MineAmount;

        }
        public void AddRound()
        {
            AroundMine ++;
        }
        public int Check(int NotMine)
        {
            if(Checked==true)
            {
                Console.WriteLine("以猜過");
                return NotMine;
            }
            if (Mine) {
                Console.WriteLine("BOOM!! GAME OVER");
                    return 0;
                    }
            Checked=true;
            NotMine--;
            if(NotMine==0)
                Console.WriteLine("YOU WIN!!");
            return NotMine;
        }
        public void Print()
        {
            if (Checked == true)
                Console.Write(Convert.ToString(AroundMine));
            else
                Console.Write('-');

        }
        public void PrintAns()
        {
            if (Mine == true)
                Console.Write('*');
            else
                Console.Write(Convert.ToString(AroundMine));

        }



    }
}
