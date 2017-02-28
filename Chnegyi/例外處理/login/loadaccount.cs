using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;
using System.Text;

namespace login
{
    class loadaccount
    {
       

        public void loadin(string id,string password)
        {
            string accountcheck;
            accountcheck = id + ' ' + password;

        System.IO.StreamReader file =
                new System.IO.StreamReader(@"C:\Users\SterbenFox\Documents\Visual Studio 2015\Projects\login\pass.txt");
           try
            {
                while (true) {
                    if (accountcheck == file.ReadLine())
                    {
                        Console.WriteLine("登入成功");
                        
                    }
                }

            }
            catch
            {
                Console.WriteLine("無此帳號或密碼錯誤");

            }
            file.Close();

        }




    }
}
