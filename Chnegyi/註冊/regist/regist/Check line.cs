using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace regist
{
    class Check_line
    {
        private int amount=1;
        
        public int checkline() {
            StreamReader file = new StreamReader(@"..\..\..\..\..\..\資源區\IO進階登入\帳密.txt");
            while (file.ReadLine() != null)
                amount++;
            file.Close();
            return amount;
         }
    }


}
