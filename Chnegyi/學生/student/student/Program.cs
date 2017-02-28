using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace student
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("輸入學生數量");
             int iAmount;
            iAmount = Convert.ToInt32(Console.ReadLine());
            StudentData StuData = new StudentData();
            StuData.amount = iAmount;
            StuData.SetAmount();
            StuData.input();
            Console.Read();
           
        }
        
    }
}
