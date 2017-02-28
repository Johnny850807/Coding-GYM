using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication5
{
    class Program
    {
      
        static void Main(string[] args)
        {
            Console.WriteLine("選擇圖形:三角形(1),矩形(2),圓形(3)");
            int iChoice = Convert.ToInt32(Console.ReadLine());
            switch (iChoice)
            {
                case 1:
                    Triangle TriangleArea = new Triangle();
                    TriangleArea.input();                  
                    Console.WriteLine("三角形面積為:" + TriangleArea.getarea());                  
                    break;
                case 2:
                    Rectangle Rectanglearea = new Rectangle();
                    Rectanglearea.input();
                    Console.WriteLine("矩形面積為:" + Rectanglearea.getarea());
                    break;
                case 3:
                    Circle CircleArea = new Circle();
                    CircleArea.input();
                    Console.WriteLine("矩形面積為:" + CircleArea.getarea());
                    break;
                default:
                    Console.WriteLine("Mission Defult");
                    break;
            }
            Console.ReadLine();
        }
        public int consoletoint()
        {

            return Convert.ToInt32(Console.ReadLine());

        }
    }
}
