using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _21
{
    class Card
    {
        private string SuitName;
        private string CardNumName;
        private bool Used=false;
        public string CardName;
        public void SetName(string SuitName,string CardNumName) {
            this.SuitName = SuitName;
            this.CardNumName = CardNumName;
            this.CardName = SuitName + CardNumName;
        }
        public bool CheckUsed() {
            if (Used == false)
            {
                Used = true;
                return true;
            }
            return false;

        }
        public bool OnlyCheck()
        {
            if (Used == false)
                return false;
            else
                return true;

        }
        public void ReSet()
        {
            Used = false;
        }

    }
}
