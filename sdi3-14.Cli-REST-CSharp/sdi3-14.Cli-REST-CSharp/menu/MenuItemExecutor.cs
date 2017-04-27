using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace sdi3_14.Cli_REST_CSharp.menu
{
    class MenuItemExecutor
    {
        private IList<MenuItem> items;

        public MenuItemExecutor(IList<MenuItem> items)
        {
            this.items = items;
        }

        public void execute()
        {
            while (true)
            {
                // print the options
                System.Console.WriteLine("\nSeleccione una: \n");

                System.Console.WriteLine("0 - Salir");
                System.Console.WriteLine();

                int counter = 0;
                foreach (MenuItem item in items)
                {
                    System.Console.WriteLine(counter + 1 + " - " + item.GetMenuName());
                    counter++;
                }
                // get the user option
                int userOption = getIntFromUser("Opcion");

                if (userOption > items.Count() || userOption < 0)
                {
                    System.Console.WriteLine("Opcion marcada incorrecta");
                }
                else if (userOption == 0)
                {
                    System.Console.WriteLine("Saliendo");
                    break;
                }
                else
                {
                    this.items = items.ElementAt(userOption - 1).Execute();
                    // this.items.add(new ExitMenuItem());
                }
            }
        }

        private int getIntFromUser(String message)
        {
            
            Int32 userInput = -1;

            do {
                System.Console.Write(message + ": ");
                String result = Console.ReadLine();

                if(Int32.TryParse(result, out userInput))
                    return userInput;

                System.Console.WriteLine("Formato de numero incorrecto");
            } while (true);

        }

    }
}
