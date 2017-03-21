using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _21
{
    class Cardpile
    {
        Suit suit = 0;
        Cardnum Cardnum = 0;

        Card[][] Card;
        public Cardpile()
        {
            Card = new Card[4][];
            for (int i = 0; i < 4; i++)
            {
                Card[i] = new Card[13];
            }
            for (int i = 0; i < 4; i++)
                for (int j = 0; j < 13; j++)
                {
                    Card[i][j] = new Card();
                    Card[i][j].SetName((suit + i).ToString(), (Cardnum + j).ToString());
                }
        }
        public void CheckNoCard()
        {
            for (int i = 0; i < 4; i++)
                for (int j = 0; j < 13; j++)
                    if (Card[i][j].OnlyCheck() == false)
                        return ;



            WashCard();

        }
        private void WashCard()
        {
            Console.WriteLine("***************已從新洗牌*************");
            for (int i = 0; i < 4; i++)
                for (int j = 0; j < 13; j++)
                    Card[i][j].ReSet();
        }
        public int GetCard( )
        {
            bool getcard = false;
            int s=0, c=0;
            Random rd = new Random();
            while (!getcard)
            {
                s = rd.Next(4);
                c = rd.Next(13);
                getcard = Card[s][c].CheckUsed();
            }
            Console.WriteLine("-------------------------------------");
            Console.WriteLine("抽到" + Card[s][c].CardName);
            return c;

        }

    }
}
