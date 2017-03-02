using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace regist
{
    class Program
    {
        static void Main(string[] args)

        {
            
            bool re = true;
            while (re) {

                Check_line CheckL = new Check_line();
                int LineAmount = CheckL.checkline();
                Check[] Data = new Check[LineAmount];
                regist cintext = new regist();
                for (int i = 0; i < LineAmount; i++)
                    Data[i] = new Check();





                StreamReader fileload = new StreamReader(@"..\..\..\..\..\..\資源區\IO進階登入\帳密.txt", Encoding.Default);
                int num = 0;
                while ((Data[num].account = fileload.ReadLine()) != null)
                {
                    Data[num].input();
                    num++;
                }
                fileload.Close();




                int itype;
                string inputname;
                string inputID;
                string inputpassword;
                bool iend = false;

                Console.WriteLine("(0) 登入 (1) 註冊帳密 (2) 離開:");
                itype = Convert.ToInt32(Console.ReadLine());
                switch (itype)
                {
                    case 0:
                        Console.WriteLine("輸入帳號:");
                        inputID = Console.ReadLine();
                        Console.WriteLine("輸入密碼:");
                        inputpassword = Console.ReadLine();
                        for (int i = 0; i < LineAmount; i++)
                        {
                            if(iend==false)
                           iend=Data[i].Checklogin(inputID, inputpassword);
                        }
                       if(iend==false)
                            Console.WriteLine("無此帳號或帳密不符!!");

                        break;
                    case 1:
                  
                        Console.WriteLine("輸入註冊暱稱:");
                        inputname= Console.ReadLine();
                            Console.WriteLine("輸入註冊帳號:");
                        inputID = Console.ReadLine();  
                        Console.WriteLine("輸入註冊密碼:");
                        inputpassword = Console.ReadLine();

                        for (int i = 0; i < LineAmount; i++)
                        {
                            if (iend == false)
                                iend = Data[i].Checkinput(inputname, inputID);
                        }

                        if (iend == false)
                            cintext.WriteIn(inputname,inputID,inputpassword);
                        break;

                    case 2:
                        re = false;
                        break;
                    default:
                        Console.WriteLine("輸入不正確");
                        break;

                }
            }
        }
    }
}
