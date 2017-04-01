using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace 多執行緒_銀行__示範
{
    class Program
    {
        static Bank bank = new Bank();
        static List<Thread> threadList = new List<Thread>();
        public static void Main(string[] args)
        {
            genarateUser();
            while (!bank.stop)
            {
                Thread.Sleep(50);
                foreach (Thread t in threadList)  // Wait for every thread's work done
                    t.Join();
            }

            bank.stop = true;
            int result = bank.income - bank.outlay;

            Console.WriteLine("結論: 總和 {0} - {1} = {2}", bank.income, bank.outlay, result);
            Console.Read();
        }

        private static void genarateUser()
        {
            threadList.Add(new Thread(new User(bank).doWork));
            threadList.Add(new Thread(new User(bank).doWork));
            threadList.Add(new Thread(new User(bank).doWork));
            threadList.Add(new Thread(new User(bank).doWork));
            threadList.Add(new Thread(new User(bank).doWork));
            threadList.Add(new Thread(new User(bank).doWork));

            foreach(Thread t in threadList)
                t.Start();
        }
    }
}
