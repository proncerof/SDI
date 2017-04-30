using sdi3_14.Cli_REST_CSharp.dto;
using sdi3_14.Cli_REST_CSharp.restService;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace sdi3_14.Cli_REST_CSharp.menu.menuItems
{
    class CreateTaskMenuItem : MainMenuItem
    {

        public CreateTaskMenuItem(RestService restService) : base(restService)
        {
        }


        public override String GetMenuName()
        {
            return "Crear tarea";
        }

        protected override void executeInternal()
        {
            dto.Task tarea = new dto.Task();

            this.setTitle(tarea);
            this.setComments(tarea);
            this.setPlanned(tarea);

            tarea.createdDate = new DateTime();

            long catId = getLongFromUser("Introduzca el Id de la categoria");

            dto.Task t = restService.createTask(tarea, catId);

            if (t == null)
                Console.WriteLine("No se ha podido crear la tarea");
            else
            {
                Console.WriteLine("Tarea creada satisfactoriamente");
                Console.WriteLine(t);
            }

        }

        private void setTitle(dto.Task tarea)
        {
            Console.Write("Introduzca un titulo:");
            tarea.title = Console.ReadLine();
        }

        private void setComments(dto.Task tarea)
        {
            Console.Write("Introduzca un comentario:");
            tarea.comments = Console.ReadLine();
        }

        private void setPlanned(dto.Task tarea)
        {
            DateTime fecha;
            while (true)
            {
                int day = getIntFromUser("Introduzca el dia");
                int month = getIntFromUser("Introduzca el mes");
                int year = getIntFromUser("Introduzca el anio");
                try
                {
                    fecha = new DateTime(year, month, day);
                    break;
                }
                catch (ArgumentOutOfRangeException a)
                {
                    System.Console.WriteLine("El formato de la fecha no es correcto");
                }
            }

            tarea.plannedDate = fecha;
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

        private int getIntFromUser(String message)
        {

            Int32 userInput = -1;

            do
            {
                System.Console.Write(message + ": ");
                String result = Console.ReadLine();

                if (Int32.TryParse(result, out userInput))
                    return userInput;

                System.Console.WriteLine("Formato de numero incorrecto");
            } while (true);

        }

    }
}
