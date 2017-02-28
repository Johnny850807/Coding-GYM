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
            StudentData swap = new StudentData();
            StudentData[] students = new StudentData[iAmount];

            for (int i = 0; i < iAmount; i++)
            {
                Console.WriteLine("請輸入第" + (i + 1) + "筆資料:");
                students[i] = new StudentData();
                students[i].input();
            }
            for(int checkone =0; checkone<iAmount;checkone++)
                for(int checktwo=0;checktwo<checkone;checktwo++)
                    if(students[checkone].grades< students[checktwo].grades)
                        {
                            swap = students[checkone];
                        students[checkone] = students[checktwo];
                        students[checktwo] = swap;

                        }
            for(int list = 0; list < iAmount; list++)
            {
                students[list].show();

            }

            Console.Read();
           
        }
        
    }
}
