using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace login
{
    class IDERROR:Exception
    {
        public IDERROR() { }
       
    }
    class ALLERROR:Exception
    {
        public ALLERROR() { }
    }
    class PASSWORDERROR : Exception
    {
        public PASSWORDERROR() { }
    }

}
