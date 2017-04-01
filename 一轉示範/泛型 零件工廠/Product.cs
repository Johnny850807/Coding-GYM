using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 泛型_零件工廠
{
    interface Product
    {
       int getConsumption();
    }

    class Car : Product
    {
        public int getConsumption()
        {
            return 3;
        }
    }

    class Robot : Product
    {
        public int getConsumption()
        {
            return 7;
        }
    }
}
