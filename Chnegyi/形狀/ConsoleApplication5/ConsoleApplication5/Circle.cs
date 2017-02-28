using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication5
{
    class Circle
    {

        public Double radius;
        public void input()
        {
            Console.WriteLine("輸入半徑:");
            radius = consoletoint();


        }
        public double getarea()
        {
            return radius*radius*3.14;

        }
        private Double consoletoint()
        {

            return Convert.ToDouble(Console.ReadLine());

        }
    }
}
