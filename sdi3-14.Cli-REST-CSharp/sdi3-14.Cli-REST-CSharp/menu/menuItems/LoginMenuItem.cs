using sdi3_14.Cli_REST_CSharp.dto;
using sdi3_14.Cli_REST_CSharp.restService;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace sdi3_14.Cli_REST_CSharp.menu.menuItems
{
    class LoginMenuItem : MenuItem
    {
        private RestService restService;

        public LoginMenuItem(RestService restService)
        {
            this.restService = restService;
        }

        public String GetMenuName()
        {
            return "Iniciar sesion";
        }

        public IList<MenuItem> Execute()
        {
            List<MenuItem> items = new List<MenuItem>();

            Console.Write("Introduce tu login:");
            String login = Console.ReadLine();

            Console.Write("Introduce tu contrasenia:");
            String password = Console.ReadLine();

            restService = new RestService(login, password);

            User user = restService.login();

            if (user != null)
            {
                items.Add(new ListCategoriesMenuItem(restService, user));
                items.Add(new ListTaskFromCategoryIdMenuItem(restService, user));
                items.Add(new CreateTaskMenuItem(restService, user));
                items.Add(new MarkTaskAsFinishedMenuItem(restService, user));

                Console.WriteLine("Login correcto");

            }
            else
            {
                items.Add(this);
                Console.WriteLine("Login incorrecto o servidor no accesible");
            }

            return items;
        }
    }
}
