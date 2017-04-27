using sdi3_14.Cli_REST_CSharp.dto;
using sdi3_14.Cli_REST_CSharp.restService;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace sdi3_14.Cli_REST_CSharp.menu.menuItems
{
    class ListTaskFromCategoryIdMenuItem : MainMenuItem
    {

        public ListTaskFromCategoryIdMenuItem(RestService restService, User user) : base(restService, user)
        {
        }

        public override String GetMenuName()
        {
            return "Listar tareas de categoria";
        }

        protected override void executeInternal()
        {
            long id = getLongFromUser("Introduzca el id de la categoria");
            List<dto.Task> tasks = restService.getTasksFromCategoryId(id);
            tasks.OrderBy(t => t.planned);

            foreach (dto.Task t in tasks)
                Console.WriteLine(t);
        }


        private long getLongFromUser(String message)
        {

            long userInput = -1;

            do
            {
                System.Console.Write(message + ": ");
                String result = Console.ReadLine();

                if (long.TryParse(result, out userInput))
                    return userInput;

                System.Console.WriteLine("Formato de numero incorrecto");
            } while (true);

        }

    }
}
