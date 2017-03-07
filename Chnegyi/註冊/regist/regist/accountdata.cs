using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace regist
{
     class accountdata
    {
        public string account;
        string[] splitpoint = new string[3];
        public string name;
        public string ID;
        public string password;


        public void input(){
            string[] splitpoint = account.Split(' ');

            name = splitpoint[2];

            password = splitpoint[1];
            ID = splitpoint[0];
            
            
            }
   
    }
}
