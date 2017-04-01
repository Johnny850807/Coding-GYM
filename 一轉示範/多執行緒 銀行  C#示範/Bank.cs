using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 多執行緒_銀行__示範
{
    class Bank
    {
        public int money { get; set; } = 10000;
        public int outlay { get; set; } = 0;  //放款
        public int income { get; set; } = 10000;  //收入
        private bool _stop = false;
        public bool stop
        {
            get
            {
                if (money <= 0)  //沒錢就停
                    _stop = true;
                return _stop;
            }

            set
            {
                _stop = value;
            }
        }


        public void deposit(int money)
        {
            lock (this)
            {
                this.money += money;
                stop = false;
                income += money;
            }
        }

        public int draw(int money)
        {
            lock (this)
            {
                int result;
                if (this.money < money)
                    result = this.money;
                else
                    result = money;
                this.money -= result;

                outlay += result;

                return result;
            }
            
        }

    }
}
