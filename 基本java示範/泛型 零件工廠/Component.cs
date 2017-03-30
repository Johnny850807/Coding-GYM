using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 泛型_零件工廠
{
    interface Component
    {
        string getName();
    }

    class Screw : Component
    {
        public string getName()
        {
            return this.GetType().Name;
        }
    }

    class Box : Component
    {
        public string getName()
        {
            return this.GetType().Name;
        }
    }

    class Module : Component
    {
        public string getName()
        {
            return this.GetType().Name;
        }
    }
}
