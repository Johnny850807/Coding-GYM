using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _21
{
    class Game
    {
        private int PlayerAmount;
        private int AIAmount;
        Card[][] Card;
        private List<Player> Player = new List<Player>();
        Suit suit = 0;
        Cardnum Cardnum = 0;
        AIName AIName = 0;
        public Game()
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
        public void SetGame()
        {
            Console.WriteLine("輸入玩家數量");
            PlayerAmount = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("輸入AI數量(1~5)");
            AIAmount = Convert.ToInt32(Console.ReadLine());
            for (int i = 0; i < PlayerAmount; i++)
            {
                Console.WriteLine("輸入玩家" + Convert.ToString(i) + "名子:");
                Player.Add(new Human(Console.ReadLine()));
            }
            for (int i = 0; i < AIAmount; i++)
                Player.Add(new AI((AIName + i).ToString()));
            Washtrun();
        }
        private void Washtrun()
        {
            for (int time = 0; time < 10; time++) //洗牌10次
                for (int i = 0; i < Player.Count; i++)
                {
                    int index = new Random().Next(Player.Count());
                    Player temp = Player[i];
                    Player[i] = Player[index];
                    Player[index] = temp;

                }

        }
        public void StartGame()
        {
            Random rd = new Random();
            int s = 0, c = 0;
            int NowMax = 0;
            int TurnWin = 0;
            bool finish;
            bool NoCard;
            bool getcard;
            int NowScore;
            Console.WriteLine("開始遊戲");
            for (int turn = 0; turn < 10; turn++) {
                Console.WriteLine("--------第" + (turn + 1).ToString() + "輪---------");
                for (int i = 0; i < Player.Count; i++)
                {

                    NowScore = 0;
                    finish = false;
                    Console.WriteLine("輪到" + Player[i].GetName());
                    while (!finish)
                    {
                        NoCard = CheckNoCard();
                        if (NoCard == true)
                        {
                            WashCard();
                            Console.WriteLine("========已從新洗牌========");
                        }
                        getcard = false;
                        while (!getcard)
                        {
                            s = rd.Next(4);
                            c = rd.Next(13);
                            getcard = Card[s][c].CheckUsed();
                        }
                        Console.WriteLine("-----------------------");
                        Console.WriteLine("抽到" + Card[s][c].CardName);


                        NowScore=AddScore(NowScore, c);
                        if (NowScore > 21)
                        {
                            Console.WriteLine("爆了");
                            NowScore = 0;
                            break;
                        }
                        finish = (Player[i].PlayMethod(NowScore));
                    }

                    Player[i].WriteScore(NowScore);
                    if (NowScore > NowMax)
                    {
                        NowMax = NowScore;
                        TurnWin = i;
                    }
                }
                Console.WriteLine("=====此輪勝者為" + Player[TurnWin].GetName()+"======");
                Console.WriteLine("=====================================");
                Player[TurnWin].AddPoint();

            }
            ShowEnd();
        }
        private int AddScore(int NowScore,int c)
        {
            if (c == 0)
            {
                if (NowScore + 11 < 22)
                    NowScore += 11;
                else
                    NowScore += 1;
            }
            else
            {
                if (9 < c && c < 13)
                    NowScore += 10;
                else
                    NowScore += (c + 1);
            }
            return NowScore;
        }
        private bool CheckNoCard() {
            for (int i = 0; i < 4; i++)
                for (int j = 0; j < 13; j++)
                    if (Card[i][j].OnlyCheck() == false)
                        return false;



            return true;

        }
        private void WashCard()
        {
            for (int i = 0; i < 4; i++)
                for (int j = 0; j < 13; j++)
                    Card[i][j].ReSet();
        }

        private void ShowEnd()
        {
            int NO = 0;

            Console.WriteLine("===========遊戲結束===========");
            Console.WriteLine("排名:");
            Player.Sort(new CompareByScore());
            foreach(Player gg in Player)
            {

                NO += 1;
                Console.WriteLine("第"+NO.ToString()+"名:"+gg.GetName()+"分數:"+gg.GetPoint());
            }
     
            
     
        }





    }
 
}
