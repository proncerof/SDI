using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace sdi3_14.Cli_REST_CSharp.menu.menuItems
{
    class LogoutMenuItem : MenuItem
    {
        public IList<MenuItem> Execute()
        {
            IList<MenuItem> items = new List<MenuItem>();

            items.Add(new LoginMenuItem());

            return items;
        }

        public string GetMenuName()
        {
            return "Cerrar sesion";
        }
    }
}
