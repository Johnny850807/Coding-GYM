using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication5
{

    class Triangle
    {   
        public int bottom ;
        public int height ;
        public void input() {
            Program main = new Program();
            Console.WriteLine("輸入底:");
            bottom = main.consoletoint();
            Console.WriteLine("輸入高");
            height = main.consoletoint(); 

        }
        public int getarea() {
            return bottom * height / 2;

        }
      
    }
    
        

}
