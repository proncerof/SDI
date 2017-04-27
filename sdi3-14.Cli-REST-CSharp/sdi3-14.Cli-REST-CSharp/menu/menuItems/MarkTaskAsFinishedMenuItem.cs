using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using sdi3_14.Cli_REST_CSharp.dto;
using sdi3_14.Cli_REST_CSharp.restService;

namespace sdi3_14.Cli_REST_CSharp.menu.menuItems
{
    class MarkTaskAsFinishedMenuItem : MainMenuItem
    {
        public MarkTaskAsFinishedMenuItem(RestService restService, User user) : base(restService, user)
        {
        }

        public override string GetMenuName()
        {
            return "Finalizar una tarea";
        }

        protected override void executeInternal()
        {
            long id = getLongFromUser("Introduzca el id de la tarea");
            restService.markTaskAsFinished(id);
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
