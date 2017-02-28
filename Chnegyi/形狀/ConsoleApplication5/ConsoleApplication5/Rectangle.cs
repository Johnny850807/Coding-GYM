using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication5
{
    class Rectangle
    {
        public int sideone;
        public int sidetwo;
        public void input() {
            Program main = new Program();
            Console.WriteLine("輸入第一邊");
          sideone= main.consoletoint();
            Console.WriteLine("輸入第二邊");
          sidetwo = main.consoletoint();
        }
        public int getarea()
        {
            return sideone * sidetwo;

        }
      
        
    }
}
