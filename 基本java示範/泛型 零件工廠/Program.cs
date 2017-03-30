using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 泛型_零件工廠
{
    class Program
    {
        static void Main(string[] args)
        {

            try
            {
                Factory<Screw, Car> myFactory = new Factory<Screw, Car>();
                myFactory.addComponent(new Screw());
                myFactory.addComponent(new Screw());
                myFactory.addComponent(new Screw());
                var myProduct = myFactory.createProduct();
                Console.WriteLine(myProduct);

                Factory<Box, Robot> myRobotFactory = new Factory<Box, Robot>();
                myRobotFactory.addComponent(new Box());
                myRobotFactory.addComponent(new Box());

                var myProduct2 = myRobotFactory.createProduct();
                Console.WriteLine(myProduct2);
            }
            catch (ResourceLackingException err)
            {
                Console.WriteLine(err.Message);
            }
            


            Console.Read();
        }

    }
}
