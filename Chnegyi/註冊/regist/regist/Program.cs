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
                accountdata[] Data = new accountdata[LineAmount];
                regist cintext = new regist();
                for (int i = 0; i < LineAmount; i++)
                {

                    Data[i] = new accountdata();
                }


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
                Console.WriteLine("(0) 登入 (1) 註冊帳密 (2) 離開:");
                itype = Convert.ToInt32(Console.ReadLine());
                switch (itype)
                {
                    case 0:
                        bool iend=false;
                        Console.WriteLine("輸入帳號:");
                        inputID = Console.ReadLine();
                        Console.WriteLine("輸入密碼:");
                        inputpassword = Console.ReadLine();
                        for (int i = 0; i < LineAmount; i++)
                        {
                            Data[i].checkpassword = inputpassword;
                            Data[i].checkID = inputID;
                            Data[i].checkandput();
                        }
                        for (int i = 0; i < LineAmount; i++)
                        {
                            if (Data[i].IDCheck && Data[i].PassCheck)
                            {
                                Console.WriteLine("登入成功!!歡迎!!" + Data[i].name);
                                iend = true;
                            }
                            else
                                if (Data[i].IDCheck && Data[i].PassCheck == false)
                            {
                                Console.WriteLine("密碼不符");
                                iend = true;
                            }
                        }
                        if(iend==false)
                            Console.WriteLine("無此帳號或帳密不符");

                        break;
                    case 1:
                        bool inputend = false;
                        Console.WriteLine("輸入註冊暱稱:");
                        inputname= Console.ReadLine();
                            Console.WriteLine("輸入註冊帳號:");
                        inputID = Console.ReadLine();  
                        Console.WriteLine("輸入註冊密碼:");
                        inputpassword = Console.ReadLine();
                        for (int i = 0; i < LineAmount; i++)
                        {
                            if (Data[i].name == inputname)
                            {
                                Console.WriteLine("此暱稱已有人使用!!");
                                inputend = true;
                            }
                            if (Data[i].ID == inputID)
                            {
                                Console.WriteLine("此帳號已有人使用!!");
                                inputend = true;
                            }
                        }
                        if (inputend == false)
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
