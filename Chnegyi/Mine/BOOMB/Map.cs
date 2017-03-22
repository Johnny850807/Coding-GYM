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
        private int MapSize;


        public void SetMap(int MapSize)
        {
            this.MapSize = MapSize;
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
                x = rd.Next(MapSize-1);
                y = rd.Next(MapSize-1);
               if( MineAmount != Ground[x][y].SetMine(MineAmount))
                {
                    MineAmount--;
                    for (int i = -1; i <= 1; i++)
                        for (int j = -1; j <= 1; j++)
                            if ((x + i) <= MapSize && (y + j) <= MapSize && (x + i) >= 0 && (y + j) >= 0)
                            {
                                Ground[x + i][y + j].AddRound();
                            }
                }
                    
          
            }
 
        }

        public int GroundCheck(int x,int y,int NotMine)
        {
            NotMine = Ground[x][y].Check(NotMine);
            return NotMine;
        }

        public void printMap()
        {
            Console.Write("  ");
            for(int g=0;g<MapSize;g++)
                Console.Write(Convert.ToString(g));
            Console.Write('\n');
            for (int i = 0; i < MapSize; i++)
            {
                Console.Write(' '+Convert.ToString(i));
                for (int j = 0; j < MapSize; j++)
                    Ground[i][j].Print();
                   
                
                Console.Write('\n');
            }


        }
        public void printAns()
        {
            Console.Write("  ");
            for (int g = 0; g < MapSize; g++)
                Console.Write(Convert.ToString(g));
            Console.Write('\n');
            for (int i = 0; i < MapSize; i++)
            {
                Console.Write(' ' + Convert.ToString(i));
                for (int j = 0; j < MapSize; j++)
                    Ground[i][j].PrintAns();


                Console.Write('\n');
            }

        }
     
    }
}

