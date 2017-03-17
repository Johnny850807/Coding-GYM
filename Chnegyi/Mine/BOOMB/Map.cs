using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BOOMB
{
    class Map
    {

        Ground[][] Ground;
        public int MapSize;


        public void SetMap()
        {
            Ground = new Ground[MapSize][];
            for (int i = 0; i < MapSize; i++)
            {
                Ground[i] = new Ground[MapSize];
                for (int j = 0; j < MapSize; j++)
                    Ground[i][j] = new Ground();
            }

        }
        public void SetMine(int MineAmount)
        {
            Random rd = new Random();
            int x, y;
            while (MineAmount != 0)
            {
                x = rd.Next(MapSize);
                y = rd.Next(MapSize);
                if (Ground[x][y].Mine != true)
                {
                    Ground[x][y].Mine = true;
                    MineAmount--;
                }
            }
        }
        public int GroundCheck(int x, int y,int NotMine)
        {


            if (Ground[x][y].Chcek == true)
                Console.WriteLine("已猜過");
            if (Ground[x][y].Mine != true)
            {
                Ground[x][y].Chcek = true;
                NotMine--;
                if (NotMine == 0)
                    Console.WriteLine("YOU WIN!!");
                return NotMine;
            }
            else
            {
                Console.WriteLine("BOOM!! YOU LOSE");
                return 0;
            }
        }



        public void PrintCheckMap()
        {
            Console.Write(' ');
            for (int x = 0; x < MapSize; x++)
                Console.Write(Convert.ToString(x));
            Console.Write('\n');


            for (int i = 0; i < MapSize; i++)
            {
                Console.Write(Convert.ToString(i));
                for (int j = 0; j < MapSize; j++)
                {

                    if (Ground[i][j].Chcek == true)
                        Console.Write('o');
                    else
                        Console.Write('-');
                }
                Console.Write('\n');
            }
        }
        public void PrintAns()
        {

            Console.Write(' ');
            for (int x = 0; x < MapSize; x++)
                Console.Write(Convert.ToString(x));
            Console.Write('\n');


            for (int i = 0; i < MapSize; i++)
            {
                Console.Write(Convert.ToString(i));
                for (int j = 0; j < MapSize; j++)
                {
                    if (Ground[i][j].Mine == true)
                        Console.Write('*');
                    else
                        Console.Write('o');
                }
                Console.Write('\n');
            }

        }
    }
}

