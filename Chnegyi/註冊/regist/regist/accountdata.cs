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
        public string checkID;
        public string checkpassword;
        public bool IDCheck;
        public bool PassCheck;


        public void input(){
            
            string[] splitpoint=account.Split(' ');
            ID = splitpoint[0];
            password = splitpoint[1];
            name = splitpoint[2];
            
            
            }
        public void checkandput()
        {

            if (ID == checkID)
                IDCheck = true;
            if (password == checkpassword)
               PassCheck = true;


        }

    }
}
