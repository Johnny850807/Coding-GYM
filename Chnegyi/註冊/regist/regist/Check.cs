using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace regist
{

    class Check:accountdata
    {
        public bool Checkinput(string inputname,string inputID)
        {
            
                if (name == inputname)
                {
                    Console.WriteLine("此暱稱已有人使用!!");
                    return  true;
                }
                else
                if (ID == inputID)
                {
                    Console.WriteLine("此帳號已有人使用!!");
                    return  true;               
                }
                else
                return false;
            

        }
        public bool Checklogin(string inputID,string inputpassword)
        {

            if (ID == inputID)
            {
                if (password == inputpassword)
                {
                    Console.WriteLine("登入成功!!歡迎!!" + name);
                    return true;
                }
                else
                    Console.WriteLine("密碼錯誤!!");
                return true;
            }
            else
                return false;
                
         



        }

    }
}
