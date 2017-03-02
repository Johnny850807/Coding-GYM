using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace login
{
    class Program
    {
        static void Main(string[] args)
        {
            Account data = new Account();
            string cinid;
            string cinpassword;


            while (true)
            {
                Console.WriteLine("輸入帳密:");
                Console.WriteLine("輸入帳號:");
                cinid = Console.ReadLine();
                Console.WriteLine("輸入密碼:");
                cinpassword = Console.ReadLine();
                try
                {
                    data.checkaccount(cinid, cinpassword);
                }
                catch (Exception ex)
                {
                    Console.WriteLine(ex.Message.ToString());
                }
                Console.ReadKey();
            }
        }
    }
}
