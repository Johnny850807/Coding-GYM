using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace login
{
   class Account
    {
       public  string accountID="123";
       public  string password="567";
        
        public void checkaccount(string inaccount,string inpassword)
        {
            if (inaccount != accountID && password != inpassword)
                throw new Exception ("Allerror");
                
            if (inaccount != accountID)
                throw new Exception("IDerror");

            if (password != inpassword)
                throw new Exception("passworderror");
            Console.WriteLine("成功登入!");


        }
    }
}
