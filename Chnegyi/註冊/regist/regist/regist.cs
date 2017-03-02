using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace regist
{
    class regist
    {
        public void WriteIn(string name,string id,string pass){
            
            StreamWriter file  = new StreamWriter(@"..\..\..\..\..\..\資源區\IO進階登入\帳密.txt",true,Encoding.Default);
            file.WriteLine(id+" "+pass+" "+name);
            file.Close();
            Console.WriteLine("註冊成功");
        }

    }
}
