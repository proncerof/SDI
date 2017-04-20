using sdi3_14.Cli_SOAP_Csharp.AdminService;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace sdi3_14.Cli_SOAP_Csharp
{
    class Program
    {
        static void Main(string[] args)
        {
            //IEnumerable<user> users = new AdminServiceClient().findAllUsers();
            int option;
            do
            {
                Console.WriteLine("Administrador");
                Console.WriteLine("\t1- Listar usuarios");
                Console.WriteLine("\t2- Habilitar usuario");
                Console.WriteLine("\t3- Deshabilitar usuario");
                Console.WriteLine("\t4- Eliminar usuario");
                Console.WriteLine("\n\t0- Salir");
                Console.Write("Opcion:");
                option = Convert.ToInt32(Console.ReadLine());
                processOption(option);
            } while (option != 0);
        }

        private static void processOption(int option)
        {
            switch (option)
            {
                case 0:
                    break;
                case 1:
                    Actions.listUsers();
                    break;
                case 2:
                    Actions.enableUser();
                    break;
                case 3:
                    Actions.disableUser();
                    break;
                case 4:
                    Actions.deleteUser();
                    break;
                default:
                    Console.WriteLine("Opcion incorrecta");
                    break;

            }
        }

    }
}
