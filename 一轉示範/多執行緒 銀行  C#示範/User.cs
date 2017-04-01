using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace 多執行緒_銀行__示範
{
    class User
    {
        private static Random random = new Random();
        private static string[] NAMES = {"Binzhong","ZongYee","Max","ShengSheng","Fongshu","Waterball","Fireball","ShengFong","WangNing","Fucker"};
        private static int nameIndex = 0;

        private string name;
        private int money = 3000;
        private Bank bank;

        public User(Bank bank)
        {
            this.bank = bank;
        }


        public void doWork()
        {
            if (name == null)
            {
                name = NAMES[++nameIndex % NAMES.Count()]; ;
                Thread.CurrentThread.Name = name;
            }

            while (!bank.stop)
            {
                Thread.Sleep(random.Next(5)*1000);

                if (random.Next(10) % 2 == 0 && money > 0)
                    deposit(random.Next(money));
                else
                    draw(random.Next(6900) + 100);
            }
        }

        private void deposit(int amount)
        {
            Console.WriteLine("User {0} is depositting , Amount : {1} ...", Thread.CurrentThread.Name, amount);
            bank.deposit(amount);
            money -= amount;
        }

        private void draw(int amount)
        {
            int result = bank.draw(amount);
            Console.WriteLine("User {0} is drawing , Amount : {1} ... , Get : {2} ", Thread.CurrentThread.Name, amount, result);
            money += result;
        }

    }
}
