using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 泛型_零件工廠
{
    class Factory<TComponent, TProduct> 
        where TComponent : Component , new() 
        where TProduct : Product , new()
    {
        private Dictionary<string, int> inventory = new Dictionary<string, int>();

        public void addComponent(TComponent component)
        {
            string key = component.getName();
            if (inventory.ContainsKey(key))
                inventory[key]++;
            else
                inventory.Add(key, 1);
           
        }

        public TProduct createProduct()
        {
            TProduct product = new TProduct();
            string typeName = new TComponent().getName();

            if ( inventory[typeName] >= product.getConsumption() )
            {
                inventory[typeName] -= product.getConsumption();
                return product;
            }

            throw new ResourceLackingException();
        }
    }

    class ResourceLackingException : Exception
    {
        public override string Message
        {
            get
            {
                return "資源不足....";
            }
        }
    }
}
