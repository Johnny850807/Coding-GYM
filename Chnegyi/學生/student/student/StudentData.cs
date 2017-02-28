using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace student
{
    class StudentData
    {
        public int amount;
        public string[] height;
        public string[] weight;
        public string[] grades;
        public string[] stuid;
        Program main = new Program();



        public void SetAmount() {
            height = new string[amount+1];
            weight = new string[amount+1];
            grades = new string[amount+1];
            stuid = new string[amount+1];

        }
        public void input()
        {
            for(int iInput = 0; iInput < amount; iInput++)
            {
                Console.WriteLine("輸入第" + (iInput + 1)+ "筆資料");
                Console.WriteLine("身高:");
                height[iInput] = Console.ReadLine();
                Console.WriteLine("體重:");
                weight[iInput] = Console.ReadLine();
                Console.WriteLine("成績:");
                grades[iInput] = Console.ReadLine();
                Console.WriteLine("學號:");
                stuid[iInput] = Console.ReadLine();
              

            }
            for(int iOutput=0; iOutput < amount; iOutput++)
            {
                Console.WriteLine("第"+(iOutput+1)+"筆資料為: 身高:"+height[iOutput]+"體重:"+weight[iOutput]+"成績:"+grades[iOutput]+"學號:"+stuid[iOutput]);

            }

        } 

    }
}
