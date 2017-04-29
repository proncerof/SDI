using sdi3_14.Cli_REST_CSharp.menu;
using sdi3_14.Cli_REST_CSharp.menu.menuItems;
using sdi3_14.Cli_REST_CSharp.restService;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace sdi3_14.Cli_REST_CSharp
{
    class Program
    {
        static void Main(string[] args)
        {
            List<MenuItem> menuItems = new List<MenuItem>();

            RestService restService = new RestService("sdi", "password");

            menuItems.Add(new LoginMenuItem());

            new MenuItemExecutor(menuItems).execute();
        }
    }
}
