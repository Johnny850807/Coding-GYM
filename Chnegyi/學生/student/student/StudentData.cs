using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace student
{
    class StudentData
    {
      
        public string height;
        public string weight;
        public int grades;
        public string stuid;
        
   


     
       public void input()
        {
           
                
                Console.WriteLine("身高:");
                height = Console.ReadLine();
                Console.WriteLine("體重:");
                weight = Console.ReadLine();
                Console.WriteLine("成績:");
                grades = Convert.ToInt32(Console.ReadLine());
                Console.WriteLine("學號:");
                stuid = Console.ReadLine();

              

            
           

        } 
        public void show (){

            Console.WriteLine("身高:"+height+"體重:"+weight+"成績:"+grades+"學號:"+stuid);
        }

    }
}
